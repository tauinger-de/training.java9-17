package jj.services.iface;

import jj.services.impl.MathServiceImpl;

public interface MathService {
	
	public abstract int sum(int x, int y);
	public abstract int diff(int x, int y);

	public final static MathService instance = new MathServiceImpl(); 
}
