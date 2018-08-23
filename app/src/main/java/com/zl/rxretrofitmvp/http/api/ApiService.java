package com.zl.rxretrofitmvp.http.api;

import com.zl.rxretrofitmvp.base.Result;
import com.zl.rxretrofitmvp.bean.Province;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * @author xiaolong
 * @ClassName ApiService
 * @Date 2018/8/22
 **/
public interface ApiService {
    //获取省列表
    @GET("common/areas")
    Flowable<Result<List<Province>>> province();
}
