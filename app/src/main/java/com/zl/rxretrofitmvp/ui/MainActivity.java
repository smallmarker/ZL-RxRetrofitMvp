package com.zl.rxretrofitmvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zl.rxretrofitmvp.R;
import com.zl.rxretrofitmvp.base.BaseActivity;
import com.zl.rxretrofitmvp.bean.Province;
import com.zl.rxretrofitmvp.contract.MainContract;
import com.zl.rxretrofitmvp.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MainView{

    private ListView mProvincesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProvincesListView = findViewById(R.id.lv_province);
        mPresenter.getProvince();
    }

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void addProvinces(List<Province> provinces) {
        List<String> data = new ArrayList<>();
        for (Province province : provinces) {
            data.add(province.getAreaName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        mProvincesListView.setAdapter(adapter);
    }
}
