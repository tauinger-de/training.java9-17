package appl;

import util.ClassInspector;

public class Application {
	public static void main(String[] args) {
		final Point p = new Point(3, 4);
		System.out.println(p.size());
		ClassInspector.inspect(Point.class);
	}
}
