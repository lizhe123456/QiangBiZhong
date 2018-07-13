package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.presenter.home.GoodsRushInfoPresenter;
import com.whmnrc.qiangbizhong.ui.shop.fragment.GoodsDetailsFragment;
import com.whmnrc.qiangbizhong.ui.shop.fragment.GoodsParamFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
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

public class FlashSaleDetailsActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    WrapContentHeightViewPager viewPager;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView imageView;
    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_old_moeny)
    TextView tvOldMoeny;
    @BindView(R.id.tv_scep)
    TextView tvScep;
    @BindView(R.id.tv_canyu_num)
    TextView tvCanYuNum;
    @BindView(R.id.tv_price)
    TextView tvYuPrice;
    @BindView(R.id.tv_yu_price)
    TextView tvZaiPrice;
    @BindView(R.id.tv_canyu)
    TextView tvCanYu;

    private SparseArray<Fragment> fragments;
    private SparseArray<String> strings;

    private String goodsId;
    private GoodsRushinfoBean goodsRushinfoBean;

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, FlashSaleDetailsActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_flash_sale_details;
    }

    @Override
    protected void setData() {
        strings = new SparseArray<>();
        fragments = new SparseArray<>();
        strings.append(0,"商品详情");
        strings.append(1,"商品参数");

        imageView.setVisibility(View.VISIBLE);
        tvTitle.setText("商品详情");
        goodsId = getIntent().getStringExtra("goodsId");
        GoodsRushInfoPresenter goodsRushInfoPresenter = new GoodsRushInfoPresenter(this);
        goodsRushInfoPresenter.getGoodsInfo(goodsId,this::goodsInfoBack);
    }

    @OnClick({R.id.iv_back,R.id.tv_canyu})
    public void click(View view){
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_canyu:
                ConfirmOrderActivity.start(this,goodsRushinfoBean);
                break;
        }
    }

    public void goodsInfoBack(GoodsRushinfoBean goodsRushinfoBean) {
        this.goodsRushinfoBean = goodsRushinfoBean;
        initData(goodsRushinfoBean);
    }

    private void initData(GoodsRushinfoBean goodsRushinfoBean) {
        List<String> list = new ArrayList<>();
        for (GoodsRushinfoBean.RushGoodsBannerBean rushGoodsBannerBean :goodsRushinfoBean.getRushGoodsBanner()) {
            list.add(rushGoodsBannerBean.getImg_Path());
        }
        //设置banner样式
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        bannerView.setImageLoader(new GlideImageLoader());
        //设置图片集合
        bannerView.setImages(list);
        //设置banner动画效果
        bannerView.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        bannerView.isAutoPlay(true);
        //设置轮播时间
        bannerView.setDelayTime(1500);
        bannerView.start();

        tvGoodsName.setText(goodsRushinfoBean.getRushGoodsInfo().getGoods_Name());
        tvMoeny.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getPrice()));
        tvOldMoeny.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_VirtualPrice()));
        tvScep.setText(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_SpecName()+"   "+goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_AttrName());
        tvCanYuNum.setText("已有"+goodsRushinfoBean.getRushGoodsInfo().getRushNumber()+"人参加");
        tvYuPrice.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getBond()));
        tvZaiPrice.setText("中奖后再付："+String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_Price()));
        fragments.append(0, GoodsDetailsFragment.newInstance(goodsRushinfoBean.getRushGoodsInfo().getGoods_Content()));
        fragments.append(1, GoodsParamFragment.newInstance());
        ViewPagerUtil.initViewPage(viewPager,tabLayout,this,fragments,strings,100,0);
    }

}
