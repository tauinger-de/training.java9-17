package jj.source;

import jj.core.Message;
import jj.flow.DelegatingSubscriber;
import jj.gui.DiagramFrame;
import jj.util.base.XRunnable;
import jj.util.log.Log;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.UnaryOperator;

import static jj.util.base.XRunnable.xrun;

public class Source {

    public static void main(String[] args) throws Exception {
        Log.enabled = false;
        new Source().run();
    }

    private final Runnable[] runnables = new Runnable[]{
            () -> generateMessages(0, Math::sin, 10, 0.01),
            () -> generateMessages(1, Math::cos, 20, 0.01),
    };

    private final DiagramFrame frame = new DiagramFrame(this.getClass().getSimpleName(), 400, 400, Color.red,
            runnables.length);

    private final SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(
            ForkJoinPool.commonPool(), 1);

    private void run() throws Exception {

        for (Runnable runnable : this.runnables)
            new Thread(runnable).start();

        try (ServerSocket serverSocket = new ServerSocket(8001)) {
            serverSocket.setSoTimeout(1000);
            while (!frame.isClosed()) {
                try {
                    final Socket socket = serverSocket.accept();
                    new Thread(() -> runSession(socket)).start();
                    System.out.println();
                } catch (SocketTimeoutException e) {
                    System.out.print(".");
                }
            }
            this.publisher.close();
        }
    }

    private void generateMessages(final int index, final UnaryOperator<Double> function, final int delay,
                                  final double delta) {
        long sequenceNumber = 0;
        for (double x = 0; true; x += delta) {
            xrun(() -> Thread.sleep(delay));
            sequenceNumber++;
            final Message message = new Message(index, sequenceNumber, function.apply(x));
            this.frame.processMessage(message.index, message);
            try {
                this.publisher.offer(message, null);
            } catch (IllegalStateException e) {
                break;
            }
        }
    }

    private void runSession(Socket socket) {
        try {
            // final ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            final ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

            final DelegatingSubscriber<Message> subscriber = new DelegatingSubscriber<>();
            subscriber.onSubscribeHandler(s -> s.request(1));
            subscriber.onNextHandler((s, msg) -> {
                try {
                    //is.readObject();
                    os.writeObject(msg);
                } catch (Exception e) {
                    XRunnable.xrun(() -> socket.close());
                    s.cancel();
                }
                s.request(1);
            });
            this.publisher.subscribe(subscriber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
