package jj.appl;

import jj.util.log.Log;

public class Application {

    public static void main(String args[]) throws Exception {
        demoRequireNonNull();
        demoCheckIndex();
    }

    static void demoRequireNonNull() throws Exception {
        Log.logMethodCall();
        try {
            Foo.alpha(null);
        } catch (NullPointerException e) {
            System.out.println("Expected" + e);
        }
        Foo.beta(null);
        Foo.gamma(null);
    }

    static void demoCheckIndex() throws Exception {
        Log.logMethodCall();
        int[] array = new int[]{10, 11, 12, 13, 14};
        try {
            Bar.alpha(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        try {
            Bar.beta(array, 5);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        Bar.gamma(array, 0, 5);
        try {
            Bar.gamma(array, -1, 6);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}