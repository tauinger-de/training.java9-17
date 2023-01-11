package appl;

public class Application {
	// @SuppressWarnings("preview")
	public static void main(String[] args) {
		final Statement s = new Loop();
		if (s instanceof Assignment a) {
			System.out.println(a);
		}
		else if (s instanceof Loop l) {
			System.out.println(l);
		}
		else if (s instanceof Choice c) {
			System.out.println(c);
		}
		else if (s instanceof Call c) {
			System.out.println(c);
		}
		
		for (final Class<?> cls : Statement.class.getPermittedSubclasses()) {
			System.out.println(cls.getName());
		}
		
//		int x = switch (s) {
//	        case Assignment a   -> 1;
//	        case Loop l    		-> 2;
//	        case Choice c    	-> 3;
//	        case Call c    		-> 4;
// 			// no default needed
//	    };

	}
}
