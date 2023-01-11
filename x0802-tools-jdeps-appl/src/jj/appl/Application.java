package jj.appl;

// import jj.mod.pri.Bar;  // illegal
import jj.mod.pub.Foo;

public class Application {
	public static void main(String[] args) {
		new Foo();
		// new Bar();  // illegal
	}
}
