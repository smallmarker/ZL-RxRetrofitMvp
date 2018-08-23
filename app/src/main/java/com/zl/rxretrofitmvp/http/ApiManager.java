package com.zl.rxretrofitmvp.http;

import com.zl.rxretrofitmvp.base.Result;
import com.zl.rxretrofitmvp.bean.Province;
import com.zl.rxretrofitmvp.http.api.ApiService;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author xiaolong
 * @ClassName ApiManager
 * @Date 2018/8/22
 **/
public class ApiManager implements ApiService {
    private ApiService apiService;

    public ApiManager(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Flowable<Result<List<Province>>> province() {
        return apiService.province();
    }
}
