package appl;

public class Application {
	public static void main(String[] args) {
		final MinMax minMax = MinMax.of(40, 2, 50, 3);
		System.out.println(minMax.min() + " " + minMax.max());
		System.out.println(minMax);
	}
}
