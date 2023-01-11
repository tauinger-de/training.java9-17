package appl;

@SuppressWarnings("preview")
public record Rational(int x, int y) {
	public Rational {
		int gcd = gcd(x, y);
		x = x / gcd;
		y = y / gcd;
	}
	private static int gcd(int x, int y) {
		while (x != y) {
			if (x > y) x -= y; else	y -= x;
		}
		return x;
	}

}
