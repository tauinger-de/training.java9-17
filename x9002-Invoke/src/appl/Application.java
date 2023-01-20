// https://dzone.com/articles/dismantling-invokedynamic
// https://eppleton.de/news/java-9-variable-handles_2017-06-01.html
// http://niklasschlimm.blogspot.com/2012/02/java-7-complete-invokedynamic-example.html

package appl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws Throwable {
        // demo1();
        // demo2();
        demo3();
        // demo4();
        // demo5();
        // demo6();
        // demo7();
        // demo8();
        // demo9();
    }

    // static void demo1() throws Exception {
    // VarHandle handle = MethodHandles.lookup()
    // .in(Bar.class)
    // .findVarHandle(Bar.class, "alpha", int.class);
    //
    // handle.coordinateTypes().forEach(System.out::println);
    // Bar bar = new Bar();
    // // handle.compareAndExchange()
    // Object o1 = handle.get(bar);
    // System.out.println(o1);
    // System.out.println(handle.getVolatile(bar));
    // handle.setVolatile(bar, 1);
    // Object o2 = handle.get(bar);
    // System.out.println(o2);
    // System.out.println(handle.getVolatile(bar));
    // }

    static void demo2() throws Throwable {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mtDoubleIntLong = MethodType.methodType(double.class, int.class, long.class);
        final MethodHandle mhFooAlpha = lookup.findVirtual(Foo.class, "alpha", mtDoubleIntLong);
        final MethodHandle mhFooBeta = lookup.findVirtual(Foo.class, "beta", mtDoubleIntLong);
        final Foo foo = new Foo();
        final double resultAlpha = (double) mhFooAlpha.invokeExact(foo, 25, (long) 77);
        System.out.println(resultAlpha);
        final double resultBeta = (double) mhFooBeta.invokeExact(foo, 25, (long) 77);
        System.out.println(resultBeta);
    }

    static void demo3() throws Throwable {
        System.out.println("Performance-Test...");
        final Foo foo = new Foo();
        final int N = 1_000_000_000;
        {
            final MethodHandles.Lookup lookup = MethodHandles.lookup();
            final MethodType mt = MethodType.methodType(double.class, int.class, long.class);
            final MethodHandle mh = lookup.findVirtual(Foo.class, "alpha", mt);
            double sum = 0;
            final Watch w = new Watch("MethodHandle");
            for (int i = 0; i < N; i++) {
                sum += (double) mh.invokeExact(foo, i, (long) i);
            }
            System.out.println(w);
            System.out.println("sum = " + sum);
        }
        {
            final Method m = Foo.class.getMethod("alpha", int.class, long.class);
            double sum = 0;
            final Watch w = new Watch("Reflection");
            for (int i = 0; i < N; i++) {
                sum += (Double) m.invoke(foo, i, i);
            }
            System.out.println(w);
            System.out.println("sum = " + sum);
        }
    }

    static void demo4() throws Throwable {
        final Foo foo = new Foo();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mt = MethodType.methodType(double.class, int.class, long.class);
        final MethodHandle mh = lookup.findVirtual(Foo.class, "alpha", mt);
        double result = (double) mh.invokeExact(foo, 42, (long) 33);
        System.out.println(result);
        try {
            mh.invokeExact(foo, 42, (long) 33);
        } catch (WrongMethodTypeException e) {
            System.out.println(e.getMessage());
        }
        mh.invoke(foo, 42, (long) 33);
        try {
            double res = (double) mh.invokeExact(foo, 42, 33);
        } catch (WrongMethodTypeException e) {
            System.out.println(e.getMessage());
        }
        mh.invoke(foo, 42, 33);
    }

    static void demo5() throws Throwable {
        final Foo foo = new Foo();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mt = MethodType.methodType(String.class, Number.class, Integer.class, double.class);
        final MethodHandle mh = lookup.findVirtual(Foo.class, "gamma", mt);
        String result1 = (String) mh.invokeExact(foo, (Number) 42, (Integer) 33, 3.14);
        System.out.println(result1);
        String result2 = (String) mh.invoke(foo, 42, 33, 3);
        System.out.println(result2);
        String result3 = (String) mh.invoke(foo, Integer.valueOf(42), Integer.valueOf(33), 3);
        System.out.println(result3);
    }

    static void demo6() throws Throwable {
        final Foo foo = new Foo();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodHandle mhGetter = lookup.findGetter(Foo.class, "str", String.class);
        final MethodHandle mhSetter = lookup.findSetter(Foo.class, "str", String.class);
        mhSetter.invokeExact(foo, "World");
        String result = (String) mhGetter.invokeExact(foo);
        System.out.println(result);
    }

    static void demo7() throws Throwable {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mt = MethodType.methodType(void.class);
        final MethodHandle mhCtor = lookup.findConstructor(Foo.class, mt);
        Foo foo = (Foo) mhCtor.invokeExact();
        System.out.println(foo);
    }

    static void demo8() throws Throwable {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mt = MethodType.methodType(void.class, int.class);
        final MethodHandle mhCtor = lookup.findConstructor(Foo.class, mt);
        Foo foo = (Foo) mhCtor.invokeExact(77);
        System.out.println(foo);
    }

    static void demo9() throws Throwable {
        final Bar bar = new Bar();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        final MethodType mt = MethodType.methodType(double.class, int.class, long.class);
        final MethodHandle mh = lookup.findVirtual(Foo.class, "alpha", mt);
        final double result = (double) mh.invokeExact((Foo) bar, 10, 20L);
        System.out.println(result);
    }
}

