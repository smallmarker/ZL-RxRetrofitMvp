package com.zl.rxretrofitmvp.http;

import com.zl.rxretrofitmvp.http.interceptor.HeadersInterceptor;
import com.zl.rxretrofitmvp.http.interceptor.HttpLoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求
 * @author xiaolong
 * @ClassName HttpClient
 * @Date 2018/6/5
 **/
public class HttpClient {

    private static final long WRITE_TIME_OUT = 3000;

    private static final long READ_TIME_OUT = 3000;

    private static final long CONNECT_TIME_OUT = 3000;

    private static final String BASE_URL = "http://jxhdapi.ooowin.com/";

    private Retrofit mRetrofit;

    private static  HttpClient INSTANCE;

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    public static void initialize() {
        INSTANCE = SingletonHolder.INSTANCE;
    }

    private HttpClient() {
        mRetrofit = provideRetrofit(new Retrofit.Builder(),provideClient(new OkHttpClient.Builder()));
    }

    public static  <T> T createService(Class<T> cls) {
        return INSTANCE.mRetrofit.create(cls);
    }

    private Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, BASE_URL);
    }

    private OkHttpClient provideClient(OkHttpClient.Builder builder) {
        return createClient(builder,WRITE_TIME_OUT,READ_TIME_OUT,CONNECT_TIME_OUT);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient createClient(OkHttpClient.Builder builder, long writeTimeout, long readTimeout, long connectTimeout) {
        return builder
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout,TimeUnit.MILLISECONDS)
                .connectTimeout(connectTimeout,TimeUnit.MILLISECONDS)
                .addInterceptor(provideHHttpLoggingInterceptor())
                .addNetworkInterceptor(provideHeadsInterceptor())
                .build();
    }

    private HeadersInterceptor provideHeadsInterceptor() {
        return new HeadersInterceptor();
    }

    private HttpLoggingInterceptor provideHHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggerInterceptor()).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
