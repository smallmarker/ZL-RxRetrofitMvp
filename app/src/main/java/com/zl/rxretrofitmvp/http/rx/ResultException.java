package com.zl.rxretrofitmvp.http.rx;

/**
 * @author xiaolong
 * @ClassName ResultException
 * @Date 2018/8/23
 **/
public class ResultException extends Exception{

    //返回成功
    public static final int TYPE_CODE_SUCCESS = 1;

    //返回失败
    public static final int TYPE_CODE_FAIL = 0;

    private int code;
    private String msg;

    ResultException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
