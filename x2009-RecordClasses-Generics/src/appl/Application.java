package appl;

import java.util.HashMap;

public class Application {
	public static void main(String[] args) {
	
		final Pair<Integer, String> pair = new Pair<>(42, "Hello");
		System.out.println(pair);
		System.out.println(pair.first() + " " + pair.second());
		
		final var map = new HashMap<Pair<Integer,Integer>, String>();
		map.put(new Pair<Integer,Integer>(10, 20), "Jever");
		map.put(Pair.of(20, 30), "Bitburger");
		map.put(Pair.of(30, 40), "Jever");
		System.out.println(map.get(Pair.of(20,  30)));
	}
}
