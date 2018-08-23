package com.zl.rxretrofitmvp.base;

import com.zl.rxretrofitmvp.http.ApiManager;
import com.zl.rxretrofitmvp.http.HttpClient;
import com.zl.rxretrofitmvp.http.api.ApiService;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author xiaolong
 * @ClassName BaseModel
 * @Date 2018/8/22
 **/
public abstract class BaseModel {

    protected ApiManager getApiManager() {
        return new ApiManager(HttpClient.createService(ApiService.class));
    }

}
