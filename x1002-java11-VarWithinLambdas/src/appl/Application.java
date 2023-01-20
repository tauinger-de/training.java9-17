package appl;

import java.util.function.BiConsumer;


public class Application {

    public static void main(String[] args) {
        BiConsumer<String, Integer> c1 = (@Nullable String s, Integer i) -> {
        };
        BiConsumer<String, Integer> c2 = (@Nullable var s, var i) -> {
        };
        // BiConsumer<String, Integer> c3 = (@Nullable s, i) -> { };  // illegal

    }

}
