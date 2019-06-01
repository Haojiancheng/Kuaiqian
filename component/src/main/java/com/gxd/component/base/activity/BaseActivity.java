package com.gxd.component.base.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 整个Activity视图的根视图
     */
    View decorView;

    /**
     * 手指按下时的坐标
     */
    float downX, downY;

    /**
     * 手机屏幕的宽度和高度
     */
    float screenWidth, screenHeight;
    public boolean isNeedFCancle = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(intiLayout());
        //初始化控件
        initView(savedInstanceState);

        //拿到整个activity的视图
        decorView = getWindow().getDecorView();

        // 获得手机屏幕的宽度和高度，单位像素
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        //设置数据
        initData();
    }


    //设置布局
    public abstract int intiLayout();

    //初始化布局
    public abstract void initView(Bundle savedInstanceState);

    //设置数据
    public abstract void initData();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isNeedFCancle) {
            return super.onTouchEvent(event);
        } else {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //手指按下时的坐标
                downX = event.getX();

            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                float moveDistanceX = event.getX() - downX;
                if (moveDistanceX > 0) {
                    decorView.setX(moveDistanceX);
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                float moveDistanceX = event.getX() - downX;
                if (moveDistanceX > 0) {
                    if (moveDistanceX > screenWidth / 2) {
                        ContinueMove(moveDistanceX);
                    } else {
                        reToBackLeft(moveDistanceX);
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public void ContinueMove(float moveDistanceX) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(moveDistanceX, screenWidth);
        valueAnimator.setDuration(50);
        valueAnimator.start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float x = (float) animation.getAnimatedValue();
                decorView.setX(x);
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finish();
            }
        });

    }

    private void reToBackLeft(float moveDistanceX) {
        ObjectAnimator.ofFloat(decorView, "X", moveDistanceX, 0)
                .setDuration(50)
                .start();
    }


}
