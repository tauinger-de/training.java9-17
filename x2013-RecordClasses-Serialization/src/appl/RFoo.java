package appl;

import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("preview")
public record RFoo(int a, String b) implements Serializable {
	public RFoo {
		// canonical constructor will be called
		System.out.println("RFoo");
	}
	// these Methods will not be called!
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println(">> writeObject");
		out.writeObject(this);
	}
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("<< readObject");
		in.readObject();
	}
}
