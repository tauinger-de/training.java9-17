package jj.appl;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.tlog;

import jj.flow.DelegatingSubscriber;

public class MySubscriber<T> extends DelegatingSubscriber<T> {

	private int counter = 0;
	private final int N = 5;
	@SuppressWarnings("unchecked")
	private final T[] array = (T[]) new Object[N-1];

	public MySubscriber(int sleepTime) {
		this.onSubscribeHandler(s -> {
			this.counter = 0;
			tlog("request(" + this.N + ")");
			s.request(this.N);

		});
		this.onNextHandler((s, item) -> {
			if (counter < N - 1) {
				this.array[this.counter] = item;
				this.counter++;
				return;
			}
			tlog("==> working...");
			for(T elem : this.array) {
				tlog("    " + elem);
			}
			xrun(() -> Thread.sleep(sleepTime));
			this.counter = 0;
			tlog("request(" + this.N + ")");
			s.request(this.N);
		});
	}
}