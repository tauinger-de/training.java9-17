package jj.appl;

import jj.util.log.Log;

import java.lang.constant.ClassDesc;
import java.util.List;
import java.util.function.Function;

public class Application {

    public static void main(String[] args) {
        demoVar();
        demoVarAndFinal();
        demoListsAndLoops();
        demoImmediateAssign();
        demoLambdas();
        demoAnonymousClass();
        demoAnonymousClassMethods();
        demoAttribute();
    }

    static void demoVar() {
        Log.logMethodCall();

        var i = 42;
        i = 77;
        // i = 42L;		// illegal
        // i = "Hello"; // illegal
        int var = 77;
        System.out.println(var);

//		illegal:
//		class var {
//		}

// 		var j; // illegal
    }

    static void demoVarAndFinal() {
        Log.logMethodCall();
        final var i = 42;
        // i = 77;		// illegal
    }

    static void demoListsAndLoops() {
        Log.logMethodCall();
        var list = List.of(10, 20, 30);
        List<Integer> l = list;
        for (var value : list) {
            Integer v = value;
            System.out.println(v);
        }
        for (var i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            System.out.println(v);
        }
        // List<Double> doubleList = list;  // illegal
    }

    static void demoImmediateAssign() {
        Log.logMethodCall();
        final int foo;
        if ("1".equals("1"))
            foo = 42;
        else
            foo = 77;
//		illegal:
//		final var bar;
//		if ("1".equals("1"))
//			bar = 42;
//		else
//			bar = 77;
    }

    static void demoLambdas() {
        Log.logMethodCall();
        Function<String, Integer> foo = s -> s.length();
        var result = foo.apply("Hello");
        System.out.println(result);
        // var bar = s -> s.length();  // illegal (-> Target Typing)
    }

    static void demoAnonymousClass() {
        Log.logMethodCall();
        var function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
// 		illegal:
//		function = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return s.length() / 2;
//			}
//		};
    }

    static void demoAnonymousClassMethods() {
        Log.logMethodCall();
        var foo = new Object() {
            public void alpha() {
                System.out.println("alpha");
            }

            public void beta() {
                System.out.println("beta");
            }

            public int bar = 77;
        };
        foo.alpha();
        foo.beta();
        System.out.println(foo.bar);
    }

    static void demoAttribute() {
        Log.logMethodCall();
        ClassDesc d;
        class Foo {
            // var i = 42;  // not allowed
        }
    }
}
