package appl;

public record Point(double x, double y) {
    public Point {
        System.out.println("==> " + x + " " + y);
        if (x < 0 || y < 0) {
            throw new RuntimeException();
        }
    }
}
