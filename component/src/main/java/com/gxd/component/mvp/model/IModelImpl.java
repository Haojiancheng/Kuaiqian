package com.gxd.component.mvp.model;


import com.google.gson.Gson;
import com.gxd.component.mvp.callback.ICallBack;
import com.gxd.component.retrofit.RetrofitUtils;

import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void requestDataGet(String url, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().get(url, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestDataDelete(String url, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().delete(url, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestDataPost(String url, Map<String, String> map, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().post(url, map, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestDataPut(String url, Map<String, String> map, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().put(url, map, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestDataFile(String url, Map<String, String> map, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().postFile(url, map, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imagePost(String url, Map<String, Object> map, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().postFileMore(url, map,new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    iCallBack.getError(error);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestPostImage(String url, Map<String, String> params, List<File> list, final Class clazz , final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().postMoreImage(url, params, list, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    iCallBack.getError(error);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }





    /*@Override
    public void imagePost(String url, Map<String, Object> map, Class clazz, MyCallBack myCallBack,Context context) {
        if(!NetworkUtils.isConnected()){
            myCallBack.onFail(NET_WORK);
        }else {
            RetrofitManager.getInstance().postFileMore(url, map, getSP(context), new RetrofitManager.HttpListener() {
                @Override
                public void onSuccess(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }
                }

                @Override
                public void onFail(String error) {
                    myCallBack.onFail(error);
                }
            });
        }
    }*/

   /* @Override
    public void requestDataMoreFile(String url, Map<String, String> map, List<File> list, final Class clazz, final ICallBack iCallBack) {
        try {
            RetrofitUtils.getInstance().postMoreFile(url, map, list, new RetrofitUtils.HttpCallBack() {
                @Override
                public void getData(String data) {
                    Object o = new Gson().fromJson(data, clazz);
                    if(iCallBack != null){
                        iCallBack.getData(o);
                    }
                }

                @Override
                public void getError(String error) {
                    if(iCallBack != null){
                        iCallBack.getError(error);
                    }
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }*/
}
