package jj.appl;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.System.LoggerFinder;
import java.util.ServiceLoader;

import jj.util.log.Log;

public class Application {

	public static void main(String args[]) {
		demoSimpleLogger();
		demoVerboseLogger();
		// demoServiceLoader();
	}

	static void demoSimpleLogger() {
		Log.logMethodCall();
		Logger logger = System.getLogger("SimpleLogger");
		System.out.println(logger.getName());
		logger.log(Level.ERROR, "Water in drive A:");
		logger.log(Level.INFO, "Nice day");	
	}

	static void demoVerboseLogger() {
		Log.logMethodCall();
		Logger logger = System.getLogger("VerboseLogger");
		System.out.println(logger.getName());
		logger.log(Level.ERROR, "Water in drive A:");
		logger.log(Level.INFO, "Nice day");	
	}
	
	static void demoServiceLoader() {
		// requires uses in module-info
		Log.logMethodCall();
		final ServiceLoader<LoggerFinder> loader = ServiceLoader.load(LoggerFinder.class);
		for (LoggerFinder finder : loader) {
			System.out.println("===> " + finder);
		}
	}
}