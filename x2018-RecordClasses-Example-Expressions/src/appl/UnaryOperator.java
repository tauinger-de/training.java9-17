package appl;

@FunctionalInterface
public interface UnaryOperator {
	public abstract int apply(int v);
	
	static final UnaryOperator plus = v -> v;
	static final UnaryOperator minus = v -> -v;
}
