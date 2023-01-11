package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInspector {
	public static void inspect(final Class<?> cls) {
		System.out.println("| " + cls.getName());
		System.out.println("| Superclass");
		System.out.println("| \t" + cls.getSuperclass().getName());
		System.out.println("| Interfaces");
		for (Class<?> iface : cls.getInterfaces()) {
			System.out.println("| \t" + iface.getName());
		}
		System.out.println("| Fields");
		for (final Field member : cls.getDeclaredFields()) {
			System.out.println("| \t" + member);
		}
		System.out.println("| Constructors");
		for (final Constructor<?> member : cls.getDeclaredConstructors()) {
			System.out.println("| \t" + member);
		}
		System.out.println("| Methods");
		for (final Method member : cls.getDeclaredMethods()) {
			System.out.println("| \t" + member);
		}
		System.out.println("| InnerClasses");
		for (final Class<?> member : cls.getClasses()) {
			System.out.println("| \t" + (Modifier.isStatic(member.getModifiers()) ? "static " : "") + member.getName());
		}
	}

	public static void inspect(final String classFilename) {
		try {
			System.out.println(classFilename);
			Process process = new ProcessBuilder("javap", classFilename).start();
			try (InputStream is = process.getInputStream()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				BufferedReader br = new BufferedReader(reader);
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
