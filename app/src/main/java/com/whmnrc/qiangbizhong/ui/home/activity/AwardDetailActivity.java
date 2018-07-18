package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AwardBeanInfo;
import com.whmnrc.qiangbizhong.presenter.home.GoodsRushInfoPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.ConfirmOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shop.fragment.GoodsDetailsFragment;
import com.whmnrc.qiangbizhong.util.TimeUtils;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.whmnrc.qiangbizhong.widget.SnapUpCountDownTimerView;
import com.whmnrc.qiangbizhong.widget.WrapContentHeightViewPager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/16.
 */

public class AwardDetailActivity extends BaseActivity implements GoodsRushInfoPresenter.AwardCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.tv_time_title)
    TextView tvTimeTitle;
    @BindView(R.id.tv_juli_time)
    TextView tvJuliTime;
    @BindView(R.id.countDownTimerView)
    SnapUpCountDownTimerView countDownTimerView;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.tv_canyu_num)
    TextView tvCanyuNum;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_old_moeny)
    TextView tvOldMoeny;
    @BindView(R.id.tv_scep)
    TextView tvScep;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    WrapContentHeightViewPager vpContent;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;
    @BindView(R.id.tv_yu_price)
    TextView tvYuPrice;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_canyu)
    TextView tvCanyu;
    @BindView(R.id.iv_customer_service)
    ImageView ivCustomerService;
    @BindView(R.id.rl_canyu)
    RelativeLayout rlCanYu;

    private GoodsRushInfoPresenter goodsRushInfoPresenter;
    private SparseArray<Fragment> fragments;
    private SparseArray<String> strings;
    private AwardBeanInfo awardBeanInfo;


    public static void start(Context context, String goodsId) {
        Intent starter = new Intent(context, AwardDetailActivity.class);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);
    }

    public static void start(Context context,String goodsId,String userId) {
        Intent starter = new Intent(context, AwardDetailActivity.class);
        starter.putExtra("goodsId",goodsId);
        starter.putExtra("userId",userId);
        context.startActivity(starter);
    }

    private String goodsId;

    @Override
    protected int setLayout() {
        return R.layout.activity_award_detail;
    }

    @Override
    protected void setData() {
        tvTitle.setText("抽奖详情");
        ivBack.setVisibility(View.VISIBLE);
        goodsId = getIntent().getStringExtra("goodsId");
        showLoading("加载中..");
        goodsRushInfoPresenter = new GoodsRushInfoPresenter(this);
        goodsRushInfoPresenter.awardInfo(goodsId,this);
        strings = new SparseArray<>();
        strings.append(0, "商品详情");
        strings.append(1, "商品参数");

        countDownTimerView.setJiShiWanCheng(new SnapUpCountDownTimerView.JiShiWanCheng() {
            @Override
            public void jsS() {
                if (goodsId != null) {
                    goodsRushInfoPresenter.awardInfo(goodsId, AwardDetailActivity.this);
                }
            }
        });

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

    @Override
    public void awardBack(AwardBeanInfo awardBeanInfo) {
        this.awardBeanInfo = awardBeanInfo;
        updateData(awardBeanInfo);
    }

    public boolean isFrist;

    private void updateData(AwardBeanInfo awardBeanInfo) {
        String end = awardBeanInfo.getAwardGoodsInfo().getAwardTime();
        long lend = TimeUtils.string2Milliseconds(end,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String serverTime = UserManage.getInstance().getServerTime();
        long now =  TimeUtils.string2Milliseconds(serverTime,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        long time =  lend - now;
        if (time > 0) {
            long day = time / (24 * 60 * 60 * 1000);
            long hour = (time / (60 * 60 * 1000) - day * 24);
            long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long ss = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            countDownTimerView.setTime((int) hour, (int) min, (int) ss);
            countDownTimerView.start();
        }else {
            rlCanYu.setVisibility(View.GONE);
        }

        if (!isFrist) {
            isFrist = true;
            initBanner(awardBeanInfo.getAwardGoodsBanner());

            tvGoodsName.setText(awardBeanInfo.getAwardGoodsInfo().getGoods_Name());
            tvMoeny.setText(String.valueOf(awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_Price()));
            tvOldMoeny.setText("原价：" + String.valueOf(awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_VirtualPrice()));
            tvOldMoeny.getPaint().setAntiAlias(true);//抗锯齿
            tvOldMoeny.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
            tvScep.setText(awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_SpecName() == null ? "" : awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_SpecName() + "   " + awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_AttrName());
            tvCanyuNum.setText("已有" + awardBeanInfo.getAwardGoodsInfo().getAwardPeopleCount() + "人参加");
            tvYuPrice.setText("中奖后再付：" + String.valueOf(awardBeanInfo.getAwardGoodsInfo().getGoodsPrice_Price() - awardBeanInfo.getAwardGoodsInfo().getBond()));
            tvPrice.setText(String.valueOf(awardBeanInfo.getAwardGoodsInfo().getBond()));
            fragments = new SparseArray();
            fragments.append(0, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + awardBeanInfo.getAwardGoodsInfo().getGoods_ID() + "&showType=0"));
            fragments.append(1, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + awardBeanInfo.getAwardGoodsInfo().getGoods_ID() + "&showType=1"));
            ViewPagerUtil.initViewPage(vpContent, tabLayout, this, fragments, strings, 100, 0);
        }

        if (awardBeanInfo.getParticipate() == 1){
            if (time > 0){
                tvCanyu.setText("等待开奖");
            }else {
                rlCanYu.setVisibility(View.GONE);
            }
        }else if (awardBeanInfo.getParticipate() == 0){
            if (time > 0){
                tvCanyu.setText("立即参与");
            }else {
                rlCanYu.setVisibility(View.GONE);
            }
        }else if (awardBeanInfo.getParticipate() == 2){
            rlCanYu.setVisibility(View.GONE);
        }

    }

    private void initBanner(List<AwardBeanInfo.AwardGoodsBanner> awardGoodsBanner) {
        List<String> list = new ArrayList<>();
        for (AwardBeanInfo.AwardGoodsBanner a : awardGoodsBanner) {
            list.add(a.getImg_Path());
        }

        //设置图片集合
        bannerView.setImages(awardGoodsBanner);
        bannerView.start();
    }


    @OnClick({R.id.iv_back, R.id.tv_canyu, R.id.iv_customer_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_canyu:
                String end = awardBeanInfo.getAwardGoodsInfo().getAwardTime();
                long lend = TimeUtils.string2Milliseconds(end,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                String serverTime = UserManage.getInstance().getServerTime();
                long now =  TimeUtils.string2Milliseconds(serverTime,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                long time =  lend - now;
                if (awardBeanInfo.getParticipate() == 1){
                }else if (awardBeanInfo.getParticipate() == 0){
                    if (time > 0){
                        ConfirmOrderActivity.start(this,awardBeanInfo.getAwardGoodsInfo());
                    }else {

                    }
                }else if (awardBeanInfo.getParticipate() == 2){

                }
                break;
            case R.id.iv_customer_service:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101){
            if (requestCode == 102) {
                if (goodsRushInfoPresenter != null) {
                    if (goodsId != null) {
                        goodsRushInfoPresenter.awardInfo(goodsId, AwardDetailActivity.this);
                    }
                }
            }
        }
    }

    @Override
    public void error() {

    }
}
