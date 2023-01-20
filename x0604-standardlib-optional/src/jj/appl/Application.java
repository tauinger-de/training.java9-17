package jj.appl;

import jj.util.log.Log;

import java.util.Optional;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        demoStream1();
        demoStream2();
        demoOr();
        demoIfPresentOrElse();
    }

    static void demoStream1() {
        Log.logMethodCall();

        Optional<String> s1 = Optional.empty();
        s1.stream().forEach(System.out::println);

        Optional<String> s2 = Optional.of("Hello");
        s2.stream().forEach(System.out::println);
    }

    static void demoStream2() {
        Log.logMethodCall();

        Stream.of(Optional.of("red"), Optional.empty(), Optional.of("blue"))
                .flatMap(opt -> opt.stream())
                .forEach(str -> System.out.println(str));

        Stream.of(Optional.of("red"), Optional.empty(), Optional.of("blue"))
                .flatMap(Optional::stream)
                .forEach(System.out::println);
    }

    static void demoOr() {
        Log.logMethodCall();

        Optional<String> str1 = Optional.ofNullable((String) null).or(() -> Optional.of("Hello"));
        System.out.println(str1);

        Optional<String> str2 = Optional.ofNullable("World").or(() -> Optional.of("Hello"));
        System.out.println(str2);

        var emptyOrEmpty = Optional.empty().or(Optional::empty);
        System.out.println(emptyOrEmpty.isPresent());
    }

    static void demoIfPresentOrElse() {
        Log.logMethodCall();

        Optional<String> o1 = Optional.of("Hello");
        o1.ifPresentOrElse(str -> System.out.println(str), () -> System.out.println("not present"));

        Optional<String> o2 = Optional.empty();
        o2.ifPresentOrElse(str -> System.out.println(str), () -> System.out.println("not present"));
    }
}
