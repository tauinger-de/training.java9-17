package jj.appl;

import jj.services.iface.MathService;
import jj.util.log.Log;

public class Application {

    public static void main(String[] args) {
        demoServices();
    }

    static void demoServices() {
        Log.logMethodCall();
        MathService mathService = MathService.instance;
        System.out.println(mathService.sum(40, 2));
        System.out.println(mathService.diff(80, 3));
    }
}
