package client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		final int N = 3;
		final CountDownLatch done = new CountDownLatch(N);

		WebSocket.Listener listener = new WebSocket.Listener() {
			@Override
			public void onOpen(WebSocket webSocket) {
				println("onOpen");
				WebSocket.Listener.super.onOpen(webSocket);
			}

			@Override
			public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
				println("onText(" + data + ")");
				return WebSocket.Listener.super.onText(webSocket, data, last);
			}

			@Override
			public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
				println("onClose(" + statusCode + ", " + reason + ")");
				done.countDown();
				return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
			}
		};

		// final ExecutorService executor = Executors.newFixedThreadPool(100);
		final HttpClient client = HttpClient.newBuilder()
				.version(Version.HTTP_2)
				// .executor(executor)
				.build();

		Watch w = new Watch("duration with " + N + " WebSockets");
		for (int i = 0; i < N; i++) {
			WebSocket webSocket = client.newWebSocketBuilder()
					.buildAsync(URI.create("ws://localhost:8080/ws/math"), listener).join();

			println("sendText(40,2)");
			webSocket.sendText("40,2", true);
			println("sendText(70,7)");
			webSocket.sendText("70,7", true);

			println("sendClose()");
			webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
		}
		println("await()");
		done.await();
		println(w.toString());
	}

	private static void println(String message) {
		System.out.printf("[%2d] %s\n", Thread.currentThread().getId(), message);
	}

}
