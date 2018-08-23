package com.zl.rxretrofitmvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zl.rxretrofitmvp.R;
import com.zl.rxretrofitmvp.base.BaseActivity;
import com.zl.rxretrofitmvp.contract.LoginContract;
import com.zl.rxretrofitmvp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    private EditText mName;
    private EditText mPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = findViewById(R.id.et_name);
        mPwd = findViewById(R.id.et_pwd);

        findViewById(R.id.btn_login).setOnClickListener(view -> mPresenter.login(getUserName(),getUserPwd()));
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getUserName() {
        return mName.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return mPwd.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this,"login success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this,"login fail",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
