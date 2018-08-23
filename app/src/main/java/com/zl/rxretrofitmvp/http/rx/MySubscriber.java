package com.zl.rxretrofitmvp.http.rx;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author xiaolong
 * @ClassName MySubscriber
 * @Date 2018/8/23
 **/
public abstract class MySubscriber<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);
}
