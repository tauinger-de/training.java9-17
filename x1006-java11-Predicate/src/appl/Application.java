package appl;

import java.io.IOException;
import java.util.function.Predicate;
import static java.util.function.Predicate.not;

import jj.util.log.Log;

public class Application {

	public static void main(String[] args) throws IOException {
		demoOld();
		demoNew();
	}
	
	static void demoOld() {
		Log.logMethodCall();
		final Predicate<String> isEmpty = s -> s.isEmpty();  // Variable erforderlich
		final Predicate<String> isNotEmpty = isEmpty.negate();  

		System.out.println(isEmpty.test("Hello"));
		System.out.println(isNotEmpty.test("Hello"));
		System.out.println(isEmpty.test(""));
		System.out.println(isNotEmpty.test(""));
	}

	static void demoNew() {
		Log.logMethodCall();
		final Predicate<String> isEmpty = s -> s.isEmpty();
		// final Predicate<String> isNotEmpty = Predicate.not(isEmpty);
		final Predicate<String> isNotEmpty = not(isEmpty);

		final Predicate<String> isNotEmpty2 = not(s -> s.isEmpty());
		
		System.out.println(isEmpty.test("Hello"));
		System.out.println(isNotEmpty.test("Hello"));
		System.out.println(isEmpty.test(""));
		System.out.println(isNotEmpty.test(""));
	}
}
