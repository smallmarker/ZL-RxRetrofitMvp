package com.zl.rxretrofitmvp.http.interceptor;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 添加日志
 * @author xiaolong
 * @ClassName HttpLoggerInterceptor
 * @Date 2018/6/5
 **/
public class HttpLoggerInterceptor implements HttpLoggingInterceptor.Logger{
    @Override
    public void log(@NonNull String message) {
        Logger.json(message);
    }
}
