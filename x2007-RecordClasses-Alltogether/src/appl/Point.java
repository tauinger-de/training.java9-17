package appl;

import java.io.Serializable;

@SuppressWarnings("preview")
public record Point(double x, double y) implements Serializable, Comparable<Point> {
	public Point {
		System.out.println("==> " + x + " " + y);
		if (x < 0 || y < 0)
			throw new RuntimeException();
	}
	public Point(final double x) {
		this(x, 0);
	}
	public Point() {
		this(0, 0);
	}
	public double size() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
	@Override
	public int compareTo(Point other) {
		if (this.size() > other.size())
			return 1;
		if (this.size() < other.size())
			return -1;
		return 0;
	}
}
