package jj.appl;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.logMethodCall;
import static jj.util.log.Log.tlog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import jj.flow.Message;

public class Application {
	public static void main(String[] args) throws Exception {
		demo();
	}

	static void demo() {
		logMethodCall();
		SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();
		MySubscriber<Message> subscriber = new MySubscriber<>(100);
		publisher.subscribe(subscriber);

		List<Message> expected = new ArrayList<>();
		for (int i = 1000; i < 1015; i++) {
			Message message = new Message(i);
			expected.add(message);
			tlog("submit " + i);
			xrun(() -> Thread.sleep(100));
			publisher.submit(message);
		}

		tlog("close");
		publisher.close();
		subscriber.await(expected);
	}

}