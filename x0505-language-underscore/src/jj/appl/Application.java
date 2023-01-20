package jj.appl;

import java.util.function.BiConsumer;

public class Application {

    public static void main(String[] args) {
//		int _ = 42;

        BiConsumer<String, String> c1 = (x, y) -> System.out.println(x + " " + y);
        c1.accept("Brot", "Wein");

        // noch verboten:
//		BiConsumer<String,String> c2 = (x, _) -> System.out.println(x);
//		c2.accept("Brot", "Wein");
    }
}