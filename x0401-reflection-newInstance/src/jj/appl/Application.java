package jj.appl;

import java.lang.reflect.InvocationTargetException;

import jj.util.log.Log;

public class Application {
    public static void main(String[] args) throws Exception {
        demoNewInstance();
        demoNewInstanceException();
        demoGetConstructor();
        demoGetConstructorException();
        demoCheckedException();
    }

    @SuppressWarnings("deprecation")
    static void demoNewInstance() {
        Log.logMethodCall();
        try {
            Foo.doThrow = false;
            final Class<?> cls = Class.forName("jj.appl.Foo");
            final Foo foo = (Foo) cls.newInstance();
            foo.f();
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("deprecation")
    static void demoNewInstanceException() {
        Log.logMethodCall();
        try {
            Foo.doThrow = true;
            final Class<?> cls = Class.forName("jj.appl.Foo");
            final Foo foo = (Foo) cls.newInstance();
            foo.f();
        } catch (final RuntimeException e) {
            System.out.println(e);
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    static void demoGetConstructor() {
        Log.logMethodCall();
        try {
            Foo.doThrow = false;
            final Class<?> cls = Class.forName("jj.appl.Foo");
            final Foo foo = (Foo) cls.getConstructor().newInstance();
            foo.f();
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    static void demoGetConstructorException() {
        Log.logMethodCall();
        try {
            Foo.doThrow = true;
            final Class<?> cls = Class.forName("jj.appl.Foo");
            final Foo foo = (Foo) cls.getConstructor().newInstance();
            foo.f();
        } catch (final InvocationTargetException e) {
            System.out.println(e);
            System.out.println(e.getTargetException());
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("deprecation")
    static void demoCheckedException() throws Exception {
        Log.logMethodCall();
        final Class<?> cls = Class.forName("jj.appl.Bar");
        try {
            final Bar bar = (Bar) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
//		illegal:
//		catch (IOException e) {
//			e.printStackTrace();
//		}

    }
}
