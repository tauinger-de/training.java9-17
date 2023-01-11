package appl;

import java.io.IOException;
import java.io.Serializable;

public class CFoo implements Serializable {
	private final int a;
	private final String b; 
	public CFoo(int a, String b) {
		System.out.println("CFoo");
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "CFoo [a=" + a + ", b=" + b + "]";
	}
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println(">> writeObject");
		out.writeObject(this);
	}
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("<< readObject");
		in.readObject();
	}
}
