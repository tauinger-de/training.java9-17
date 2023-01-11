package jj.iface;

import jj.impl.MathServiceImpl;

public interface MathService {
	
	public abstract int sum(int x, int y);
	public abstract int diff(int x, int y);

	public final MathService instance = new MathServiceImpl();
}
