package jj.appl;

import java.lang.reflect.Method;

import jj.mod.alpha.Alpha;
import jj.mod.beta.Beta;
// import jj.mod.delta.Gamma;  // illegal
import jj.util.log.Log;
import jj.util.trycatch.TryCatch;

public class Application {

    public static void main(String[] args) {
        demoAlpha();
        demoBeta();
        demoGamma();
        demoDelta();
    }

    static void demoAlpha() {
        Log.logMethodCall();
        Alpha.pub();
        // Alpha.pri(); // illegal
        TryCatch.run(() -> {
            final Method m = Alpha.class.getDeclaredMethod("pub");
            m.invoke(null);
        });
        TryCatch.run(() -> {
            final Method m = Alpha.class.getDeclaredMethod("pri");
            m.setAccessible(true);
            m.invoke(null);
        });
    }

    static void demoBeta() {
        Log.logMethodCall();
        Beta.pub();
        // Beta.pri(); // illegal
        TryCatch.run(() -> {
            final Method m = Beta.class.getDeclaredMethod("pub");
            m.invoke(null);
        });
        TryCatch.run(() -> {
            final Method m = Beta.class.getDeclaredMethod("pri");
            m.setAccessible(true); // throw an InaccessibleObjectException
            m.invoke(null);
        });
    }

    static void demoGamma() {
        Log.logMethodCall();
        // Gamma.pub(); // illegal
        TryCatch.run(() -> {
            final Class<?> cls = Class.forName("jj.mod.gamma.Gamma");
            TryCatch.run(() -> {
                final Method m = cls.getDeclaredMethod("pub");
                m.invoke(null);
            });
            TryCatch.run(() -> {
                final Method m = cls.getDeclaredMethod("pri");
                m.setAccessible(true);
                m.invoke(null);
            });
        });
    }

    static void demoDelta() {
        Log.logMethodCall();
        // Delta.pub(); // illegal
        TryCatch.run(() -> {
            final Class<?> cls = Class.forName("jj.mod.delta.Delta");
            final Object obj = cls.getDeclaredMethod("pub").invoke(null); // IllegalAccessException
        });
    }
}
