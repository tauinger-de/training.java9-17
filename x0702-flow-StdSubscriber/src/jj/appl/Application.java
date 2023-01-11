package jj.appl;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

import jj.flow.Message;
import jj.flow.StdSubscriber;
import jj.util.base.XRunnable;
import jj.util.log.Log;

public class Application {
	public static void main(String[] args) {
		demoStdSubscriber1();
		demoStdSubscriber2();
	}

	static void demoStdSubscriber1() {
		Log.logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(
				ForkJoinPool.commonPool(), 1);
		
		StdSubscriber<Message> subscriber = new StdSubscriber<>(0);

		Log.tlog("subscribe");
		publisher.subscribe(subscriber);

		Log.tlog("submit 1000");
		publisher.submit(new Message(1000));

		Log.tlog("close");
		publisher.close();
		subscriber.await(List.of(new Message(1000)));
	}

	static void demoStdSubscriber2() {
		Log.logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>(
				ForkJoinPool.commonPool(), 1);
        AnotherSubscriber<Message> subscriber = new AnotherSubscriber<>(100);
		Log.tlog("subscribe");
		publisher.subscribe(subscriber);

		Log.tlog("submit 1000");
		publisher.submit(new Message(1000));

		Log.tlog("close");
		publisher.close();
		subscriber.await(List.of(new Message(1000)));
		
		XRunnable.xrun(() -> Thread.sleep(2000));
	}
}