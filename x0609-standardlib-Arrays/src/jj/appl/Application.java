package jj.appl;

import java.util.Arrays;
import java.util.Comparator;

import jj.util.log.Log;


public class Application {

	public static void main(String args[]) throws Exception {
		demoEqualsRange();
		demoEquals();
		demoComparePrimitive();
		demoCompareComparable();
		demoCompareComparator();
		demoMismatch();
	}

	static void demoEqualsRange() throws Exception {
		Log.logMethodCall();
		int[] ints1 = new int[] { 10, 11, 12, 13, 14, 15 };
		int[] ints2 = new int[] { 11, 12, 13, 14, 15, 16 };

		// public static boolean equals(
		// int[] a, int aFromIndex, int aToIndex,
		// int[] b, int bFromIndex, int bToIndex)
		System.out.println(Arrays.equals(ints1, 1, 5, ints2, 0, 4));
		/*
		 * int aLength = aToIndex - aFromIndex; int bLength = bToIndex - bFromIndex; if
		 * (aLength != bLength) return false;
		 */
	}

	static void demoEquals() throws Exception {
		Log.logMethodCall();

		class Foo {
			public final int x;

			public Foo(int x) {
				this.x = x;
			}
		}

		Foo[] foos1 = new Foo[] { new Foo(10), new Foo(11) };
		Foo[] foos2 = new Foo[] { new Foo(10), new Foo(11) };

		// public static boolean equals(Object[] a, Object[] a2) {
		System.out.println(Arrays.equals(foos1, foos2)); // false

		// public static <T> boolean equals(T[] a, T[] a2, Comparator<? super T> cmp) {
		Comparator<Foo> comparator = Comparator.comparing(foo -> foo.x);
		System.out.println(Arrays.equals(foos1, foos2, comparator)); // true
	}

	static void demoComparePrimitive() throws Exception {
		Log.logMethodCall();
		int[] ints1 = new int[] { 11, 12, 13, 15 };
		int[] ints2 = new int[] { 11, 12, 13, 15 };
		System.out.println(Arrays.compare(ints1, ints2));

		int[] ints3 = new int[] { 11, 12, 13, 15 };
		int[] ints4 = new int[] { 11, 12, 13, 155 };
		System.out.println(Arrays.compare(ints3, ints4));

		int[] ints5 = new int[] { 11, 12, 13, 155 };
		int[] ints6 = new int[] { 11, 12, 13, 15 };
		System.out.println(Arrays.compare(ints5, ints6));
	}

	static void demoCompareComparable() {
		Log.logMethodCall();

		class Foo implements Comparable<Foo> {
			public final int x;

			public Foo(int x) {
				this.x = x;
			}

			@Override
			public int compareTo(Foo other) {
				return Integer.compare(this.x, other.x);
			}
		}
		Foo[] foos1 = new Foo[] { new Foo(10), new Foo(11) };
		Foo[] foos2 = new Foo[] { new Foo(10), new Foo(11) };
		System.out.println(Arrays.compare(foos1, foos2));

		Foo[] foos3 = new Foo[] { new Foo(10), new Foo(11) };
		Foo[] foos4 = new Foo[] { new Foo(10), new Foo(111) };
		System.out.println(Arrays.compare(foos3, foos4));

		Foo[] foos5 = new Foo[] { new Foo(10), new Foo(111) };
		Foo[] foos6 = new Foo[] { new Foo(10), new Foo(11) };
		System.out.println(Arrays.compare(foos5, foos6));
	}

	static void demoCompareComparator() {
		Log.logMethodCall();

		class Foo {
			public final int x;

			public Foo(int x) {
				this.x = x;
			}
		}
		Foo[] foos1 = new Foo[] { new Foo(10), new Foo(11) };
		Foo[] foos2 = new Foo[] { new Foo(10), new Foo(11) };
		System.out.println(Arrays.compare(foos1, foos2, new Comparator<Foo>() {
			@Override
			public int compare(Foo foo1, Foo foo2) {
				return Integer.compare(foo1.x, foo2.x);
			}
		}));

		Foo[] foos3 = new Foo[] { new Foo(10), new Foo(11) };
		Foo[] foos4 = new Foo[] { new Foo(10), new Foo(111) };
		System.out.println(Arrays.compare(foos3, foos4, (foo1, foo2) -> Integer.compare(foo1.x, foo2.x)));

		Foo[] foos5 = new Foo[] { new Foo(10), new Foo(111) };
		Foo[] foos6 = new Foo[] { new Foo(10), new Foo(11) };
		System.out.println(Arrays.compare(foos5, foos6, Comparator.comparing(foo -> foo.x)));
	}

	static void demoMismatch() throws Exception {
		Log.logMethodCall();
		int[] ints1 = new int[] { 11, 12, 13, 14 };
		int[] ints2 = new int[] { 11, 12, 13, 14 };
		System.out.println(Arrays.mismatch(ints1, ints2)); // -1

		int[] ints3 = new int[] { 11, 12, 13, 14 };
		int[] ints4 = new int[] { 11, 12, 133, 14 };
		System.out.println(Arrays.mismatch(ints3, ints4)); // 2
	}
}