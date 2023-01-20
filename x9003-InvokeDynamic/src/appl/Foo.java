package appl;

public class Foo {

    public static void alpha1() {
        System.out.println("alpha1()");
    }

    public static void alpha2() {
        System.out.println("alpha2()");
    }

    public static void beta(int i) {
        System.out.println("beta(" + i + ")");
    }

    public static void gamma(int i1, int i2) {
        System.out.println("gamma(" + i1 + ", " + i2 + ")");
    }

//	private static CallSite callSiteAlpha = null;
//	public static CallSite bootstrapAlpha(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
//		return callSiteAlpha != null ? callSiteAlpha : (callSiteAlpha = createCallSite(caller, name, type, "alpha1"));
//		// return callSiteAlpha != null ? callSiteAlpha : (callSiteAlpha = createCallSite(caller, name, type, "alpha2"));
//	}
//
//	private static CallSite callSiteBeta = null;
//	public static CallSite bootstrapBeta(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
//		return callSiteBeta != null ? callSiteBeta : (callSiteBeta = createCallSite(caller, name, type, "beta"));
//	}
//
//	private static CallSite callSiteGamma = null;
//	public static CallSite bootstrapGamma(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
//		return callSiteGamma != null ? callSiteGamma : (callSiteGamma = createCallSite(caller, name, type, "gamma"));
//	}
//
//	private static CallSite createCallSite(MethodHandles.Lookup caller, String name, MethodType type, String methodName) throws Exception {
//		System.out.println("createCallSite(\n\t" + caller + "\n\t" + name + "\n\t" + type);
//		final MethodHandles.Lookup lookup = MethodHandles.lookup();
//		final Class<?> thisClass = lookup.lookupClass(); 
//		final MethodHandle mh = lookup.findStatic(thisClass, methodName, type); 
//		
////		final MethodHandle mh = lookup.findStatic(thisClass, methodName, MethodType.methodType(void.class));
////		return callSite = new ConstantCallSite(mh.asType(type));
//
//		return new ConstantCallSite(mh);
//	}
}