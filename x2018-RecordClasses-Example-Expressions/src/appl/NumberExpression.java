package appl;

@SuppressWarnings("preview")
public record NumberExpression(int value) implements Expression{
	@Override
	public int evaluate() {
		return this.value;
	}
}

