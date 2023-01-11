package appl;

public class Application {
	public static void main(String[] args) {
		final Rational rational = new Rational(40, 25);
		System.out.println(rational.x() + " " + rational.y());
		System.out.println(rational);
	}
}
