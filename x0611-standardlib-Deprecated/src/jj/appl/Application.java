package jj.appl;

import jj.util.log.Log;

import java.util.Observable;
import java.util.Observer;

/*
package java.lang;
// ...
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface Deprecated {
    String since() default "";
    boolean forRemoval() default false;
}

*/

// see also: new Java tool "jdeprscan"

// @Deprecated
@Deprecated(forRemoval = true, since = "9")
class Nonsens {
}

public class Application {

    public static void main(String args[]) throws Exception {
        demoWrapper();
        demoObserverObservable();
        demoFinalize();
    }

    @SuppressWarnings("deprecation")
    static void demoWrapper() throws Exception {
        Log.logMethodCall();

        Integer i1 = new Integer(32);
        System.out.println(i1);
        Integer i2 = new Integer("32");
        System.out.println(i2);
        Integer i3 = Integer.valueOf(32);
        System.out.println(i3);

        Double d1 = new Double(3.14);
        System.out.println(d1);
        Double d2 = new Double("3.14");
        System.out.println(d2);
        Double d3 = Double.valueOf(3.14);
        System.out.println(d3);
    }

    @SuppressWarnings("deprecation")
    static void demoObserverObservable() {
        Log.logMethodCall();
        Observer observer = new Observer() {
            @Override
            public void update(Observable source, Object arg) {
                // ...
            }
        };
        Observable observable = new Observable();
    }

    @SuppressWarnings("deprecation")
    static void demoFinalize() {
        Log.logMethodCall();
        class Foo {
            @Override
            public void finalize() throws Throwable {
                super.finalize();
                System.out.println("finalize");
            }
        }
        new Foo();
        System.gc();
    }
}

