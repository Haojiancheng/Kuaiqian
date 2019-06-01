package com.gxd.module_home.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gxd.component.base.fragment.BaseNetworkFragment;
import com.gxd.module_home.R;


@Route(path = "/module_home/HomeFragment")
public class HomeFragment extends BaseNetworkFragment {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getViewById() {
        return R.layout.fragment_home;
    }

    @Override
    protected void successed(Object data) {

    }

    @Override
    protected void failed(String error) {

    }
}
