package com.zl.rxretrofitmvp.http.rx;

import com.zl.rxretrofitmvp.base.Result;

import io.reactivex.functions.Function;

/**
 * @author xiaolong
 * @ClassName ResultFunction
 * @Date 2018/8/23
 **/
public class ResultFunction<T extends Result<R>,R> implements Function<T,R> {

    @Override
    public R apply(T t) throws Exception {
        if (t.getCode() == 1) {
            if (t.getData() != null) {
                return t.getData();
            }
            throw new ResultException(ResultException.TYPE_CODE_SUCCESS,"data is null");
        }
        throw  new ResultException(ResultException.TYPE_CODE_FAIL,t.getMsg());
    }
}
