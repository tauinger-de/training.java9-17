package jj.appl;

import jj.mod.Foo;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts...");
        Thread.sleep(1000);
        new Foo();
    }
}
