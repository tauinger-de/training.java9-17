package jj.appl;

import java.util.Optional;

import jj.mod.Foo;
import jj.util.log.Log;

public class Application {
    public static void main(String[] args) {
        demoTryCatch();
        demoFind();
    }

    static void demoTryCatch() {
        Log.logMethodCall();
        try {
            Foo foo = new Foo();
            System.out.println("Done");
        } catch (NoClassDefFoundError e) {
            System.out.println(e);
        }
    }

    static void demoFind() {
        Log.logMethodCall();
        Optional<Module> module = ModuleLayer.boot().findModule("jj.mod");
        System.out.println(module);
    }
}
