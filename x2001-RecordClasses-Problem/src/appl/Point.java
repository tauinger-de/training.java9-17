package appl;

import java.io.Serializable;

public class Point implements Serializable, Comparable<Point> {
	private final double x;
	private final double y;
	public Point(final double x, final double y) {
		if (x < 0 || y < 0)
			throw new RuntimeException();
		System.out.println("==> " + x + " " + y);
		this.x = x;
		this.y = y;
	}
	public Point(final double x) {
		this(x, 0);
	}
	public Point() {
		this(0, 0);
	}
	public double x() {
		return this.x;
	}
	public double y() {
		return this.y;
	}
	public double size() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
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
