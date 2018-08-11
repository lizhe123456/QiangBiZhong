package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiIndexBean;
import com.whmnrc.qiangbizhong.presenter.yimei.YiMeiPresenter;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.CommentAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 医美详情
 */

public class YiMeiGoodsDetailsActivity extends BaseActivity implements YiMeiPresenter.MedicaldetailCall {


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
    @BindView(R.id.tv_price_title)
    TextView tvPriceTitle;
    @BindView(R.id.tv_now_moeny)
    TextView tvNowMoeny;
    @BindView(R.id.ll_now_moeny)
    LinearLayout llNowMoeny;
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
        yiMeiPresenter.getmedicaldetail(goodsId, this);

        commentAdapter = new CommentAdapter(this);
        rvCommentList.setAdapter(commentAdapter);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));

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
    }

    @Override
    public void error() {

    }

    public void initBanner(List<YiMeiIndexBean.BannerBean> banners){
        List<String> list = new ArrayList<>();
        for (YiMeiIndexBean.BannerBean bannerBean :banners) {
            list.add(bannerBean.getBanner_Url());
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
        initBanner(yiMeiGoodsDetailBean.getBanner());
        tvName.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Name());
        tvTitle.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Describe());
        tvLoction.setText(yiMeiGoodsDetailBean.getStoreInfo().getAddress());
        tvOldPrice.setText("原价：" + yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_VirtualPrice() + "");
        tvPrice.setText(yiMeiGoodsDetailBean.getGoods().getGoods_PriceMin() + "-" + yiMeiGoodsDetailBean.getGoods().getGoods_PriceMax());

        GlideuUtil.loadImageView(this, yiMeiGoodsDetailBean.getStoreInfo().getStoreHeadImage(), ivImg);
        tvAddress.setText(yiMeiGoodsDetailBean.getStoreInfo().getAddress());
        tvName.setText(yiMeiGoodsDetailBean.getStoreInfo().getStoreName());
        commentAdapter.addFirstDataSet(yiMeiGoodsDetailBean.getEvaluate());
        tvCommentCount.setText("看看大家怎么说（" + yiMeiGoodsDetailBean.getEvaluateCount() + "）");


        tvNowMoeny.setText(String.valueOf(yiMeiGoodsDetailBean.getGoods().getGoods_PriceMin()));

        if (yiMeiGoodsDetailBean.getGoodsIsCollection() == 1){
            isColl = true;
            icColl.setImageResource(R.drawable.ic_collection_bottom);
        }else {
            isColl = false;
            icColl.setImageResource(R.drawable.ic_collection_bott);
        }

        if (yiMeiGoodsDetailBean.getStoreIsCollection() == 1){
            tvCollection.setSelected(true);
            tvCollection.setText("已收藏");
        }else {
            tvCollection.setSelected(false);
            tvCollection.setText("收藏");
        }

    }


    @OnClick({R.id.rl_sort})
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.rl_sort:
                YiMeiDetailsActivity.start(this,yiMeiGoodsDetailBean.getStoreInfo().getId());
                break;
        }
    }
}
