package com.gxd.component.mvp.view;

public interface IView<T> {
    void getData(T data);
    void getError(String error);
}
