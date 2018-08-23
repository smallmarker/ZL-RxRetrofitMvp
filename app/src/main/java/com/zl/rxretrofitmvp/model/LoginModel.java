package com.zl.rxretrofitmvp.model;

import com.zl.rxretrofitmvp.base.BaseModel;

/**
 * @author xiaolong
 * @ClassName LoginModel
 * @Date 2018/8/22
 **/
public class LoginModel extends BaseModel {

    /**
     * 模仿简单的登录
     * @param userName 用户名
     * @param userPwd 用户密码
     * @param listener 回调监听
     */
    public void login(String userName, String userPwd, LoginListener listener) {

        if ("xiaolong".equals(userName) && "123456".equals(userPwd)) {
            listener.loginSuccess();
        } else {
            listener.loginFail();
        }

    }

}
