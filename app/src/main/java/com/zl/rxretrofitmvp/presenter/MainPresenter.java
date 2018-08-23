package com.zl.rxretrofitmvp.presenter;

import com.zl.rxretrofitmvp.base.BasePresenter;
import com.zl.rxretrofitmvp.bean.Province;
import com.zl.rxretrofitmvp.contract.MainContract;
import com.zl.rxretrofitmvp.model.MainListener;
import com.zl.rxretrofitmvp.model.MainModel;

import java.util.List;

/**
 * @author xiaolong
 * @ClassName MainPresenter
 * @Date 2018/8/22
 **/
public class MainPresenter extends BasePresenter<MainModel,MainContract.MainView> implements MainListener, MainContract.MainPresenter {
    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    @Override
    public void getProvince() {
        mModel.getProvince(this);
    }

    @Override
    public void setProvinces(List<Province> provinces) {
        mView.addProvinces(provinces);
    }
}
