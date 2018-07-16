package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AwardBeanInfo;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.presenter.home.GoodsRushInfoPresenter;
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
    @BindView(R.id.rl_canyu)
    RelativeLayout rlCanYu;
    @BindView(R.id.countDownTimerView)
    SnapUpCountDownTimerView countDownTimerView;
    @BindView(R.id.tv_juli_time)
    TextView tvJuLiTime;

    private SparseArray<Fragment> fragments;
    private SparseArray<String> strings;

    private String goodsId;
    private GoodsRushinfoBean.RushGoodsInfoBean goodsRushinfoBean;
    private GoodsRushinfoBean goodsRushinfoBeans;
    private GoodsRushInfoPresenter goodsRushInfoPresenter;

    public static void start(Context context, String goodsId, int type) {
        Intent starter = new Intent(context, FlashSaleDetailsActivity.class);
        starter.putExtra("goodsId", goodsId);
        starter.putExtra("type", type);
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
        strings.append(0, "商品详情");
        strings.append(1, "商品参数");

        imageView.setVisibility(View.VISIBLE);
        tvTitle.setText("商品详情");
        goodsId = getIntent().getStringExtra("goodsId");
        goodsRushInfoPresenter = new GoodsRushInfoPresenter(this);
        showLoading("加载中..");
        goodsRushInfoPresenter.getGoodsInfo(goodsId, this::goodsInfoBack);
        countDownTimerView.setJiShiWanCheng(new SnapUpCountDownTimerView.JiShiWanCheng() {
            @Override
            public void jsS() {
                goodsRushInfoPresenter.getGoodsInfo(goodsId, FlashSaleDetailsActivity.this::goodsInfoBack);
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_canyu})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_canyu:
                if (goodsRushinfoBeans.getParticipate() == 0) {
                    if (btnStatu() == 0) {

                    } else if (btnStatu() == 1) {
                        //再活动时间内
                        ToastUtils.showShort("活动已开始");
                    } else if (btnStatu() == 2) {
                        //未开始
                        ConfirmOrderActivity.start(this, goodsRushinfoBean);
                    } else if (btnStatu() == 3) {
                        //已借宿
                    } else {

                    }
                } else if (goodsRushinfoBeans.getParticipate() == 1) {
                    if (btnStatu() == 0) {

                    } else if (btnStatu() == 1) {
                        //再活动时间内
                        goodsRushInfoPresenter.cayu(goodsRushinfoBean.getRushId());
                    } else if (btnStatu() == 2) {

                    } else if (btnStatu() == 3) {

                    } else {

                    }
                } else {

                }
                break;
        }
    }

    private boolean isFirst;

    public void goodsInfoBack(GoodsRushinfoBean goodsRushinfoBean) {
        this.goodsRushinfoBean = goodsRushinfoBean.getRushGoodsInfo();
        this.goodsRushinfoBeans = goodsRushinfoBean;
        List<String> list = new ArrayList<>();
        for (GoodsRushinfoBean.RushGoodsBannerBean rushGoodsBannerBean : goodsRushinfoBean.getRushGoodsBanner()) {
            list.add(rushGoodsBannerBean.getImg_Path());
        }
        if (!isFirst) {
            isFirst = true;
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
            tvMoeny.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_Price()));
            tvOldMoeny.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_VirtualPrice()));
            tvScep.setText(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_SpecName() == null ? "" : goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_SpecName() + "   " + goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_AttrName());
            tvCanYuNum.setText("已有" + goodsRushinfoBean.getRushGoodsInfo().getRushNumber() + "人参加");
            tvYuPrice.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getBond()));
            tvZaiPrice.setText("中奖后再付：" + String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_Price()));
            fragments.append(0, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + goodsRushinfoBean.getRushGoodsInfo().getGoods_ID() + "&showType=0"));
            fragments.append(1, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + goodsRushinfoBean.getRushGoodsInfo().getGoods_ID() + "&showType=1"));
            ViewPagerUtil.initViewPage(viewPager, tabLayout, this, fragments, strings, 100, 0);
        }
        initData(goodsRushinfoBean);
    }

    public int btnStatu() {
        String start = goodsRushinfoBean.getRushStartTime();
        String end = goodsRushinfoBean.getRushEndTime();
        long lstart = TimeUtils.string2Milliseconds(start, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        long lend = TimeUtils.string2Milliseconds(end, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String serverTime = UserManage.getInstance().getServerTime();
        long now = TimeUtils.string2Milliseconds(serverTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        if (lstart <= now) {
            //再活动时间内
            if (now <= lend) {
                return 1;
            }
        }
        if (lstart > now) {
            //未开始
            return 2;
        }
        if (lend < now) {
            //已借宿
            return 3;
        }

        return 0;
    }

    private void initData(GoodsRushinfoBean goodsRushinfoBean) {
        String end = goodsRushinfoBean.getRushGoodsInfo().getRushEndTime();
        long lend = TimeUtils.string2Milliseconds(end, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String start = goodsRushinfoBean.getRushGoodsInfo().getRushStartTime();
        long lstart = TimeUtils.string2Milliseconds(start, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String serverTime = UserManage.getInstance().getServerTime();
        long now = TimeUtils.string2Milliseconds(serverTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        long time = lend - now;
        long startTime = lstart - now;
        if ((lstart - now) > 0) {
            long day = startTime / (24 * 60 * 60 * 1000);
            long hour = (startTime / (60 * 60 * 1000) - day * 24);
            long min = ((startTime / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long ss = (startTime / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            countDownTimerView.setTime((int) hour, (int) min, (int) ss);
            countDownTimerView.start();
            tvJuLiTime.setText("距开始仅剩");
        } else {
            if (time > 0) {
                long day = time / (24 * 60 * 60 * 1000);
                long hour = (time / (60 * 60 * 1000) - day * 24);
                long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long ss = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                countDownTimerView.setTime((int) hour, (int) min, (int) ss);
                countDownTimerView.start();
                tvJuLiTime.setText("距结束仅剩");
            }
        }

        if (goodsRushinfoBean.getParticipate() == 1) {
            if (btnStatu() == 0) {

            } else if (btnStatu() == 1) {
                //再活动时间内
                tvCanYu.setText("我要抢购");
            } else if (btnStatu() == 2) {
                tvCanYu.setText("未开始");
            } else if (btnStatu() == 3) {
                rlCanYu.setVisibility(View.GONE);
            } else {

            }
        } else {
            if (btnStatu() == 0) {

            } else if (btnStatu() == 1) {
                //再活动时间内
                tvCanYu.setText("未预约");
            } else if (btnStatu() == 2) {
                //未开始
                tvCanYu.setText("我要参与");
            } else if (btnStatu() == 3) {
                //已借宿
                rlCanYu.setVisibility(View.GONE);
            } else {

            }
        }


    }

}
