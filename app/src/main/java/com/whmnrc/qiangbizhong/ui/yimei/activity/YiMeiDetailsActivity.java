package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.permissions.RxPermissions;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiSortBean;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.presenter.yimei.StorePresenter;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.ComprehensiveFragment;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.PriceFragment;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.SalesVolumeFragment;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商铺详情
 */

public class YiMeiDetailsActivity extends BaseActivity implements StorePresenter.MedicalStoreCall, CollectionPresenter.CollectionCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_yimei_name)
    TextView tvYimeiName;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    private StorePresenter storePresenter;
    private CollectionPresenter collectionPresenter;

    public double latitude;
    public double longitude;

    private AMapLocationClient mapLocationClient = null;
    private boolean isFrist;
    private String sId;
    private boolean isColl;

    AMapLocationListener mAMapLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {

            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                    latitude = amapLocation.getLatitude();
                    longitude = amapLocation.getLongitude();
                    if (!isFrist) {
                        storePresenter.getmedicalstorelist(true,sId,"0",latitude,longitude,YiMeiDetailsActivity.this);
                        isFrist = true;
                    }
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    LogUtils.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                    if (!isFrist) {
//                        showEmpty();
                        isFrist = true;
                    }
                }
            }
        }
    };


    public static void start(Context context,String sortId) {
        Intent starter = new Intent(context, YiMeiDetailsActivity.class);
        starter.putExtra("sortId",sortId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_yimei_detail;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("医美详情");
        SparseArray<String> titles = new SparseArray<>();
        SparseArray<Fragment> fragments = new SparseArray<>();
        titles.append(0,"综合");
        titles.append(1,"销量");
        titles.append(2,"价格");
        sId = getIntent().getStringExtra("sortId");
        fragments.append(0, SalesVolumeFragment.newInstance(sId,"0"));
        fragments.append(1, SalesVolumeFragment.newInstance(sId,"1"));
        fragments.append(2, SalesVolumeFragment.newInstance(sId,"2"));

        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,titles,20,0);

        storePresenter = new StorePresenter(this);
        collectionPresenter = new CollectionPresenter(this);
        initLocation();
    }

    private void initLocation() {
        mapLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setInterval(10000);
        option.setHttpTimeOut(20000);
        //给定位客户端对象设置定位参数
        mapLocationClient.setLocationOption(option);
        mapLocationClient.setLocationListener(mAMapLocationListener);
        //启动定位
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        mapLocationClient.startLocation();
                    } else {
                        ToastUtils.showShort("未开启定位功能");
                    }
                });
    }


    @OnClick({R.id.iv_back,R.id.tv_collection})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_collection:
                if (isColl){
                    collectionPresenter.cannercollection(1,sId,this);
                }else {
                    collectionPresenter.addcollection(3,sId,1,this);
                }
                break;
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void medicalStoreBack(YiMeiSortBean yiMeiSortBean) {
        tvYimeiName.setText(yiMeiSortBean.getStoreInfo().getStoreName());
        tvAddress.setText("地址："+yiMeiSortBean.getStoreInfo().getAddress());
        GlideuUtil.loadImageView(this,yiMeiSortBean.getStoreInfo().getStoreHeadImage(),ivImg);
        if (yiMeiSortBean.getStoreIsCollection() == 1){
            tvCollection.setSelected(false);
            isColl = true;
            tvCollection.setText("已收藏");
            tvCollection.setCompoundDrawables(null,null,null,null);
        }else {
            tvCollection.setSelected(true);
            isColl = false;
            tvCollection.setText("收藏");
            Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(nav_up,null,null,null);
        }
    }

    @Override
    public void loadMore(List<YiMeiGoodsBean> goodsBeans) {

    }


    @Override
    public void cS() {
        if (isColl){
            tvCollection.setSelected(true);
            isColl = false;
            tvCollection.setText("收藏");
            Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(nav_up,null,null,null);
        }else {
            tvCollection.setSelected(false);
            isColl = true;
            tvCollection.setText("已收藏");
            tvCollection.setCompoundDrawables(null,null,null,null);
        }
    }
}
