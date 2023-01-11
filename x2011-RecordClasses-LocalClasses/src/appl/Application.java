package appl;

import util.ClassInspector;

public class Application {
	public static void main(String[] args) {
		final Alpha alpha = new Alpha(42);
		alpha.work();
		ClassInspector.inspect(Alpha.class);
	}
}
