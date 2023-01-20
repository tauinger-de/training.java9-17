package jj.modA.alpha;

import java.lang.reflect.Method;

import jj.util.trycatch.TryCatch;

public class Alpha {
    public static void pub() {

        //Beta.pub();

        TryCatch.run(() -> {
            Method method = Class.forName("jj.modB.beta.Beta").getDeclaredMethod("pub");
            method.invoke(null);
        });

        TryCatch.run(() -> {
            Method method = Class.forName("jj.modB.beta.Beta").getDeclaredMethod("pri");
            method.setAccessible(true);
            method.invoke(null);
        });
    }

    private static void pri() {
    }
}
