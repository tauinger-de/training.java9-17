package jj.appl;

import jj.util.log.Log;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        demoDropWhile();
        demoTakeWhile();
        demoDropWhileTakeWhile();
        demoHtml();
        demoOfNullable();
        demoIterate();
    }

    static void demoDropWhile() {
        Log.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 13)
                .forEach(System.out::println);
    }

    static void demoTakeWhile() {
        Log.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .takeWhile(v -> v < 12)
                .forEach(System.out::println);
    }

    static void demoDropWhileTakeWhile() {
        Log.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 12)
                .takeWhile(v -> v < 15)
                .forEach(System.out::println);
    }

    static void demoHtml() {
        Log.logMethodCall();
        Stream.of(
                        "<html>",
                        "<head>",
                        "<title>Foo</title>",
                        "</head>",
                        "<body>",
                        "<h1>Foo</h1>",
                        "<p>Bar</p>",
                        "</body>",
                        "</html>")
                .dropWhile(s -> !s.equals("<body>"))
                .skip(1)
                .takeWhile(s -> !s.equals("</body>"))
                .forEach(System.out::println);
    }

    static void demoOfNullable() {
        Log.logMethodCall();
        Stream<String> s1 = Stream.ofNullable((String) null);
        s1.forEach(System.out::println);
        Stream<String> s2 = Stream.ofNullable("Hello");
        s2.forEach(System.out::println);
    }

    static void demoIterate() {
        Log.logMethodCall();
        Stream<Integer> s = Stream.iterate(5, i -> i < 10, i -> i + 2);
        s.forEach(System.out::println);
    }
}
