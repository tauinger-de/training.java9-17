package appl;

@SuppressWarnings("preview")
public record BinaryExpression(Expression first, Expression second, BinaryOperator op) implements Expression{
	@Override
	public int evaluate() {
		return op.apply(this.first.evaluate(), this.second.evaluate());
	}
}

