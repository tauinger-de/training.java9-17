package appl;

public class Application {
	public static void main(String[] args) {
		// 2 + 3 * -4
		Expression e1 = new NumberExpression(2);
		Expression e2 = new NumberExpression(3);
		Expression e3 = new NumberExpression(4);
		Expression e4 = new UnaryExpression(e3, UnaryOperator.minus);
		Expression e5 = new BinaryExpression(e2, e4, BinaryOperator.times);
		Expression e6 = new BinaryExpression(e1, e5, BinaryOperator.plus);
		System.out.println(e6.evaluate());
	}
}
