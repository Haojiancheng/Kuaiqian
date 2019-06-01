package com.gxd.component.base.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gxd.component.GetContent;
import com.gxd.component.mvp.persenter.IPersenterImpl;
import com.gxd.component.mvp.view.IView;
import com.gxd.component.utils.LoadingUtils;
import com.gxd.component.utils.NetWorkUtils;
import com.gxd.component.utils.ToastUtils;

import java.util.Map;

public abstract class BaseNetworkFragment extends Fragment implements IView {

    IPersenterImpl iPersenter;

    private Dialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getViewById(),container,false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        iPersenter = new IPersenterImpl(this);
        initData();
    }

    protected abstract void initData();


    protected abstract void initView(View view);


    protected abstract int getViewById();

    protected abstract void successed(Object data);
    protected abstract void failed(String error);

    //GET
    public void startRequestDataGet(String url,Class clazz){
     if(!NetWorkUtils.getInstance().hasNetwork(getActivity())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(getActivity());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(getActivity(), "加载中.....");
            }
            iPersenter.startRequestGet(url, clazz);
        }
    }


    //DELETE
    public void startRequestDataDelete(String url,Class clazz){
        if(!NetWorkUtils.getInstance().hasNetwork(getActivity())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(getActivity());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(getActivity(), "加载中.....");
            }
            iPersenter.startRequestDelete(url, clazz);
        }
    }


    //POST
    public void startRequestDataPost(String url, Map<String,String> map, Class clazz){
        if(!NetWorkUtils.getInstance().hasNetwork(getActivity())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(getActivity());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(getActivity(), "加载中.....");
            }
            iPersenter.startRequestPost(url,map,clazz);
        }
    }


    //PUT
    public void startRequestDataPut(String url, Map<String,String> map, Class clazz){
        if(!NetWorkUtils.getInstance().hasNetwork(getActivity())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(getActivity());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(getActivity(), "加载中.....");
            }
            iPersenter.startRequestPut(url,map,clazz);
        }
    }


    //FILE
    public void startRequestFile(String url,Map<String,String> map,Class clazz){
        if(!NetWorkUtils.getInstance().hasNetwork(getActivity())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(getActivity());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(getActivity(), "加载中.....");
            }
            iPersenter.startRequestFile(url,map,clazz);
        }
    }


    //MOREFILE
    public void startRequestMoreFile(String url, Map<String,Object> map, Class clazz){
        if(!NetWorkUtils.getInstance().hasNetwork(GetContent.getContent())){
            ToastUtils.toast("当前网络不可用");
            NetWorkUtils.getInstance().setNetworkMethod(GetContent.getContent());
            return;
        } else {
            if (loadingDialog == null) {
                loadingDialog = LoadingUtils.createLoadingDialog(GetContent.getContent(), "加载中.....");
            }
            iPersenter.startRequestMoreFile(url,map,clazz);
        }
    }

    @Override
    public void getData(Object data) {
        successed(data);
        LoadingUtils.closeDialog(loadingDialog);
    }

    @Override
    public void getError(String error) {
        failed(error);
        LoadingUtils.closeDialog(loadingDialog);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPersenter.detach();
    }
}
