package appl;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class FooInvokerGenerator implements Opcodes {

	private final static String fooInvokerClassName = "appl/FooInvoker"; // will be generated
	private final static String fooCallSitesClassName = "appl/FooCallSites";

	public byte[] generate() throws Exception {

		final ClassWriter cw = new ClassWriter(0);

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, fooInvokerClassName, null, "java/lang/Object", null);

		this.generateParameterlessConstructor(cw);
		this.generateMain(cw);

		cw.visitEnd();

		return cw.toByteArray();
	}

	private void generateMain(final ClassWriter cw) {
		
		final MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();
		final MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
				MethodType.class);
		final String descriptorString = mt.toMethodDescriptorString();

		final Handle bootstrapAlpha = new Handle(Opcodes.H_INVOKESTATIC, fooCallSitesClassName, "bootstrapAlpha",
				descriptorString, false);
		final Handle bootstrapBeta = new Handle(Opcodes.H_INVOKESTATIC, fooCallSitesClassName, "bootstrapBeta",
				descriptorString, false);
		final Handle bootstrapGamma = new Handle(Opcodes.H_INVOKESTATIC, fooCallSitesClassName, "bootstrapGamma",
				descriptorString, false);

		for (int i = 0; i < 5; i++) {
			mv.visitInvokeDynamicInsn("bootstrap-Alpha", "()V", bootstrapAlpha);
		}
		for (int i = 0; i < 5; i++) {
			mv.visitIntInsn(BIPUSH, i);
			mv.visitInvokeDynamicInsn("bootstrap-Beta", "(I)V", bootstrapBeta);
		}
		for (int i = 0; i < 5; i++) {
			mv.visitIntInsn(BIPUSH, i);
			mv.visitIntInsn(BIPUSH, i * 10);
			mv.visitInvokeDynamicInsn("bootstrap-Gamma", "(II)V", bootstrapGamma);
		}
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 1);
		mv.visitEnd();
	}

	private void generateParameterlessConstructor(final ClassWriter cw) {
		final MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(RETURN);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
	}

	public static void main(String[] args) throws Exception {
		final File file = new File("bin/" + fooInvokerClassName + ".class");
		try (final FileOutputStream fos = new FileOutputStream(file)) {
			final FooInvokerGenerator generator = new FooInvokerGenerator();
			final byte[] bytes = generator.generate();
			fos.write(bytes);
		}
	}
}
