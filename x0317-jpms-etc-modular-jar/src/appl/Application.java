package appl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {

	public static void main(String[] args) {
		System.out.println("begin...");
		try (Connection con = DriverManager.getConnection("tunix")) {
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("end...");
	}
}
