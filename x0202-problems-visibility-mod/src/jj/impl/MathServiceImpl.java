package jj.impl;

import jj.iface.MathService;

public class MathServiceImpl implements MathService {

	@Override
	public int sum(int x, int y) {
		return x + y;
	}

	@Override
	public int diff(int x, int y) {
		return x - y;
	}
}
