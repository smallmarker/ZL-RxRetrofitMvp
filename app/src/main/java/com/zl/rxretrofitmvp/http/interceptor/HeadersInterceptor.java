package com.zl.rxretrofitmvp.http.interceptor;


import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 添加header
 * @author xiaolong
 * @ClassName HeadersInterceptor
 * @Date 2018/6/5
 **/
public class HeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request build = request.newBuilder().addHeader("token", "").build();
        return chain.proceed(build);
    }
}
