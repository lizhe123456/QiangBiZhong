package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiIndexBean;
import com.whmnrc.qiangbizhong.pay.wechat.share.WechatShareModel;
import com.whmnrc.qiangbizhong.pay.wechat.share.WechatShareTools;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.presenter.yimei.YiMeiPresenter;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.CommentAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ImageUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.util.WxShareUtils;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 医美详情
 */

public class YiMeiGoodsDetailsActivity extends BaseActivity implements YiMeiPresenter.MedicaldetailCall, CollectionPresenter.CollectionCall{


    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.iv_goods_img)
    Banner ivGoodsImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_zizhi)
    TextView tvZizhi;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.rv_comment_list)
    RecyclerView rvCommentList;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_loction)
    TextView tvLoction;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.iv_coll)
    ImageView icColl;

    private YiMeiPresenter yiMeiPresenter;
    private String goodsId;
    private CommentAdapter commentAdapter;

    private YiMeiGoodsDetailBean yiMeiGoodsDetailBean;
    private boolean isColl;
    private boolean isSColl;
    private CollectionPresenter collectionPresenter;

    public static void start(Context context, String goodsId) {
        Intent starter = new Intent(context, YiMeiGoodsDetailsActivity.class);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_yimei_goods_details;
    }

    @Override
    protected void setData() {
        yiMeiPresenter = new YiMeiPresenter(this);
        goodsId = getIntent().getStringExtra("goodsId");
        showLoading("加载中..");
        yiMeiPresenter.getmedicaldetail(goodsId, this);

        commentAdapter = new CommentAdapter(this);
        rvCommentList.setAdapter(commentAdapter);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));
        collectionPresenter = new CollectionPresenter(this);

        //设置banner样式
        ivGoodsImg.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        ivGoodsImg.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        ivGoodsImg.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        ivGoodsImg.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        ivGoodsImg.isAutoPlay(true);
        //设置轮播时间
        ivGoodsImg.setDelayTime(1500);

        WechatShareTools.init(this,"wx536e1d5b8c490446");
//        WechatShareTools.init(this,"wxdac79b5de8e5d7e2");


    }

    @Override
    public void error() {

    }

    public void initBanner(List<YiMeiGoodsDetailBean.BannerBean> banners){
        List<String> list = new ArrayList<>();
        for (YiMeiGoodsDetailBean.BannerBean bannerBean :banners) {
            list.add(bannerBean.getImg_Path());
        }
        ivGoodsImg.setImages(list);
        ivGoodsImg.start();
    }

    @Override
    public void medicaldetai(YiMeiGoodsDetailBean yiMeiGoodsDetailBean) {
        this.yiMeiGoodsDetailBean = yiMeiGoodsDetailBean;
        //初始化数据
        medicalData(yiMeiGoodsDetailBean);
    }

    private void medicalData(YiMeiGoodsDetailBean yiMeiGoodsDetailBean) {
        this.yiMeiGoodsDetailBean = yiMeiGoodsDetailBean;
        if (yiMeiGoodsDetailBean != null) {
            initBanner(yiMeiGoodsDetailBean.getBanner());
        }
        tvYuyue.setText("销量  "+yiMeiGoodsDetailBean.getGoods().getGoods_MonthCount());
        tvName.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Name());
//        tvTitle.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Describe());
        tvTitle.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Name());
        tvZizhi.setText("资质：" + yiMeiGoodsDetailBean.getStoreInfo().getExplain());
        tvLoction.setText("地址：" +yiMeiGoodsDetailBean.getStoreInfo().getAddress());
        tvOldPrice.setText("原价：" + yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_VirtualPrice() + "");
        //抗锯齿
        tvOldPrice.getPaint().setAntiAlias(true);
        //中划线
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvPrice.setText(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price()+"");
//        tvNowMoeny.setText(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price()+"");

        GlideuUtil.loadImageView(this, yiMeiGoodsDetailBean.getStoreInfo().getStoreHeadImage(), ivImg);
        tvAddress.setText("地址："+yiMeiGoodsDetailBean.getStoreInfo().getAddress());
        tvName.setText(yiMeiGoodsDetailBean.getStoreInfo().getStoreName());
        commentAdapter.addFirstDataSet(yiMeiGoodsDetailBean.getEvaluate());
        tvCommentCount.setText("看看大家怎么说（" + yiMeiGoodsDetailBean.getEvaluateCount() + "）");


        if (yiMeiGoodsDetailBean.getGoodsIsCollection() == 1){
            isColl = true;
            icColl.setImageResource(R.drawable.ic_collection_bottom);
        }else {
            isColl = false;
            icColl.setImageResource(R.drawable.ic_collection_bott);
        }

        if (yiMeiGoodsDetailBean.getStoreIsCollection() == 1){
            tvCollection.setSelected(false);
            isSColl = true;
            tvCollection.setText("已收藏");
            tvCollection.setCompoundDrawables(null,null,null,null);
        }else {
            tvCollection.setSelected(true);
            isSColl = false;
            tvCollection.setText("收藏");
            Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(nav_up,null,null,null);
        }

    }


    @OnClick({R.id.rl_sort,R.id.tv_collection,R.id.iv_coll,R.id.tv_buy,R.id.iv_back,R.id.tv_comment_count,R.id.iv_customer_service,R.id.iv_shape})
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.rl_sort:
                YiMeiDetailsActivity.start(this,yiMeiGoodsDetailBean.getStoreInfo().getId());
                break;
            case R.id.tv_collection:
                if (isSColl){
                    tvCollection.setSelected(true);
                    isSColl = false;
                    tvCollection.setText("收藏");
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvCollection.setCompoundDrawables(nav_up,null,null,null);
                    collectionPresenter.cannercollection(1,yiMeiGoodsDetailBean.getStoreInfo().getId(),this);
                }else {
                    tvCollection.setSelected(false);
                    isSColl = true;
                    tvCollection.setText("已收藏");
                    tvCollection.setCompoundDrawables(null,null,null,null);
                    collectionPresenter.addcollection(3,yiMeiGoodsDetailBean.getStoreInfo().getId(),1,this);
                }
                break;
            case R.id.iv_coll:
                if (isColl){
                    isColl = false;
                    icColl.setImageResource(R.drawable.ic_collection_bott);
                    collectionPresenter.cannercollection(0,yiMeiGoodsDetailBean.getGoods().getGoods_ID(),this);
                }else {
                    isColl = true;
                    icColl.setImageResource(R.drawable.ic_collection_bottom);
                    collectionPresenter.addcollection(3,yiMeiGoodsDetailBean.getGoods().getGoods_ID(),0,this);
                }
                break;
            case R.id.tv_buy:
                ConfirmOrderActivity.start(this,yiMeiGoodsDetailBean);
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_comment_count:
                CommentListActivity.start(this,goodsId);
                break;
            case R.id.iv_customer_service:
                CustomerServiceDialog.showDialog(this);
                break;
            case R.id.iv_shape:
                Glide.with(this).asBitmap().load(yiMeiGoodsDetailBean.getGoods().getGoods_ImaPath()).into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        WxShareUtils.getInstance(YiMeiGoodsDetailsActivity.this).shareUrl(Constants.INFO_ADDRESS + "/Invitation/Shared?UserId=+"+ UserManage.getInstance().getUserID()+"&goodsId="+yiMeiGoodsDetailBean.getGoods().getGoods_ID()
                                ,yiMeiGoodsDetailBean.getGoods().getGoods_Name(),resource,yiMeiGoodsDetailBean.getGoods().getGoods_Describe(), SendMessageToWX.Req.WXSceneSession);
                    }
                });
                break;
        }
    }

    private byte[] bmpToByteArray(final Bitmap bitmap) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
        int options = 100;
        while (output.toByteArray().length > 32 && options != 10) {
            //清空output
            output.reset();
            //这里压缩options%，把压缩后的数据存放到output中
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, output);
            options -= 10;
        }
        return output.toByteArray();
    }


    @Override
    public void cS() {

    }
}
