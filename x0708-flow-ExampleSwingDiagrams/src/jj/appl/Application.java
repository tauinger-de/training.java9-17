package jj.appl;

import jj.core.Message;
import jj.flow.DelegatingSubscriber;
import jj.gui.DiagramFrame;
import jj.util.log.Log;

import java.awt.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

import static jj.util.base.XRunnable.xrun;

public class Application {
    public static void main(String[] args) {
        Log.enabled = false;
        new Application().run();
    }

    private final SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(
            ForkJoinPool.commonPool(), 1);

    private int[] delays = new int[]{10, 50, 100};

    private final DiagramFrame frame = new DiagramFrame(this.getClass().getSimpleName(), 100, 100, Color.blue,
            delays.length);

    private void run() {
        for (int i = 0; i < this.delays.length; i++)
            this.subscribe(i, this.delays[i]);
        new Thread(() -> generateMessages(10)).start();
    }

    private void subscribe(int index, int delay) {
        DelegatingSubscriber<Message> subscriber = new DelegatingSubscriber<>();
        subscriber.onSubscribeHandler(s -> s.request(1));
        subscriber.onNextHandler((s, msg) -> {
            this.frame.processMessage(index, msg);
            xrun(() -> Thread.sleep(delay));
            s.request(1);
        });
        publisher.subscribe(subscriber);
    }

    private void generateMessages(int delay) {
        long sequenceNumber = 0;
        for (double x = 0; !this.frame.isClosed(); x += 0.01) {
            xrun(() -> Thread.sleep(delay));
            sequenceNumber++;
            final Message message = new Message(sequenceNumber, Math.sin(x));
            // this.publisher.submit(message);
            this.publisher.offer(message, null);
        }
        this.publisher.close();
    }
}