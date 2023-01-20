package jj.appl;

import jj.flow.Message;
import jj.flow.StdSubscriber;

import java.util.concurrent.atomic.AtomicInteger;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.logMethodCall;
import static jj.util.log.Log.tlog;

public class Application {
    public static void main(String[] args) {
        demo();
    }

    static void demo() {
        logMethodCall();
        AtomicInteger number = new AtomicInteger(42);
        tlog("creating Publisher");
        PeriodicPublisher<Message> publisher = new PeriodicPublisher<>(1000, () -> new Message(number.getAndIncrement()));
        StdSubscriber<Message> subscriber = new StdSubscriber<>(1);
        xrun(() -> Thread.sleep(2000));
        tlog("subscribe");
        publisher.subscribe(subscriber);
        xrun(() -> Thread.sleep(5000));
        tlog("close");
        publisher.close();
        subscriber.await();
    }
}
