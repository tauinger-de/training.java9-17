package util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tracer implements AutoCloseable {
	private static final StackWalker walker = StackWalker.getInstance();
	private static int indent;
	private final String name;
	private Object value;
	public Tracer(Object... args) {
		StackWalker.StackFrame frame = walker.walk(s -> s.limit(2).collect(Collectors.toList())).get(1);
		this.name = frame.getClassName() + "." + frame.getMethodName();
		Stream<String> stream = Arrays.stream(args).map(arg -> String.valueOf(arg));
		String argString = String.join(", ", stream.collect(Collectors.toList()));
		this.trace(">> " + name + "(" + argString + ")");
		indent++;
	}
	public void trace(String msg) {
		for(int i = 0; i < indent; i++)
			System.out.print("\t");
		System.out.println(msg);
	}
	public <T> T value(T value) {
		this.value = value;
		return value;
	}
	@Override
	public void close() {
		indent--;
		String s = this.value == null ? "" : " -> " + String.valueOf(this.value);
		this.trace("<< " + name + s);
	}
}