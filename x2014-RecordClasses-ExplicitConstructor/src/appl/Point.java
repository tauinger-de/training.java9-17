package appl;

@SuppressWarnings("preview")
public record Point(double x, double y) {
	public Point(double x, double y) {
		if (x < 0 || y < 0)
			throw new RuntimeException();
		this.x = x;
		this.y = y;
	}
}

// records are final

