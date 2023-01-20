package jj.operators;

import jj.operators.iface.Operator;

public class PlusOperator implements Operator {
    @Override
    public String name() {
        return "plus";
    }

    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}
