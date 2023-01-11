package appl;

@SuppressWarnings("preview")
public record Alpha(int a) {
	
	public void work() {
		System.out.println(this.a);
		new CBeta();
		new RBeta();
		new CGamma();
		new RGamma();
	}
	public static class CBeta {
		public CBeta() {
			System.out.println("CBeta");
			// System.out.println(Alpha.this.a);  
		}
	}
	public static record RBeta() {
		public RBeta {
			System.out.println("RBeta");
			// System.out.println(Alpha.this.a);  
		}
	}
	public class CGamma {
		public CGamma() {
			System.out.println("CGamma");
			System.out.println(Alpha.this.a);  
		}
	}
	public record RGamma() {
		public RGamma {
			System.out.println("RGamma");
			// System.out.println(Alpha.this.a);  
		}
	}
}
