package jj.appl;

public class Foo {

    public static boolean doThrow = false;

    public Foo() {
        if (doThrow)
            throw new RuntimeException("water in drive a:");
    }

    public void f() {
        System.out.println(this.getClass().getSimpleName() + ".f()");
    }
}
