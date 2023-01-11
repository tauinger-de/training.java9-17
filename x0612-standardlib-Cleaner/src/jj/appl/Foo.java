package jj.appl;

import jj.util.DefaultCleaner;

public class Foo {

	final Resource resource0 = new Resource("Hello");
	final Resource resource1 = new Resource("World");
	
	public Foo() {
		DefaultCleaner.instance.register(this, () -> this.resource0.cleanup());
		DefaultCleaner.instance.register(this, () -> this.resource1.cleanup());
	}

	public void doSomething() {
		System.out.println("doSomething with " + this.resource0 + " and " + this.resource1);
	}
}
