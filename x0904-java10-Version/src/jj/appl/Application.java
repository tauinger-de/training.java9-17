package jj.appl;

import java.util.List;

import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoVersion();
	}

	static void demoVersion() {
		Log.logMethodCall();
		Runtime.Version v = Runtime.version();
		System.out.println(v);
//		deprectated:
//		System.out.println(v.major());
//		System.out.println(v.minor());
		List<Integer> vlist = v.version();
		System.out.println(vlist);
        System.out.println("feature = " + v.feature());
        System.out.println("interim = " + v.interim());
        System.out.println("update  = " + v.update());
        System.out.println("patch   = " + v.patch());
		System.out.println(v.build());
	
	}

}
