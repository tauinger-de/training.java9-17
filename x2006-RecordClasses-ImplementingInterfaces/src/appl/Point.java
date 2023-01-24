package appl;

import java.io.Serializable;

public record Point(double x, double y) implements Serializable, Comparable<Point> {

    public double size() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public int compareTo(Point other) {
        return Double.compare(this.size(), other.size());
    }
}
