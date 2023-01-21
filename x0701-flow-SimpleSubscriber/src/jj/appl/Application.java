package jj.appl;

import jj.flow.Message;
import jj.util.base.XRunnable;
import jj.util.log.Log;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

public class Application {
    public static void main(String[] args) {
        demoSubmit();
        demoOffer();
    }

    static void demoSubmit() {
        Log.logMethodCall();
        SubmissionPublisher<Message> publisher =
                new SubmissionPublisher<>(ForkJoinPool.commonPool(), 1);

        Log.tlog("MaxBufferCapacity : " + publisher.getMaxBufferCapacity());
        SimpleSubscriber<Message> subscriber = new SimpleSubscriber<>();
        publisher.subscribe(subscriber);

        for (int i = 1000; i < 1010; i++) {
            Message message = new Message(i);
            Log.tlog("submit(" + message + ")");
            publisher.submit(message);
        }

        publisher.close();
        XRunnable.xrun(() -> Thread.sleep(2000));
    }

    static void demoOffer() {
        Log.logMethodCall();
        SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(
                ForkJoinPool.commonPool(), 1);
        Log.tlog("MaxBufferCapacity : " + publisher.getMaxBufferCapacity());
        SimpleSubscriber<Message> subscriber = new SimpleSubscriber<>();
        publisher.subscribe(subscriber);

        for (int i = 1000; i < 1020; i++) {
            XRunnable.xrun(() -> Thread.sleep(50));
            Message message = new Message(i);
            Log.tlog("offer(" + message + ")");
            publisher.offer(message, null);
        }

        publisher.close();
        XRunnable.xrun(() -> Thread.sleep(2000));
    }
}