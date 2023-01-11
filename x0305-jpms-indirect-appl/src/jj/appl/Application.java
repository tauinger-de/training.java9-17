package jj.appl;

import java.lang.reflect.Method;

import jj.modA.alpha.Alpha;
import jj.util.log.Log;
import jj.util.trycatch.TryCatch;

public class Application {

	public static void main(String[] args) {
		demoAlpha();
		demoBeta();
	}

	static void demoAlpha() {
		Log.logMethodCall();
		Alpha.pub();

		TryCatch.run(() -> {
			final Class<?> cls = Class.forName("jj.modA.alpha.Alpha");
			final Method m = cls.getDeclaredMethod("pub");
			m.invoke(null);
		});
		TryCatch.run(() -> {
			final Class<?> cls = Class.forName("jj.modA.alpha.Alpha");
			final Method m = cls.getDeclaredMethod("pri");
			m.setAccessible(true);  
			m.invoke(null);
		});
	}

	static void demoBeta() {
		Log.logMethodCall();
//		Beta.pub(); // illegal
		TryCatch.run(() -> {
			final Class<?> cls = Class.forName("jj.modB.beta.Beta");
			final Method m = cls.getDeclaredMethod("pub");
			m.invoke(null);
		});
		TryCatch.run(() -> {
			final Class<?> cls = Class.forName("jj.modB.beta.Beta");
			final Method m = cls.getDeclaredMethod("pri");
			m.setAccessible(true); 
			m.invoke(null);
		});
	}
}
