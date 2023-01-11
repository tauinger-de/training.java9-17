package jj.appl;

import java.lang.reflect.Method;

import jj.mod.alpha.Alpha;
// import jj.mod.beta.Beta;  // illegal
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
		// Alpha.pri();  // illegal
		TryCatch.run(() -> Class.forName("jj.mod.alpha.Alpha").getMethod("pub").invoke(null));
		TryCatch.run(() -> { 
			Method m = Class.forName("jj.mod.alpha.Alpha").getDeclaredMethod("pri");
			m.setAccessible(true);  // InaccessibleObjectException
			m.invoke(null);
		});
	}

	static void demoBeta() {
		Log.logMethodCall();
		// Beta.pub(); // illegal
		TryCatch.run(() -> { 
			Method m = Class.forName("jj.mod.beta.Beta").getDeclaredMethod("pub");
			System.out.println(m);         		
			m.invoke(null); // IllegalAccessException (because missing exports)
		});
	}
}
