package com.gxd.component.mvp.model;
import com.gxd.component.mvp.callback.ICallBack;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IModel {
    void requestDataGet(String url, Class clazz, ICallBack iCallBack);
    void requestDataDelete(String url, Class clazz, ICallBack iCallBack);
    void requestDataPost(String url, Map<String, String> map, Class clazz, ICallBack iCallBack);
    void requestDataPut(String url, Map<String, String> map, Class clazz, ICallBack iCallBack);
    void requestDataFile(String url, Map<String, String> map, Class clazz, ICallBack iCallBack);
    void imagePost(String url, Map<String, Object> map, Class clazz, ICallBack iCallBack);
    void requestPostImage(String url, Map<String, String> params, List<File> list, Class clazz, ICallBack callBack);
}
