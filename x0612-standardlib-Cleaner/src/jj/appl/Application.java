package jj.appl;

import jj.util.log.Log;

public class Application {

	public static void main(String args[]) throws Exception {
		demoFoo();
		demoBar();
	}

	static void demoFoo() throws Exception {
		// this will not work...
		Log.logMethodCall();
		Foo foo = new Foo();
		foo.doSomething();
		foo = null;
		System.gc();
		Thread.sleep(1000);
	}
	
	static void demoBar() throws Exception {
		// but this will work...
		Log.logMethodCall();
		Bar bar = new Bar();
		bar.doSomething();
		bar = null;
		System.gc();
		Thread.sleep(1000);
	}
}
