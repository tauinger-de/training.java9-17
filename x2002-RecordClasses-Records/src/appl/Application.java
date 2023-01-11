package appl;

import util.ClassInspector;

public class Application {
	public static void main(String[] args) {
		final Point p1 = new Point(3, 4);
		System.out.println(p1.x() + " " + p1.y());
		System.out.println(p1.toString());
		System.out.println(p1);
		final Point p2 = new Point(3, 4);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode() == p2.hashCode());
		ClassInspector.inspect(Point.class);
		System.out.println(p1 instanceof Record);
		ClassInspector.inspect(Record.class);
	}
}
