package jj.appl;

import jj.domain.Book;
import jj.reflection.Mapper;
import jj.util.log.Log;

public class Application {

	public static void main(String[] args) {
		demoReflection();
	}

	static void demoReflection() {
		Log.logMethodCall();
		Book book = new Book("1111", "Pascal", 1970, "N. Wirth");
		Mapper.map(book).forEach((name, value) -> System.out.println(name + " = " + value));
	}
}
