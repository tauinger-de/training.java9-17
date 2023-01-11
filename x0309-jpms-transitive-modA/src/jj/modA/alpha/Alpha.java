package jj.modA.alpha;

import jj.modB.beta.Beta;

public class Alpha {
	public Beta pub() {  
		// wenn transitive fehlt, dann wird folgende Warnung angezeigt:
		// The type Beta from module jj.modB may not be accessible to clients due to missing 'requires transitive'
		return new Beta();
	}
}
