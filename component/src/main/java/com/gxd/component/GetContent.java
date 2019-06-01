package com.gxd.component;

import android.content.Context;

/**
 * @author 郭佳兴
 * date:  2019.5.26
 */
public class GetContent {

    private static Context context;

    public static void getContent(Context appcontext){
        context = appcontext;
    }

    public static Context getContent(){
        return context;
    }
}
