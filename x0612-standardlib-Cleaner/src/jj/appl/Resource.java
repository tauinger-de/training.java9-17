package jj.appl;

public class Resource {
	public final String name;
	public Resource(String name) {
		this.name = name;
	}
	public void cleanup() {
		System.out.println(this + " : cleanup()");
	}
	@Override
	public String toString() {
		return "Resource [" + name + "]";
	}
}

