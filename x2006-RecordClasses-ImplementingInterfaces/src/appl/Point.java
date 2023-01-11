package appl;

import java.io.Serializable;

@SuppressWarnings("preview")
public record Point(double x, double y) implements Serializable, Comparable<Point> {
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
