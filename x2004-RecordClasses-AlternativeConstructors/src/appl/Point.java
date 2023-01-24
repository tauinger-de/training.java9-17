package appl;

public record Point(double x, double y) {

    public Point(final double x) {
        this(x, 0);
    }

    public Point() {
        this(0, 0);
    }

}
