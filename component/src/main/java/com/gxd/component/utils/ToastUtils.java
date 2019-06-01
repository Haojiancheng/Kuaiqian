package com.gxd.component.utils;

import android.widget.Toast;

import com.gxd.component.GetContent;

/**
 * date : 5.26
* 吐司
* */
public class ToastUtils {
    private static Toast toast;//在类前面声明吐司，确保在这个页面只有一个吐司
    public static void toast(String message){
        if (toast == null) {
            toast = Toast.makeText(GetContent.getContent(), message, Toast.LENGTH_SHORT);
        } else {
            toast.cancel();//关闭吐司显示
            toast = Toast.makeText(GetContent.getContent(), message, Toast.LENGTH_SHORT);
        }

        toast.show();//重新显示吐司
    }
}
