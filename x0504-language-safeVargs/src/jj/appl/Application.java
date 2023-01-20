package jj.appl;

import java.util.Arrays;
import java.util.List;

public class Application {
    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        List<String>[] l1 = nonVarargs(new List[]{
                Arrays.asList("rot", "gruen", "blau"),
                Arrays.asList("red", "green", "blue")
        });
        l1[0].forEach(System.out::println);

        List<String>[] l2 = varargs(new List[]{
                Arrays.asList("rot", "gruen", "blau"),
                Arrays.asList("red", "green", "blue")
        });
        l2[0].forEach(System.out::println);

        List<String>[] l3 = varargs(
                Arrays.asList("rot", "gruen", "blau"),
                Arrays.asList("red", "green", "blue"));
        l3[0].forEach(System.out::println);
    }

    @SuppressWarnings("rawtypes")
    public static List<String>[] nonVarargs(List<String>[] args) {
        List[] array = args;
        List<Integer> list = Arrays.asList(10, 20, 30);
        //array[0] = list;
        return args;
    }

    @SuppressWarnings("rawtypes")
    @SafeVarargs
    public static List<String>[] varargs(List<String>... args) {
        List[] array = args;
        List<Integer> list = Arrays.asList(10, 20, 30);
        //array[0] = list;
        return args;
    }

    @SafeVarargs
    public static void alpha(List<String>... args) {
    }

    // @SafeVarargs // not allowed
    public void beta(List<String>... args) { // compiler-warning

    }

    @SafeVarargs
    public final void gamma(List<String>... args) {

    }

    @SafeVarargs
    private void delta(List<String>... args) {

    }
}
