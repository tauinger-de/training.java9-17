package appl;

@FunctionalInterface
public interface BinaryOperator {
	public abstract int apply(int v0, int v1);
	
	static final BinaryOperator plus = (v0, v1) -> v0 + v1;
	static final BinaryOperator minus = (v0, v1) -> v0 - v1;
	static final BinaryOperator times = (v0, v1) -> v0 * v1;
	static final BinaryOperator div = (v0, v1) -> v0 / v1;
}
