package appl;

@SuppressWarnings("preview")
public record Alpha(int a) {
	public void work() {
		System.out.println(a);
		
		class CRunnable {
			public void run() {
				System.out.println("running 1");
				System.out.println(Alpha.this.a);
			}
		};
		new CRunnable().run();
		
		record RRunnable() {
			public void run() {
				System.out.println("running 2");
				// System.out.println(Alpha.this.a); // illegal
			}
		};
		new RRunnable().run();

		new Runnable() {
			public void run() {
				System.out.println("running 3");
				System.out.println(Alpha.this.a);
			}
		}.run();
		
		final Runnable runnable = () -> { 
			System.out.println("running 4");
			System.out.println(Alpha.this.a);
		};
		runnable.run();
		
	}
}
