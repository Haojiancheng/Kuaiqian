package com.gxd.component.mvp.persenter;
import com.gxd.component.base.fragment.BaseNetworkFragment;
import com.gxd.component.mvp.callback.ICallBack;
import com.gxd.component.mvp.model.IModelImpl;
import com.gxd.component.mvp.view.IView;

import java.io.File;
import java.util.List;
import java.util.Map;

public class IPersenterImpl implements IPersenter {

    private IView iView;
    private IModelImpl iModel;

    public IPersenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void startRequestGet(String url, Class clazz) {
        iModel.requestDataGet(url, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void startRequestDelete(String url, Class clazz) {
        iModel.requestDataDelete(url, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void startRequestPost(String url, Map<String, String> map, Class clazz) {
        iModel.requestDataPost(url, map, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void startRequestPut(String url, Map<String, String> map, Class clazz) {
        iModel.requestDataPut(url, map, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void startRequestFile(String url, Map<String, String> map, Class clazz) {
        iModel.requestDataFile(url, map, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void startRequestMoreFile(String url, Map<String, Object> map, Class clazz) {
        iModel.imagePost(url, map, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    @Override
    public void requestPostImage(String url, Map<String, String> params, List<File> list, Class clazz) {
        iModel.requestPostImage(url, params, list, clazz, new ICallBack() {
            @Override
            public void getData(Object data) {
                iView.getData(data);
            }

            @Override
            public void getError(String error) {
                iView.getError(error);
            }
        });
    }

    public void detach(){
        if(iView != null){
            iView = null;
        }
        if(iModel != null){
            iModel = null;
        }
    }
}
