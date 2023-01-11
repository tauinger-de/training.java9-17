package appl;

public class Foo {
	public Foo() {
	}
	public Foo(int x) {
	}
	public double alpha(int v1, long v2) {
		return v1 + v2;
	}
	public double beta(int v1, long v2) {
		return v1 - v2;
	}
	public String gamma(Number x, Integer y, double z) {
		return x.toString() + " " + y.toString() + " " + String.valueOf(z);
	}
	public String str = "Hello";
}
