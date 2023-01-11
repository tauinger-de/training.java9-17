package appl;

public class Application {
	public static void main(String[] args) {
		final Tuple2<Integer, String> t2 = new Tuple2<>(42, "Hello");
		System.out.println(t2);

		final Tuple3<Integer, String, Double> t3 = new Tuple3<>(42, "Hello", 2.71);
		System.out.println(t3);
	}
}
