package com.zl.rxretrofitmvp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zl.rxretrofitmvp.http.HttpClient;

/**
 * @author xiaolong
 * @ClassName MyApp
 * @Date 2018/8/22
 **/
public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        HttpClient.initialize();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
