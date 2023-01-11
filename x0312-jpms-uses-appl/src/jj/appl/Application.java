package jj.appl;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import jj.operators.iface.Operator;

public class Application {

	public static void main(String[] args) {
		final ServiceLoader<Operator> loader = ServiceLoader.load(Operator.class);
		final Map<String, Operator> operators = new HashMap<>();
		loader.forEach(op -> operators.put(op.name(), op));

		operators.forEach((name, op) -> {
			System.out.println(name + ": " + op.apply(40, 2));
		});
	}

}
