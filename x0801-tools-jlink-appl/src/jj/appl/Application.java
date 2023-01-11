package jj.appl;

// import jj.mod.pri.Bar;  // illegal
import jj.mod.pub.Foo;

public class Application {
	public static void main(String[] args) throws Exception {
		new Foo();
		// new Bar();  // illegal
		System.out.println("sleeping 1000 ms...");
		Thread.sleep(1000);
	}
}
