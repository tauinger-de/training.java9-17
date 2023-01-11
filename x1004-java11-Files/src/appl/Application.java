package appl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import jj.util.log.Log;

public class Application {

	public static void main(String[] args) throws IOException {
		demo1();
		demo2();
		demo3();
	}
	
	static void demo1() throws IOException {
		Log.logMethodCall();
		var path = Path.of("abc.txt");

		Files.writeString(path, "Hello\n");
		Files.writeString(path, "World\n");
		Files.writeString(path, "Good\nBye\n");
		 
		final String line1 = Files.readString(path);
		final String line2 = Files.readString(path);
		final String line3 = Files.readString(path);
		 
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
	}
	
	static void demo2() throws IOException {
		Log.logMethodCall();
		var path = Path.of("abc.txt");

		Files.writeString(path, "Hello\n");
		Files.writeString(path, "World\n", StandardOpenOption.APPEND);
		 
		final String line = Files.readString(path);
		
		System.out.println(line);
	}

	static void demo3() throws IOException {
		Log.logMethodCall();
		var path = Path.of("abc.txt");

		Files.writeString(path, "Hello\n");
		Files.writeString(path, "World\n", StandardOpenOption.APPEND);
		 
		Files.readString(path).lines().forEach(System.out::println);
	}
}
