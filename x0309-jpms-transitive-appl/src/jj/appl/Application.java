package jj.appl;

import jj.modA.alpha.Alpha;
import jj.modB.beta.Beta;  
import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoAlpha();
		demoBeta();
	}

	static void demoAlpha() {
		Log.logMethodCall();
		new Alpha();
		Beta beta = new Alpha().pub();
	}

	static void demoBeta() {
		Log.logMethodCall();
		new Beta();
	}
}
