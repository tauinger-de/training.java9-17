package appl;

import jj.util.log.Log;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        demoRepeat();
        demoStrip();
        demoLines();
        demoIsBlank();
        demoCharactorToString();
    }

    static void demoRepeat() {
        Log.logMethodCall();
        String s1 = "Hello".repeat(5);
        System.out.println(s1);
        String s2 = "-".repeat(50);
        System.out.println(s2);
    }

    static void demoStrip() {
        Log.logMethodCall();

        // trim() removes all characters <= 0x20 but not modern Unicode chars like \u2000
        var text = "\t Hello\u2000 \n\r";
        System.out.printf("'%s'\n", text.trim());

        System.out.printf("'%s'\n", text.strip());
        System.out.printf("'%s'\n", text.stripLeading());
        System.out.printf("'%s'\n", text.stripTrailing());
    }

    static void demoLines() {
        Log.logMethodCall();
        String s = "red\ngreen\nblue";
        Stream<String> stream = s.lines();
        stream.forEach(System.out::println);
    }

    static void demoIsBlank() {
        Log.logMethodCall();
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());
        System.out.println("   \n \t ".isBlank());
        System.out.println("   n t ".isBlank());
    }

    static void demoCharactorToString() {
        Log.logMethodCall();
        String s = Character.toString(65);
        System.out.println(s);  // A
    }
}

