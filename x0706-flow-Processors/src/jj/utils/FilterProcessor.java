package jj.utils;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

import jj.flow.DelegatingSubscriber;

public class FilterProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {

	private final DelegatingSubscriber<T> subscriber = new DelegatingSubscriber<>();

	public FilterProcessor(Predicate<? super T> predicate) {
		super(ForkJoinPool.commonPool(), 1);
		this.subscriber.onSubscribeHandler(s -> s.request(1));
		this.subscriber.onNextHandler((s, item) -> {
			if (predicate.test(item))
				this.submit(item);
			s.request(1);
		});
		this.subscriber.onCompleteHandler(s -> this.close());
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscriber.onSubscribe(subscription);
	}

	@Override
	public void onNext(T item) {
		this.subscriber.onNext(item);
	}

	@Override
	public void onError(Throwable t) {
		this.subscriber.onError(t);
	}

	@Override
	public void onComplete() {
		this.subscriber.onComplete();
	}
}