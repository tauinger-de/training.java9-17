package appl;

import jj.util.log.Log;

public class Application {
	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}

	// @SuppressWarnings("removal")
	static void demo1() {
		Log.logMethodCall();
		String s = "alpha %s beta %d";
		String s1 = String.format(s, "Hello", 42);
		System.out.println(s1);
		String s2 = s.formatted("Hello", 42);
		System.out.println(s2);
	}

	// @SuppressWarnings("removal")
	static void demo2() {
		Log.logMethodCall();
		String s = "  alpha    \n    beta";
		System.out.println(s);
		System.out.println(s.stripIndent());
	}

	// @SuppressWarnings("removal")
	static void demo3() {
		Log.logMethodCall();
		String s = "alpha    \\n  \\t   beta";
		System.out.println(s);
		System.out.println(s.translateEscapes());
	}
}