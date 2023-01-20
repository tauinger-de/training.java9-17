package jj.utils;

import jj.flow.DelegatingSubscriber;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MapProcessor<T, R> extends SubmissionPublisher<R> implements Processor<T, R> {

    private DelegatingSubscriber<T> subscriber = new DelegatingSubscriber<>();

    public MapProcessor(Function<? super T, ? extends R> function) {
        super(ForkJoinPool.commonPool(), 1);
        this.subscriber.onSubscribeHandler(s -> s.request(1));
        this.subscriber.onNextHandler((s, item) -> {
            this.submit((R) function.apply(item));
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