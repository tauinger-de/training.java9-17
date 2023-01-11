package jj.appl;

// import jj.mod.Alpha;
// import jj.mod.Beta;
import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoAlpha();
		demoBeta();
	}

	static void demoAlpha() {
		Log.logMethodCall();
		// final Alpha alpha = new Alpha();
	}

	static void demoBeta() {
		Log.logMethodCall();
		// final Beta beta = new Beta();  
	}
}
