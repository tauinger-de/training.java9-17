package appl;

import util.ClassInspector;

public class Application {
	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
		System.out.println(p1.x() + " " + p1.y());
		System.out.println(p1.toString());
		System.out.println(p1);
		System.out.println(p1.size());
		Point p2 = new Point(3, 4);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode() == p2.hashCode());
		System.out.println(p1.compareTo(p2));
		ClassInspector.inspect(Point.class);
	}
}
