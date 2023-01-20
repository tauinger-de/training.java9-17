package jj.mod.alpha;

import jj.mod.beta.Beta;

public class Alpha {
    public static void pub() {
        Beta.pub();
        // Beta.pri(); // illegal
    }

    private static void pri() {
    }
}
