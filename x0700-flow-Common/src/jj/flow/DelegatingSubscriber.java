package jj.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.*;

public class DelegatingSubscriber<T> implements Subscriber<T> {

    private final CountDownLatch done = new CountDownLatch(1);

    private Subscription subscription;
    private List<T> receivedItems = new ArrayList<>();

    private Consumer<Subscription> onSubcribeHandler = s -> {
    };
    private BiConsumer<Subscription, T> onNextHandler = (s, i) -> {
    };
    private BiConsumer<Subscription, Throwable> onErrorHandler = (s, t) -> {
    };
    private Consumer<Subscription> onCompleteHandler = s -> {
    };

    public void onSubscribeHandler(Consumer<Subscription> onSubcribeHandler) {
        this.onSubcribeHandler = Objects.requireNonNull(onSubcribeHandler);
    }

    public void onNextHandler(BiConsumer<Subscription, T> onNextHandler) {
        this.onNextHandler = Objects.requireNonNull(onNextHandler);
    }

    public void onErrorHandler(BiConsumer<Subscription, Throwable> onErrorHandler) {
        this.onErrorHandler = Objects.requireNonNull(onErrorHandler);
    }

    public void onCompleteHandler(Consumer<Subscription> onCompleteHandler) {
        this.onCompleteHandler = Objects.requireNonNull(onCompleteHandler);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        tlogEnter(subscription.getClass().getSimpleName());
        this.subscription = subscription;
        this.onSubcribeHandler.accept(this.subscription);
        tlogExit();
    }

    @Override
    public void onNext(T item) {
        tlogEnter(item);
        this.receivedItems.add(item);
        this.onNextHandler.accept(this.subscription, item);
        tlogExit();
    }

    @Override
    public void onError(Throwable t) {
        tlogEnter(t);
        this.onErrorHandler.accept(this.subscription, t);
        done.countDown();
        tlogExit();
    }

    @Override
    public void onComplete() {
        tlogEnter();
        this.onCompleteHandler.accept(this.subscription);
        done.countDown();
        tlogExit();
    }

    public List<T> await() {
        xrun(() -> done.await());
        return this.receivedItems;
    }

    public void await(List<T> expectedItems) {
        xrun(() -> done.await());
        if (!this.receivedItems.equals(expectedItems))
            tlog("ERROR: expected: " + expectedItems + " but received: " + this.receivedItems);
        else
            tlog("SUCCESS");
    }
}