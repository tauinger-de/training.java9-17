package appl;

import jj.util.log.Log;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        demoIndent();
        demoTransform();
    }

    static void demoIndent() {
        Log.logMethodCall();
        System.out.print("  Meine Reiseziele:".indent(-2)); // kein println sondern print!
        System.out.print("NewYork\nRio\nTokio".indent(4));
    }

    static void demoTransform() {
        Log.logMethodCall();
        String s = "3.14159264358979323846";
        double pi = s.transform(Double::parseDouble);
        System.out.println(pi);
    }
}