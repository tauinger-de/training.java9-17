package jj.appl;

import java.util.Optional;

import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoGet();
		demoOrElseThrow();
		demoOrElseThrowWithSUpplier();
	}

	static void demoGet() {
		Log.logMethodCall();
		try {
			Optional<String> string1 = Optional.of("Hello");
			if (string1.isPresent()) {
				String s = string1.get();
				System.out.println(s);
			}
			Optional<String> string2 = Optional.empty();
			String s = string2.get(); // throws an exception
			System.out.println(s);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	static void demoOrElseThrow() {
		Log.logMethodCall();
		try {
			Optional<String> string1 = Optional.of("Hello");
			if (string1.isPresent()) {
				String s = string1.orElseThrow();
				System.out.println(s);
			}
			Optional<String> string2 = Optional.empty();
			String s = string2.orElseThrow(); // throws an exception
			System.out.println(s);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	static void demoOrElseThrowWithSUpplier() {
		Log.logMethodCall();
		try {
			Optional<String> string = Optional.empty();
			String s = string.orElseThrow(() -> new RuntimeException("zzz")); // Java 9
			System.out.println(s);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
