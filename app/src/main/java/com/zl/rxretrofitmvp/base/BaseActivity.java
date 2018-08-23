package com.zl.rxretrofitmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author xiaolong
 * @ClassName BaseActivity
 * @Date 2018/6/6
 **/
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = getPresenter();
        }
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    public abstract P getPresenter();
}
