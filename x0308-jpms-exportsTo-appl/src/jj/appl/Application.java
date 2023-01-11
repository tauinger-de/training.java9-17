package jj.appl;

import jj.modA.alpha.Alpha;
// import jj.modB.beta.Beta;  // not accessible
import jj.modB.gamma.Gamma;  
import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoAlpha();
		demoBeta();
	}

	static void demoAlpha() {
		Log.logMethodCall();
		new Alpha();
	}

	static void demoBeta() {
		Log.logMethodCall();
		// new Beta();
		new Gamma();
	}
}
