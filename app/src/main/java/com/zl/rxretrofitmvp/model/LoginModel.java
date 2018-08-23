package com.zl.rxretrofitmvp.model;

import com.zl.rxretrofitmvp.base.BaseModel;

/**
 * @author xiaolong
 * @ClassName LoginModel
 * @Date 2018/8/22
 **/
public class LoginModel extends BaseModel {

    public void login(String userName, String userPwd,LoginListener listener) {

        if ("xiaolong".equals(userName) && "123456".equals(userPwd)) {
            listener.loginSuccess();
        } else {
            listener.loginFail();
        }
    }

}
