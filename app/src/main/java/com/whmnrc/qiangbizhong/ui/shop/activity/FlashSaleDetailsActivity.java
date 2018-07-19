package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.presenter.home.GoodsRushInfoPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class FlashSaleDetailsActivity extends BaseActivity implements GoodsRushInfoPresenter.GoodsInfoCall,GoodsRushInfoPresenter.CanYuCall {

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
    @BindView(R.id.countDownTimerView1)
    SnapUpCountDownTimerView countDownTimerView1;
    @BindView(R.id.tv_juli_time)
    TextView tvJuLiTime;
    @BindView(R.id.rl_js)
    RelativeLayout rlJs;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;


    private SparseArray<Fragment> fragments;
    private SparseArray<String> strings;

    private String goodsId;
    private GoodsRushinfoBean.RushGoodsInfoBean goodsRushinfoBean;
    private GoodsRushinfoBean goodsRushinfoBeans;
    private GoodsRushInfoPresenter goodsRushInfoPresenter;
    long lend;
    long lstart;
    long now;

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
        goodsRushInfoPresenter.getGoodsInfo(goodsId, this);
        countDownTimerView.setJiShiWanCheng(new SnapUpCountDownTimerView.JiShiWanCheng() {
            @Override
            public void jsS() {
//                goodsRushInfoPresenter.getGoodsInfo(goodsId, FlashSaleDetailsActivity.this);
                rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                rlCanYu.setVisibility(View.GONE);
            }
        });

        countDownTimerView1.setJiShiWanCheng(new SnapUpCountDownTimerView.JiShiWanCheng() {
            @Override
            public void jsS() {
                goodsRushInfoPresenter.getGoodsInfo(goodsId, FlashSaleDetailsActivity.this);
//                rlCanYu.setVisibility(View.VISIBLE);
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

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                goodsRushInfoPresenter.getGoodsInfo(goodsId, FlashSaleDetailsActivity.this);
                refresh.finishRefresh(3000);
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
                    if (btnStatu() == 1) {
                        //再活动时间内
                        ToastUtils.showShort("活动已开始");
                    } else if (btnStatu() == 2) {
                        //未开始
                        ConfirmOrderActivity.start(this, goodsRushinfoBean);
                    }
                } else if (goodsRushinfoBeans.getParticipate() == 1) {
                    if (btnStatu() == 1) {
                        //再活动时间内
                        new SweetAlertDialog(this)
                                .setTitleText("提示")
                                .setContentText("确定要支付吗" + (goodsRushinfoBean.getGoodsPrice_Price() - goodsRushinfoBean.getBond()) + "？")
                                .setCancelButton("取消", Dialog::dismiss).setConfirmButton("确认", sweetAlertDialog -> {
                            sweetAlertDialog.dismiss();
                            showLoading("抢购中..");
                            goodsRushInfoPresenter.cayu(goodsRushinfoBean.getRushId(),this);
                        }).show();
                    }
                }
                break;
        }
    }

    public boolean isFrist;

    @SuppressLint("SetTextI18n")
    @Override
    public void goodsInfoBack(@NonNull GoodsRushinfoBean goodsRushinfoBean) {
        try {
            this.goodsRushinfoBean = goodsRushinfoBean.getRushGoodsInfo();
            this.goodsRushinfoBeans = goodsRushinfoBean;
            List<String> list = new ArrayList<>();
            for (GoodsRushinfoBean.RushGoodsBannerBean rushGoodsBannerBean : goodsRushinfoBean.getRushGoodsBanner()) {
                list.add(rushGoodsBannerBean.getImg_Path());
            }
            if (!isFrist) {
                isFrist = true;
                //设置图片集合
                bannerView.setImages(list);
                bannerView.start();
                fragments.append(0, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + goodsRushinfoBean.getRushGoodsInfo().getGoods_ID() + "&showType=0"));
                fragments.append(1, GoodsDetailsFragment.newInstance(Constants.INFO_ADDRESS + "?goodsId=" + goodsRushinfoBean.getRushGoodsInfo().getGoods_ID() + "&showType=1"));
                ViewPagerUtil.initViewPage(viewPager, tabLayout, this, fragments, strings, 100, 0);
            }
            tvGoodsName.setText(goodsRushinfoBean.getRushGoodsInfo().getGoods_Name());
            tvMoeny.setText("" + String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_Price()));
            tvOldMoeny.setText("原价：" + String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_VirtualPrice()));
            tvOldMoeny.getPaint().setAntiAlias(true);//抗锯齿
            tvOldMoeny.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
            tvScep.setText(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_SpecName() == null ? "" : goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_SpecName() + "   " + goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_AttrName());
            tvCanYuNum.setText("已有" + goodsRushinfoBean.getRushGoodsInfo().getRushNumber() + "人参加");
            tvYuPrice.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getBond()));
            tvZaiPrice.setText("中奖后再付：" + String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getGoodsPrice_Price() - goodsRushinfoBean.getRushGoodsInfo().getBond()));
            initData(goodsRushinfoBean);
        } catch (NullPointerException e) {

        }
        refresh.finishRefresh(true);
    }

    @SuppressLint("SimpleDateFormat")
    public int btnStatu() {
//        String start = goodsRushinfoBean.getRushStartTime();
//        String end = goodsRushinfoBean.getRushEndTime();
//        long lstart = TimeUtils.string2Milliseconds(start, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        long lend = TimeUtils.string2Milliseconds(end, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        String serverTime = UserManage.getInstance().getServerTime();
//        long now = TimeUtils.string2Milliseconds(serverTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
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

    @SuppressLint("SimpleDateFormat")
    private void initData(@NonNull GoodsRushinfoBean goodsRushinfoBean) {
        try {
            lend = TimeUtils.string2Milliseconds(goodsRushinfoBean.getRushGoodsInfo().getRushEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            lstart = TimeUtils.string2Milliseconds(goodsRushinfoBean.getRushGoodsInfo().getRushStartTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            now = TimeUtils.string2Milliseconds(UserManage.getInstance().getServerTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            long time = lend - now;
            long startTime = lstart - now;
            if ((lstart - now) > 0) {
                long day = startTime / (24 * 60 * 60 * 1000);
                long hour = (startTime / (60 * 60 * 1000) - day * 24);
                long min = ((startTime / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long ss = (startTime / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                countDownTimerView1.setTime((int) hour, (int) min, (int) ss);
                countDownTimerView1.start();
                countDownTimerView1.setVisibility(View.VISIBLE);
                countDownTimerView.setVisibility(View.GONE);
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
                    countDownTimerView.start();
                    countDownTimerView.setVisibility(View.VISIBLE);
                    countDownTimerView1.setVisibility(View.GONE);
                }
            }
            rlCanYu.setVisibility(View.VISIBLE);
            if (goodsRushinfoBean.getParticipate() == 1) {
                if (btnStatu() == 1) {
                    //再活动时间内
                    tvCanYu.setText("立即抢购");
                    tvCanYu.setBackgroundResource(R.drawable.ic_rectangle);
                    rlJs.setBackgroundResource(R.drawable.ic_award_title);
                } else if (btnStatu() == 2) {
                    tvCanYu.setText("未开始");
                    rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                } else if (btnStatu() == 3) {
                    rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                    rlCanYu.setVisibility(View.GONE);
                }
            } else if (goodsRushinfoBean.getParticipate() == 0) {
                if (btnStatu() == 1) {
                    //再活动时间内
                    tvCanYu.setText("未预约");
                    rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                } else if (btnStatu() == 2) {
                    //未开始
                    tvCanYu.setText("立即预约");
                    tvCanYu.setBackgroundResource(R.drawable.bg_color_btn);
                    rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                } else if (btnStatu() == 3) {
                    //已借宿
                    rlJs.setBackgroundResource(R.drawable.ic_flash_sale_details_bg);
                    rlCanYu.setVisibility(View.GONE);
                }
            } else if (goodsRushinfoBean.getParticipate() == 2) {
                tvCanYu.setText("已抢购");
            }else if (goodsRushinfoBean.getParticipate() == 3){
                tvCanYu.setText("已放弃");
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    @Override
    protected void onDestroy() {
        if (countDownTimerView != null) {
            countDownTimerView.stop();
            countDownTimerView.setJiShiWanCheng(null);
        }
        if (countDownTimerView1 != null) {
            countDownTimerView1.stop();
            countDownTimerView1.setJiShiWanCheng(null);
        }
        super.onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            if (requestCode == 102) {
                if (goodsRushInfoPresenter != null) {
                    if (goodsId != null) {
                        goodsRushInfoPresenter.getGoodsInfo(goodsId, this);
                    }
                }
            }
        }
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
    }

    @Override
    public void canyuBack() {
        new SweetAlertDialog(this)
                .setTitleText("提示")
                .setContentText("余额不足,请充值！")
                .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
                AccountRechargeActivity.start(FlashSaleDetailsActivity.this,0);
            }
        }).show();
    }
}
