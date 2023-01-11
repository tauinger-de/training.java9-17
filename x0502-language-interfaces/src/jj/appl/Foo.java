package jj.appl;

public interface Foo {
	public default void f() {
		this.g();
		g(this);
	}
	private void g() {
		this.h();
	}
	private static void g(Foo foo) {
		foo.h();
	}
	public abstract void h();
}
