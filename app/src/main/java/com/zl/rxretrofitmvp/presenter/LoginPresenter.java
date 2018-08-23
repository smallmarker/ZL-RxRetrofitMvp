package com.zl.rxretrofitmvp.presenter;

import com.zl.rxretrofitmvp.base.BasePresenter;
import com.zl.rxretrofitmvp.contract.LoginContract;
import com.zl.rxretrofitmvp.model.LoginListener;
import com.zl.rxretrofitmvp.model.LoginModel;

/**
 * @author xiaolong
 * @ClassName LoginPresenter
 * @Date 2018/8/22
 **/
public class LoginPresenter extends BasePresenter<LoginModel,LoginContract.LoginView> implements LoginContract.LoginPresenter,LoginListener {
    @Override
    protected LoginModel createModel() {
        return new LoginModel();
    }

    @Override
    public void login(String userName, String userPwd) {

        mModel.login(userName,userPwd,this);

    }

    @Override
    public void loginSuccess() {
        mView.loginSuccess();
    }

    @Override
    public void loginFail() {
        mView.loginFail();
    }
}
