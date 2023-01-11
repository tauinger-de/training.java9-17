package jj.appl;

import jj.mod.alpha.Alpha;
//import jj.mod.beta.Beta;
import jj.util.trycatch.TryCatch;

public class Application {

	public static void main(String[] args) {
		
		Alpha alpha = new Alpha();

		// Beta beta = new Beta(); 
		TryCatch.run(() -> {
			final Class<?> cls = Class.forName("jj.mod.beta.Beta");
			final Object obj = cls.getConstructor().newInstance();
			System.out.println(obj);
		});
	}

}
