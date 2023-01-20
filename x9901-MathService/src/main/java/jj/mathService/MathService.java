package jj.mathService;

import jj.mathService.impl.MathServiceImpl;

public interface MathService {

    public abstract int sum(int x, int y);

    public abstract int diff(int x, int y);

    public static MathService create() {
        return new MathServiceImpl();
    }
}
