package com.gxd.module_mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gxd.component.base.fragment.BaseNetworkFragment;


/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = "/module_mine/MineFragment")
public class MineFragment extends BaseNetworkFragment {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getViewById() {
        return R.layout.mine_loan_details;
    }

    @Override
    protected void successed(Object data) {

    }

    @Override
    protected void failed(String error) {

    }
}
