package com.gxd.module_home;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gxd.component.base.activity.BaseActivity;
import com.gxd.component.base.activity.BaseNetworkActivity;
import com.gxd.module_home.fragment.HomeFragment;

@Route(path = "/module_home/ShowActivity")
public class ShowActivity extends BaseActivity {
    private RadioGroup mHomeRadioGroupChange;
    private FragmentManager fragmentManager;
    private Fragment mHomeFragment;
    private Fragment mMineFragment;
    private Fragment mRepaymentFragment;
    private Fragment mAuthenticationFragment;

    @Override
    public int intiLayout() {
        return R.layout.activity_show;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mHomeRadioGroupChange = (RadioGroup) findViewById(R.id.home_radioGroup_change);
    }

    @Override
    public void initData() {
        //  initQuan();
        fragmentManager = getSupportFragmentManager();
        //将所有Fragment添加到占位布局
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mHomeFragment = (Fragment) ARouter.getInstance().build("/module_home/HomeFragment").navigation();
        fragmentTransaction
                .replace(R.id.frameLayout, mHomeFragment)
                .commit();

        mHomeRadioGroupChange.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                hidefragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (checkedId == R.id.radioButton_home) {
                    if (mHomeFragment==null) {
                        mHomeFragment=new HomeFragment();
                    }
                    fragmentTransaction.show(mHomeFragment).commit();
                } else if (checkedId == R.id.radioButton_authentication) {
                    if (mAuthenticationFragment == null) {
                        Object navigation = ARouter.getInstance().build("/module_authentication/AuthenticationFragment").navigation();
                        mAuthenticationFragment = (Fragment) ARouter.getInstance().build("/module_authentication/AuthenticationFragment").navigation();
                        fragmentTransaction.add(R.id.frameLayout, mAuthenticationFragment).commit();
                    } else {
                        fragmentTransaction.show(mAuthenticationFragment).commit();
                    }
                } else if (checkedId == R.id.radioButton_repayment) {
                    if (mRepaymentFragment == null) {
                        mRepaymentFragment = (Fragment) ARouter.getInstance().build("/module_repayment/RepaymentFragment").navigation();
                        fragmentTransaction.add(R.id.frameLayout, mRepaymentFragment).commit();
                    } else {
                        fragmentTransaction.show(mRepaymentFragment).commit();
                    }

                } else if (checkedId == R.id.radioButton_mine) {
                    if (mMineFragment == null) {
                        mMineFragment = (Fragment) ARouter.getInstance().build("/module_mine/MineFragment").navigation();
                        fragmentTransaction.add(R.id.frameLayout, mMineFragment).commit();
                    } else {
                        fragmentTransaction.show(mMineFragment).commit();
                    }
                }
            }
        });
    }

    //权限
    private void initQuan() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] mStatenetwork = new String[]{
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    Manifest.permission.BLUETOOTH,
                    Manifest.permission.BLUETOOTH_ADMIN,
                    Manifest.permission.CAMERA,
            };
            ActivityCompat.requestPermissions(this, mStatenetwork, 100);
        }
    }


    //隐藏Fragment
    private void hidefragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (mHomeFragment != null && mHomeFragment.isAdded()) {
            fragmentTransaction.hide(mHomeFragment);
        }
        if (mAuthenticationFragment != null && mAuthenticationFragment.isAdded()) {
            fragmentTransaction.hide(mAuthenticationFragment);
        }
        if (mRepaymentFragment != null && mRepaymentFragment.isAdded()) {
            fragmentTransaction.hide(mRepaymentFragment);
        }
        if (mMineFragment != null && mMineFragment.isAdded()) {
            fragmentTransaction.hide(mMineFragment);
        }
        fragmentTransaction.commit();
    }
}
