package jj.mod;

import java.lang.System.Logger;
import java.lang.System.LoggerFinder;
 
public class MyLoggerFinder extends LoggerFinder {
 
	@Override
	public Logger getLogger(String name, Module module) {
		System.out.println(this.getClass().getSimpleName() + ".getLogger(" + name + ", " + module + ")");
		if (name.equals("VerboseLogger"))
			return new VerboseLogger();
		if (name.equals("SimpleLogger"))
			return new SimpleLogger();
		return null;
	}
}