package com.gxd.component.mvp.persenter;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IPersenter {
    void startRequestGet(String url, Class clazz);
    void startRequestDelete(String url, Class clazz);
    void startRequestPost(String url, Map<String, String> map, Class clazz);
    void startRequestPut(String url, Map<String, String> map, Class clazz);
    void startRequestFile(String url, Map<String, String> map, Class clazz);
    void startRequestMoreFile(String url, Map<String, Object> map, Class clazz);
    void requestPostImage(String url, Map<String, String> params, List<File> list, Class clazz);
}
