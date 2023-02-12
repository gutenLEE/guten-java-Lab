package com.example.webflux.toby;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author gutenlee
 * @since 2023/02/12
 */
public class DelegateSub<T, R> implements Subscriber<T> {

    private Subscriber sub;
    public DelegateSub(Subscriber<? super R> sub) {
        this.sub = sub;
    }

    @Override
    public void onSubscribe(Subscription s) {
        sub.onSubscribe(s);
    }

    @Override
    public void onNext(T integer) {
        sub.onNext(integer);
    }

    @Override
    public void onError(Throwable t) {
        sub.onError(t);
    }

    @Override
    public void onComplete() {
        sub.onComplete();
    }
}
