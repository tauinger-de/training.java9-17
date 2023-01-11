package appl;

@SuppressWarnings("preview")
public record UnaryExpression(Expression inner, UnaryOperator op) implements Expression{
	@Override
	public int evaluate() {
		return op.apply(this.inner.evaluate());
	}
}
