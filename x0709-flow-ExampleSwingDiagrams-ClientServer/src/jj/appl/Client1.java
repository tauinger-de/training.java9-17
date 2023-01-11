package jj.appl;

import java.awt.Color;

public class Client1 {
	public static void main(String[] args) throws Exception {
		new Client().run(Client1.class.getSimpleName(), 100, 100, Color.blue, 20, 10);
	}	
}