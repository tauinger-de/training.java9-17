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
        // Impl von trim etwas anders als die von strip...
        System.out.println("'" + "  Hello  ".trim() + "'");
        System.out.println("'" + "  Hello  ".strip() + "'");
        System.out.println("'" + "  Hello  ".stripLeading() + "'");
        System.out.println("'" + "  Hello  ".stripTrailing() + "'");
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

