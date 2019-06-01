package com.gxd.component.mvp.callback;

public interface ICallBack<T> {
    void getData(T data);
    void getError(String error);
}
