package jj.appl;

public interface Foo {
    default void f() {
        this.g();
        g(this);
    }

    private void g() {
        this.h();
    }

    private static void g(Foo foo) {
        foo.h();
    }

    void h();
}
