package com.whmnrc.qiangbizhong;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.LogUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.permissions.RxPermissions;
import com.pgyersdk.update.DownloadFileListener;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;
import com.pgyersdk.update.javabean.AppBean;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.home.HomeFragment;
import com.whmnrc.qiangbizhong.ui.me.MineFragment;
import com.whmnrc.qiangbizhong.ui.shop.ShopFragment;
import com.whmnrc.qiangbizhong.ui.shopping.ShopCarFragment;
import com.whmnrc.qiangbizhong.ui.yimei.YiMeiFragment;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_yimei)
    TextView tvYimei;
    @BindView(R.id.tv_shopping)
    TextView tvShopping;
    @BindView(R.id.tv_shopping_car)
    TextView tvShoppingCar;
    @BindView(R.id.tv_mine)
    TextView tvMine;

    private List<Fragment> fragments;
    private static final int HOME = 0;
    private static final int YIMEI = 1;
    private static final int SHOP = 2;
    private static final int SHOPCAR = 3;
    private static final int ME = 4;

    private Fragment showFragment;
    private static int shopIndex = HOME;
    private ImmersionBar mImmersionBar;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    public static void start(Context context,int type) {
        Intent starter = new Intent(context, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if (type == 1) {
            shopIndex = SHOPCAR;
        }else if (type == 2){
            shopIndex = ME;
        }
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setData() {
        mImmersionBar = ImmersionBar.with(this)
                .transparentStatusBar();
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(YiMeiFragment.newInstance());
        fragments.add(ShopFragment.newInstance());
        fragments.add(ShopCarFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        FragmentUtils.add(getSupportFragmentManager(),fragments,R.id.fl_content,shopIndex);
        showFragment = fragments.get(shopIndex);
        switchBtn(shopIndex);
        bugongyin();
    }



    private void switchFragment(int index){
        if (index != shopIndex) {
            FragmentUtils.showHide(fragments.get(index), showFragment);
            switchBtn(index);
            showFragment = fragments.get(index);
            shopIndex = index;
        }
    }

    private void switchBtn(int index){
        tvHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvShopping.setSelected(false);
        tvShopping.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvShoppingCar.setSelected(false);
        tvShoppingCar.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvYimei.setSelected(false);
        tvYimei.setTextColor(getResources().getColor(R.color.tv_navigation));
        switch (index){
            case HOME:
                tvHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case YIMEI:
                tvYimei.setSelected(true);
                tvYimei.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case SHOP:
                tvShopping.setSelected(true);
                tvShopping.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case SHOPCAR:
                tvShoppingCar.setSelected(true);
                tvShoppingCar.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case ME:
                tvMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
        }
    }


    @OnClick({R.id.tv_home, R.id.tv_yimei, R.id.tv_shopping, R.id.tv_shopping_car, R.id.tv_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                switchFragment(HOME);
                break;
            case R.id.tv_yimei:
                switchFragment(YIMEI);
                break;
            case R.id.tv_shopping:
                switchFragment(SHOP);
                break;
            case R.id.tv_shopping_car:
                if (UserManage.getInstance().getLoginBean() != null) {
                    switchFragment(SHOPCAR);
                }else {
                    LoginActivity.start(this);
                }
                break;
            case R.id.tv_mine:
                switchFragment(ME);
//                if (UserManage.getInstance().getLoginBean() != null){
//                    switchFragment(ME);
//                }else {
//                    LoginActivity.start(this);
//                }

                break;
        }
    }

    private void bugongyin(){
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted ->{
                    /** 新版本 **/
                    new PgyUpdateManager.Builder()
                            .setForced(true)                //设置是否强制更新,非自定义回调更新接口此方法有用
                            .setUserCanRetry(false)         //失败后是否提示重新下载，非自定义下载 apk 回调此方法有用
                            .setDeleteHistroyApk(false)     // 检查更新前是否删除本地历史 Apk， 默认为true
                            .setUpdateManagerListener(new UpdateManagerListener() {
                                @Override
                                public void onNoUpdateAvailable() {
                                    //没有更新是回调此方法
                                    LogUtils.d("pgyer", "there is no new version");
                                }
                                @Override
                                public void onUpdateAvailable(AppBean appBean) {
                                    //有更新回调此方法
                                    Uri uri = Uri.parse("https://www.pgyer.com/s8cD");
                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                    startActivity(intent);
                                }

                                @Override
                                public void checkUpdateFailed(Exception e) {
                                    //更新检测失败回调

                                }
                            })
                            .setDownloadFileListener(new DownloadFileListener() {
                                @Override
                                public void downloadFailed() {
                                    //下载失败
                                }

                                @Override
                                public void downloadSuccessful(Uri uri) {
                                    // 使用蒲公英提供的安装方法提示用户 安装apk

                                }

                                @Override
                                public void onProgressUpdate(Integer... integers) {

                                }})
                            .register();
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null){
            mImmersionBar.destroy();
        }
    }
}
