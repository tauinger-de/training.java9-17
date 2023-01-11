package jj.appl;

import static jj.util.log.Log.logMethodCall;
import static jj.util.log.Log.tlog;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

import jj.flow.StdSubscriber;
import jj.utils.FilterProcessor;
import jj.utils.MapProcessor;

public class Application {
	public static void main(String[] args) throws Exception {
		demoMapProcessor();
		demoFilterProcessor();
		demoMapFilterProcessor();
	}

	static private void submitSomeItemsAndClose(SubmissionPublisher<String> publisher) {
		String[] colors = new String[] { "red", "green", "blue" };
		for (String color : colors) {
			tlog("submit " + color);
			publisher.submit(color);
		}
		tlog("close");
		publisher.close();
	}

	static void demoMapProcessor() {
		logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>(ForkJoinPool.commonPool(), 1);

		MapProcessor<String, Integer> processor = new MapProcessor<>(s -> s.length());
		tlog("subscribe processor");
		publisher.subscribe(processor);

		StdSubscriber<Integer> subscriber = new StdSubscriber<>(100);
		tlog("subscribe subscriber");
		processor.subscribe(subscriber);

		submitSomeItemsAndClose(publisher);
		subscriber.await(List.of(3, 5, 4));
	}

	static void demoFilterProcessor() {
		logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>(ForkJoinPool.commonPool(), 1);

		FilterProcessor<String> processor = new FilterProcessor<>(s -> s.length() >= 4);
		tlog("subscribe processor");
		publisher.subscribe(processor);

		StdSubscriber<String> subscriber = new StdSubscriber<>(100);
		tlog("subscribe subscriber");
		processor.subscribe(subscriber);

		submitSomeItemsAndClose(publisher);
		subscriber.await(List.of("green", "blue"));
	}

	static void demoMapFilterProcessor() {
		logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>(ForkJoinPool.commonPool(), 1);

		MapProcessor<String, Integer> processor1 = new MapProcessor<>(s -> s.length());
		tlog("subscribe processor 1");
		publisher.subscribe(processor1);

		FilterProcessor<Integer> processor2 = new FilterProcessor<>(i -> i >= 4);
		tlog("subscribe processor 2");
		processor1.subscribe(processor2);

		StdSubscriber<Integer> subscriber = new StdSubscriber<>(100);
		tlog("subscribe subscriber");
		processor2.subscribe(subscriber);

		submitSomeItemsAndClose(publisher);
		subscriber.await(List.of(5, 4));
	}

}