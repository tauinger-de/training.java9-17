package appl;

public class Application {
	public static void main(String[] args) {
		final Rectangle r1 = new Rectangle(new Point(3, 4), new Point(5, 6));
		System.out.println(r1.p0().x() + " " + r1.p0().y() + " " + r1.p1().x() + " " + r1.p1().y());
		System.out.println(r1);
		final Rectangle r2 = new Rectangle(new Point(3, 4), new Point(5, 6));
		System.out.println(r2.equals(r1));
	}
}
