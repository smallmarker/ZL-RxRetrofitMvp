package com.zl.rxretrofitmvp.base;

/**
 * @author xiaolong
 * @ClassName IPresenter
 * @Date 2018/8/22
 **/
public interface IPresenter<V extends IBaseView> {

    void attachView(V mView);

    void detachView();

}
