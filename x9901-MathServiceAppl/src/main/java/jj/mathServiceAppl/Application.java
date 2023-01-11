package jj.mathServiceAppl;

import jj.mathService.MathService;

public class Application {
	public static void main(String[] args) {
		MathService mathService = MathService.create();
		System.out.println(mathService.sum(40, 2));
		System.out.println(mathService.diff(80, 3));
	}
}
