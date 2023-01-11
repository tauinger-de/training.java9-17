package jj.operators;

import jj.operators.iface.Operator;

public class TimesOperator implements Operator {
	@Override
	public String name() {
		return "times";
	}
	@Override
	public int apply(int x, int y) {
		return x * y;
	}
}
