package com.zl.rxretrofitmvp.http.rx;

import com.zl.rxretrofitmvp.base.Result;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author xiaolong
 * @ClassName HttpRx
 * @Date 2018/8/22
 **/
public class HttpRx {

    public static <T extends Result<R>,R> Flowable<R>  normal(Flowable<T> followable) {
        return followable.subscribeOn(Schedulers.io())
                .map(new ResultFunction<>())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
