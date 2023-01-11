package jj.appl;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.logMethodCall;
import static jj.util.log.Log.tlog;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

import jj.flow.Message;
import jj.flow.StdSubscriber;

public class Application {
	public static void main(String[] args) {
		demoConsume();
		demoInspect();
		demoEstimate();
	}

	static void demoConsume() {
		logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(ForkJoinPool.commonPool(), 1);

		CompletableFuture<Void> future = publisher.consume((Message m) -> {
			xrun(() -> Thread.sleep(10));
			tlog("accept " + m);
		});

		for (int i = 0; i < 10; i++) { // 300 !!
			tlog("submit " + i);
			publisher.submit(new Message(i));
		}

		tlog("close");
		publisher.close();

		xrun(() -> future.get());
	}

	static void demoInspect() {
		logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();
		StdSubscriber<Message> subscriber1 = new StdSubscriber<>(10);
		StdSubscriber<Message> subscriber2 = new StdSubscriber<>(10);
		publisher.subscribe(subscriber1);
		publisher.subscribe(subscriber2);
		tlog(publisher.getExecutor());
		tlog(publisher.getMaxBufferCapacity());
		tlog(publisher.getNumberOfSubscribers());
		tlog(publisher.hasSubscribers());
		tlog(publisher.getSubscribers());
		tlog(publisher.isSubscribed(subscriber1));
		publisher.close();
		subscriber1.await();
		subscriber2.await();
	}

	static void demoEstimate() {
		logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();
		StdSubscriber<Message> subscriber = new StdSubscriber<>(100);
		publisher.subscribe(subscriber);

		tlog(publisher.estimateMinimumDemand());
		tlog(publisher.estimateMaximumLag());

		for (int i = 0; i < 5; i++) {
			tlog("submit " + i);
			publisher.submit(new Message(i));
		}

		tlog(publisher.estimateMinimumDemand());
		tlog(publisher.estimateMaximumLag());
		tlog("close");
		publisher.close();
		subscriber.await();
	}

}