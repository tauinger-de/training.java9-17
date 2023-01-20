package appl;

import util.ClassInspector;

public class Application {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(4, 3);
        System.out.println(p1.compareTo(p2));
        ClassInspector.inspect(Point.class);
    }
}
