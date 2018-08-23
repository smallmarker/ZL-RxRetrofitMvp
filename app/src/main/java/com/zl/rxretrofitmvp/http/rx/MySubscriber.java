package com.zl.rxretrofitmvp.http.rx;

import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;

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
        if (t instanceof ResultException) {
            ResultException exception = (ResultException) t;
            Logger.e(exception.getMsg());
        } else if (t instanceof IOException) {
            Logger.e("网络异常");
        } else {
            Logger.e(t.getMessage());
        }
    }

    @Override
    public void onComplete() {
        Logger.d("数据加载完成");
    }

    protected abstract void onSuccess(T t);

}
