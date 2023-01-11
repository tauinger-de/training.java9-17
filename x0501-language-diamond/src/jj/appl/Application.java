// http://javasampleapproach.com/java-9-tutorial

package jj.appl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import jj.util.log.Log;

class Drink {
}

class Wine extends Drink {
}

class RedWine extends Wine {
}

class Range implements Iterable<Integer> {
	public final int first;
	public final int last;
	public Range(int first, int last) {
		this.first = first;
		this.last = last;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<>() {
			int current = first;
			@Override
			public boolean hasNext() {
				return current <= last;
			}
			@Override
			public Integer next() {
				if (! hasNext())
					throw new NoSuchElementException();
				return current++;
			}
		};
	}
	
}
public class Application {

	public static void main(String[] args) {
		demoFunctionOld();
		demoFunctionNew();
		
		demoConsumer1();
		demoConsumer2();
		demoConsumer3();

		demoSupplier1();
		demoSupplier2();
		demoSupplier3();
		demoSupplier4();
		
		demoRange();
	}
	
	static void demoFunctionOld() {
		Log.logMethodCall();
		final Function<String, Integer> func = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				printGenericType(this);
				return s.length();
			}
		};
		System.out.println(func.apply("Hello"));
	}

	static void demoFunctionNew() {
		Log.logMethodCall();
		final Function<String, Integer> func = new Function<>() {
			@Override
			public Integer apply(String s) {
				printGenericType(this);
				return s.length();
			}
		};
		System.out.println(func.apply("Hello"));
	}

	static void demoConsumer1() {
		Log.logMethodCall();
		Consumer<Wine> c = new Consumer<>() {
			@Override
			public void accept(Wine w) {
				printGenericType(this);
				System.out.println(w);
			}
		};
		c.accept(new RedWine());
	}

	static void demoConsumer2() {
		Log.logMethodCall();
		Consumer<? super Wine> c = new Consumer<Drink>() {
			@Override
			public void accept(Drink w) {
				printGenericType(this);
				System.out.println(w);
			}
		};
		c.accept(new RedWine());
	}

	static void demoConsumer3() {
		Log.logMethodCall();
		Consumer<? super Wine> c = new Consumer<>() {
			@Override
			public void accept(Wine w) {
				printGenericType(this);
				System.out.println(w);
			}
		};
		c.accept(new RedWine());
	}

	static void demoSupplier1() {
		Log.logMethodCall();
		Supplier<Wine> s = new Supplier<>() {
			@Override
			public Wine get() {
				printGenericType(this);
				return new RedWine();
			}
		};
		Wine w = s.get();
		System.out.println(w);
	}

	static void demoSupplier2() {
		Log.logMethodCall();
		Supplier<? extends Wine> s = new Supplier<RedWine>() {
			@Override
			public RedWine get() {
				printGenericType(this);
				return new RedWine();
			}
		};
		Wine w = s.get();
		System.out.println(w);
	}

	static void demoSupplier3() {
		Log.logMethodCall();
		Supplier<? extends Wine> s = new Supplier<>() {
			@Override
			public Wine get() {
				printGenericType(this);
				return new Wine();
			}
		};
		Wine w = s.get();
		System.out.println(w);
	}

	static void demoSupplier4() {
		Log.logMethodCall();
		Supplier<? extends Wine> s = new Supplier<>() {
			@Override
			public RedWine get() {
				printGenericType(this);
				return new RedWine();
			}
		};
		Wine w = s.get();
		System.out.println(w);
	}

	static void demoRange() {
		Log.logMethodCall();
		Range r = new Range(10, 12);
		for(Integer e : r) {
			System.out.println(e);
		}
	}
	
	static void printGenericType(Object obj) {
		try {
			Class<?> cls = obj.getClass();
			ParameterizedType pt = (ParameterizedType) cls.getGenericInterfaces()[0];
			Type[] typeArgs = pt.getActualTypeArguments();
			System.out.print(cls.getInterfaces()[0].getSimpleName() + "<");
			for (int i = 0; i < typeArgs.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(((Class<?>)typeArgs[i]).getSimpleName());
			}
			System.out.println(">");
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

}
