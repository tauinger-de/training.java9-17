package jj.appl;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import jj.util.base.XRunnable;
import jj.util.log.Log;

public class SimpleSubscriber<T> implements Subscriber<T> {
	
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		Log.tlog("onSubscribe(" + subscription.getClass().getSimpleName() + ")");
		this.subscription = subscription;
		subscription.request(1); 
		// subscription.request(Long.MAX_VALUE); 
	}

	@Override
	public void onNext(T item) {
		Log.tlog("onNext(" + item + ")");
	    XRunnable.xrun(() -> Thread.sleep(100));
    	this.subscription.request(1); 
	}

	@Override
	public void onError(Throwable t) {
		Log.tlog("onError(" + t + ")");
	}

	@Override
	public void onComplete() {
		Log.tlog("onComplete()");
	}
}