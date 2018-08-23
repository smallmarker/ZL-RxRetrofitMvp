package com.zl.rxretrofitmvp.contract;

import com.zl.rxretrofitmvp.base.IBaseView;
import com.zl.rxretrofitmvp.bean.Province;

import java.util.List;

/**
 * @author xiaolong
 * @ClassName MainContract
 * @Date 2018/8/22
 **/
public interface MainContract {

    interface MainView extends IBaseView {

        void addProvinces(List<Province> provinces);

    }

    interface MainPresenter {

        void getProvince();

    }
}
