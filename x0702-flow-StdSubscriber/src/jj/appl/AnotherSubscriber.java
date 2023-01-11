package jj.appl;

import static jj.util.log.Log.tlog;
import static jj.util.base.XRunnable.xrun;

import jj.flow.DelegatingSubscriber;

public class AnotherSubscriber<T> extends DelegatingSubscriber<T> {

	public AnotherSubscriber(int sleepTime) {
		this.onSubscribeHandler(s -> {
			new Thread(() -> {
				int n = 1;
				tlog("request(" + n + ")");
				s.request(n);
			}).start();
		});
		this.onNextHandler((s, item) -> {
			new Thread(() -> {
				int n = 1;
				xrun(() -> Thread.sleep(sleepTime));
				tlog("request(" + n + ")");
				s.request(n);
			}).start();
		});
	}
}