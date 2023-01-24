package appl;

import jj.util.log.Log;

import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class Application {

    public static void main(String[] args) {
        demoOld();
        demoNew();
    }

    static void demoOld() {
        Log.logMethodCall();
        final Predicate<String> isEmpty = String::isEmpty; // only required for negating in next line
        final Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
    }

    static void demoNew() {
        Log.logMethodCall();
        final Predicate<String> isNotEmpty = Predicate.not(String::isEmpty);

        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
    }
}
