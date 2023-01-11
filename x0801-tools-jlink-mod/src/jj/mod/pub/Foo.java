package jj.mod.pub;

import jj.mod.pri.Bar;

public class Foo {
	private final Bar bar = new Bar();
	public Foo() {
		System.out.println(this);
		System.out.println(bar);
}
}
