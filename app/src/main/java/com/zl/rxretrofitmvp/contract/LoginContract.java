package com.zl.rxretrofitmvp.contract;

import com.zl.rxretrofitmvp.base.IBaseView;

/**
 * @author xiaolong
 * @ClassName LoginContract
 * @Date 2018/8/22
 **/
public interface LoginContract {

    interface LoginView extends IBaseView {

        String getUserName();

        String getUserPwd();

        void loginSuccess();

        void loginFail();

    }

    interface LoginPresenter {

        void login(String userName,String userPwd);

    }
}
