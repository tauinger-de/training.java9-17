package websockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/math")
public class MathServer {

	public MathServer() {
		this.println("CTOR");
	}

	@OnOpen
	public void onOpen() {
		this.println("onOpen()");
	}

	@OnClose
	public void onClose() {
		this.println("onClose()");
	}

	@OnMessage
	public String onMessage(String message) throws Exception {
		this.println(">> onMessage(" + message + ")");
		String[] tokens = message.split(",");
		try {
			final int x = Integer.parseInt(tokens[0]);
			final int y = Integer.parseInt(tokens[1]);
			final int result = x + y;
			Thread.sleep(1000);
			this.println("<< onMessage(" + message + ")");
			return String.valueOf(result);
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}

	@OnError
	public void onError(Throwable e) {
		this.println("onError(" + e + ")");
	}

	private void println(String message) {
		System.out.printf("[%3d] %s\n", Thread.currentThread().getId(), message);
	}
}