package appl;

import util.ClassInspector;

public class Application {
	public static void main(String[] args) {
		final Point p1 = new Point(3, 4);
		System.out.println(p1);
		final Point p2 = new Point(3);
		System.out.println(p2);
		final Point p3 = new Point(3);
		System.out.println(p3);
		ClassInspector.inspect(Point.class);
	}
}
