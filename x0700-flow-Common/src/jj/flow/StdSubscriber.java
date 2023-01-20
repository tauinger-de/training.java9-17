package jj.flow;

import static jj.util.base.XRunnable.xrun;
import static jj.util.log.Log.tlog;

public class StdSubscriber<T> extends DelegatingSubscriber<T> {

    public StdSubscriber(int sleepTime) {
        this.onSubscribeHandler(s -> {
            int n = 1;
            tlog("request(" + n + ")");
            s.request(n);
        });
        this.onNextHandler((s, item) -> {
            int n = 1;
            tlog("sleep(" + sleepTime + ")");
            xrun(() -> Thread.sleep(sleepTime));
            tlog("request(" + n + ")");
            s.request(n);
        });
    }
}