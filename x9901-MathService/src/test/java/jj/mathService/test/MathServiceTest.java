package jj.mathService.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jj.mathService.MathService;

public class MathServiceTest {
	@Test
	public void testSum() {
		Assertions.assertEquals(42, MathService.create().sum(40, 2));
	}
	@Test
	public void testDiff() {
		Assertions.assertEquals(77, MathService.create().diff(80, 3));
	}
}
