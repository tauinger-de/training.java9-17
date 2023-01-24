package appl;

public record Point(double x, double y) {

    public double size() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

}
