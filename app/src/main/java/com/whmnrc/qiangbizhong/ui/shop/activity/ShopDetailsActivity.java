package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.whmnrc.qiangbizhong.MainActivity;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.ShopDetailsBean;
import com.whmnrc.qiangbizhong.model.bean.SpecBean;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.ShopPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.SpecPresenter;
import com.whmnrc.qiangbizhong.presenter.shopcar.ShopCarPresenter;
import com.whmnrc.qiangbizhong.ui.shop.bean.OrderBeanReq;
import com.whmnrc.qiangbizhong.ui.shop.fragment.GoodsDetailsFragment;
import com.whmnrc.qiangbizhong.ui.yimei.activity.CommentListActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.CommentAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.util.WxShareUtils;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import com.whmnrc.qiangbizhong.widget.SelectParamPopupWindow;
import com.whmnrc.qiangbizhong.widget.WrapContentHeightViewPager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class ShopDetailsActivity extends BaseActivity implements ShopPresenter.ShopDetailCall,
        CollectionPresenter.CollectionCall,SpecPresenter.GoodsSpecCall,ShopCarPresenter.CarStatuCall{

    @BindView(R.id.iv_shop_car)
    ImageView ivShopCar;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_now_moeny1)
    LinearLayout llNowMoeny1;
    @BindView(R.id.tv_sales_volume)
    TextView tvSalesVolume;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.tv_no_comment)
    TextView tvNoComment;
    @BindView(R.id.rv_comment_list)
    RecyclerView rvCommentList;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_shop_desc)
    TextView tvShopDesc;
    @BindView(R.id.rl_sort)
    RelativeLayout rlSort;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    WrapContentHeightViewPager vpContent;
    @BindView(R.id.iv_coll)
    ImageView ivColl;
    @BindView(R.id.tv_cat_more)
    TextView tvCatMore;
    @BindView(R.id.ll_zo_co)
    RelativeLayout llCatMore;
    @BindView(R.id.bannerView)
    Banner bannerView;


    private ShopPresenter mShopPresenter;
    private ShopCarPresenter mShopCarPresenter;
    private SpecPresenter mSpecPresenter;
    private CollectionPresenter mCollectionPresenter;
    private SparseArray<Fragment> fragments;
    private SparseArray<String> strings;
    private ShopDetailsBean mShopBean;
    private CommentAdapter mCommentAdapter;

    private boolean isColl;

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, ShopDetailsActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_shop_details;
    }

    @Override
    protected void setData() {
        String goodsId = getIntent().getStringExtra("goodsId");
        mShopPresenter = new ShopPresenter(this);
        mCollectionPresenter = new CollectionPresenter(this);
        mShopCarPresenter = new ShopCarPresenter(this);
        mSpecPresenter = new SpecPresenter(this);
        showLoading("加载中..");
        mShopPresenter.getGoodsDetail(goodsId,this);
        strings = new SparseArray<>();
        fragments = new SparseArray<>();
        strings.append(0, "商品详情");
        strings.append(1, "商品参数");
        tvCollection.setSelected(true);
        mCommentAdapter = new CommentAdapter(this);
        rvCommentList.setAdapter(mCommentAdapter);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bannerView.getLayoutParams();

        bannerView.setLayoutParams(layoutParams);

        //设置banner样式
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        bannerView.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        bannerView.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        bannerView.isAutoPlay(true);
        //设置轮播时间
        bannerView.setDelayTime(1500);
    }


    @OnClick({R.id.iv_shop_car, R.id.iv_back, R.id.iv_coll, R.id.iv_customer_service, R.id.tv_shop_car, R.id.tv_buy,R.id.rl_sort,R.id.tv_cat_more,R.id.iv_shape})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_shop_car:
                MainActivity.start(this,1);
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_coll:
                if (mShopBean != null)
                    if (isColl) {
                        //取消收藏
                        mCollectionPresenter.cannercollection( 0, mShopBean.getGoods().getGoods_ID(),this);
                    }else {
                        //收藏
                        mCollectionPresenter.addcollection(0,mShopBean.getGoods().getGoods_ID(), 0, this);
                    }
                break;
            case R.id.iv_customer_service:
                CustomerServiceDialog.showDialog(this);
                break;
            case R.id.tv_shop_car:
            case R.id.tv_buy:
                //跳转确认订单
                if (mShopBean != null)
                    showLoading("加载中..");
                    mSpecPresenter.getgoodsspecattr(mShopBean.getGoods().getGoods_ID(),this);
                break;
            case R.id.rl_sort:
                //跳转店铺详情
                ShopsListActivity.start(this,mShopBean.getStoreInfo().getId());
                break;
            case R.id.tv_cat_more:
                CommentListActivity.start(this,mShopBean.getGoods().getGoods_ID());
                break;
            case R.id.iv_shape:
                Glide.with(this).asBitmap().load(mShopBean.getGoods().getGoods_ImaPath()).into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        WxShareUtils.getInstance(ShopDetailsActivity.this).shareUrl(Constants.INFO_ADDRESS + "/Invitation/Shared?UserId=+"+ UserManage.getInstance().getUserID()+"&goodsId="+mShopBean.getGoods().getGoods_ID()
                                ,mShopBean.getGoods().getGoods_Name(),resource,mShopBean.getGoods().getGoods_Describe(), SendMessageToWX.Req.WXSceneSession);
                    }
                });
                break;
        }
    }

    private void showSpec(SpecBean specBean) {
        SelectParamPopupWindow selectParamPopupWindow = new SelectParamPopupWindow(this,specBean,1);
        selectParamPopupWindow.showPop(getCurrentFocus(),this);
        selectParamPopupWindow.setOnCancelListener(new SelectParamPopupWindow.OnCancelListener() {
            @Override
            public void onCancel() {

            }

            @Override
            public void onBuy(OrderBeanReq orderBeanReq) {
                ShopConfirmOrderActivity.start(ShopDetailsActivity.this,orderBeanReq, mShopBean.getStoreInfo());
            }


            @Override
            public void onAddCar(String goodsId, String priceId,int count) {
                showLoading("加入中..");
                mShopCarPresenter.addcar(goodsId,priceId,count,ShopDetailsActivity.this);
            }
        });
    }

    @Override
    public void error() {

    }

    private boolean isFirst;

    @Override
    public void shopDetails(@NonNull ShopDetailsBean shopBean) {
        this.mShopBean = shopBean;
        addData(shopBean);
        if (!isFirst) {
            isFirst = true;
            List<String> list = new ArrayList<>();
            for (ShopDetailsBean.BannerBean bannerBean : shopBean.getBanner()) {
                list.add(bannerBean.getImg_Path());
            }
            bannerView.setImages(list);
            bannerView.start();
        }
    }

    private void addData(ShopDetailsBean shopBean) {
//        GlideuUtil.loadImageView(this,shopBean.getGoods().getGoods_ImaPath(),ivGoodsImg);

        GlideuUtil.loadImageView(this,shopBean.getStoreInfo().getStoreHeadImage(),ivImg);
        tvName.setText(shopBean.getStoreInfo().getStoreName());
        tvShopDesc.setText(shopBean.getStoreInfo().getExplain());

        tvTitle.setText(shopBean.getGoods().getGoods_Name());
        if (shopBean.getGoods().getGoods_PriceMin() == shopBean.getGoods().getGoods_PriceMax()) {
            tvPrice.setText(shopBean.getGoods().getGoods_PriceMin() + "");
        }else {
            tvPrice.setText(shopBean.getGoods().getGoods_PriceMin() + "~" + shopBean.getGoods().getGoods_PriceMax());
        }
//        tvPrice.setText(shopBean.getGoods().getGoods_PriceMin() + "~" + shopBean.getGoods().getGoods_PriceMax());
        tvOldPrice.setText("原价："+shopBean.getGoods().getGoods_PriceMax()+"");
        tvOldPrice.getPaint().setAntiAlias(true);//抗锯齿
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        tvSalesVolume.setText("销量  "+shopBean.getGoods().getGoods_MonthCount()+"");
        if (shopBean.getEvaluate().size() == 0){
            tvNoComment.setVisibility(View.VISIBLE);
            llCatMore.setVisibility(View.GONE);
        }else {
            llCatMore.setVisibility(View.VISIBLE);
            tvNoComment.setVisibility(View.GONE);
            tvCatMore.setText("查看更多共"+shopBean.getEvaluateCount()+"条");
            mCommentAdapter.addFirstDataSet(shopBean.getEvaluate());
        }
        fragments.append(0, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + shopBean.getGoods().getGoods_ID() + "&showType=0"));
        fragments.append(1, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + shopBean.getGoods().getGoods_ID() + "&showType=1"));
        ViewPagerUtil.initViewPage(vpContent, tabLayout, this, fragments, strings, 100, 0);

        if (shopBean.getGoodsIsCollection() == 1){
            isColl = true;
            ivColl.setImageResource(R.drawable.ic_collection_bottom);
        }else {
            isColl = false;
            ivColl.setImageResource(R.drawable.ic_collection_bott);
        }

    }

    @Override
    public void cS() {
        if (isColl){
            isColl = false;
            ivColl.setImageResource(R.drawable.ic_collection_bott);
        }else {
            isColl = true;
            ivColl.setImageResource(R.drawable.ic_collection_bottom);
        }
    }

    @Override
    public void spceBack(SpecBean specBean) {
        showSpec(specBean);
    }

    @Override
    public void csS() {

    }

    @Override
    public void updateS() {

    }

    @Override
    public void jj() {

    }

    @Override
    public void deleteCar() {

    }
}
