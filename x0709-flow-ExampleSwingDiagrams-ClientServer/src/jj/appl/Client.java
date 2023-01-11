package jj.appl;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.net.Socket;

import jj.core.Message;
import jj.gui.DiagramFrame;
import static jj.util.base.XRunnable.xrun;
import jj.util.log.Log;

public class Client {

	public void run(String title, int x, int y, Color color, int... delays) {
		Log.enabled = false;

		final DiagramFrame frame = new DiagramFrame(title, x, y, color, delays.length);
		
		try (final Socket socket = new Socket("localhost", 8001)) {

			//final ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
			final ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

			while (! frame.isClosed()) {
				//os.writeObject("");
				final Message message = (Message) is.readObject();
				xrun(() -> Thread.sleep(delays[message.index]));
				frame.processMessage(message.index, message);
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}