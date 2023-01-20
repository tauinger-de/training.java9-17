package appl;

import jj.util.log.Log;

public class Application {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    static void demo1() {
        Log.logMethodCall();
        String s1 = "Hello";
        String s2 = s1.indent(8);
        System.out.println(s1);
        System.out.println(s2);
    }

    static void demo2() {
        Log.logMethodCall();
        String s = "3.14";
        double d1 = s.transform(str -> Double.parseDouble(str));
        System.out.println(d1);
        double d2 = s.transform(Double::parseDouble);
        System.out.println(d1);
    }
}