package jj.operators;

import jj.operators.iface.Operator;

public class MinusOperator implements Operator {
    @Override
    public String name() {
        return "minus";
    }

    @Override
    public int apply(int x, int y) {
        return x - y;
    }
}
