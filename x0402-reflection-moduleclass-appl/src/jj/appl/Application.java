package jj.appl;

import java.lang.annotation.Annotation;
import java.lang.module.ModuleDescriptor;
import java.util.Set;

import jj.mod.pub.Foo;
import jj.util.log.Log;

public class Application {
	public static void main(String[] args) throws Exception {
		demoGetModule();
		demoGetModulePrimitives();
		demoGetModuleSystemClasses();
		demoGetModuleArrays();
		demoGetAnnotations();
		demoCanRead();
		demoGetPackages();
		demoGetDescriptor();
	}

	static void demoGetModule() throws Exception {
		Log.logMethodCall();
		final Module m1 = Foo.class.getModule();
		final Module m2 = Class.forName("jj.mod.pri.Bar").getModule();
		System.out.println(m1 == m2);
		System.out.println(m1.getName());
		System.out.println(m1.isNamed());
	}
	
	static void demoGetModulePrimitives() {
		Log.logMethodCall();
		System.out.println(int.class.getModule().getName());
		System.out.println(void.class.getModule().getName());
	}
	
	static void demoGetModuleSystemClasses() {
		Log.logMethodCall();
		System.out.println(String.class.getModule().getName());
		System.out.println(java.sql.Connection.class.getModule().getName());
		System.out.println(javax.xml.stream.XMLEventReader.class.getModule().getName());
	}

	static void demoGetModuleArrays() {
		Log.logMethodCall();
		System.out.println(int[].class.getModule().getName());
		System.out.println(Foo[].class.getModule().getName());
	}
		
	static void demoGetAnnotations() {
		Log.logMethodCall();
		final Annotation[] annotations = Foo[].class.getModule().getAnnotations();
		for(final Annotation annotation : annotations)
			System.out.println(annotation);
	}
	static void demoCanRead() {
		Log.logMethodCall();
		final Module mod = Foo.class.getModule();
		final Module appl = Application.class.getModule();
		System.out.println(appl.canRead(mod));
		System.out.println(mod.canRead(appl));
	}	
	static void demoGetPackages() {
		Log.logMethodCall();
		final Module mod = Foo.class.getModule();
		final Module appl = Application.class.getModule();
		final Set<String> packages = mod.getPackages();
		packages.forEach(p -> { 
			System.out.println(p);
			System.out.println("\t" + mod.isExported(p));
			System.out.println("\t" + mod.isExported(p, appl));
			System.out.println("\t" + mod.isOpen(p));
			System.out.println("\t" + mod.isOpen(p, appl));
		});
	}
	static void demoGetDescriptor() {
		Log.logMethodCall();
		final ModuleDescriptor descr = Foo.class.getModule().getDescriptor();
		System.out.println(descr.name());
		System.out.println("exports:");
		final Set<ModuleDescriptor.Exports> exports = descr.exports();
		exports.forEach(export -> System.out.println("\t" + export.source() + " => " +
				export.targets()));
		System.out.println("opens:");
		final Set<ModuleDescriptor.Opens> opens = descr.opens();
		opens.forEach(open -> System.out.println("\t" + open.source() + " => " + open.targets()));
	}
}
