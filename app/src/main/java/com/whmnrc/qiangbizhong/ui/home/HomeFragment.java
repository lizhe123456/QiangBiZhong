package com.whmnrc.qiangbizhong.ui.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.presenter.home.HomePresenter;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.home.activity.FlashSaleActivity;
import com.whmnrc.qiangbizhong.ui.home.activity.LuckDrawActivity;
import com.whmnrc.qiangbizhong.ui.home.activity.UnveiledActivity;
import com.whmnrc.qiangbizhong.ui.home.adapter.GoodsAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.KillAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.LuckDrawAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.MenuAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.NewUnveiledsAdapter;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.util.TimeUtils;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.whmnrc.qiangbizhong.widget.SnapUpCountDownTimerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class HomeFragment extends BaseFragment implements HomePresenter.HomePageCall {


    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.rv_second_kill)
    RecyclerView rvSecondKill;
    @BindView(R.id.rv_new_unveileds)
    RecyclerView rvNewUnveileds;
    @BindView(R.id.rv_luck_draw)
    RecyclerView rvLuckDraw;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.countDownTimerView)
    SnapUpCountDownTimerView countDownTimerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refreshLayout;


    private HomePageBean homePageBean;
    private HomePresenter homePresenter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter(getContext(), this);
        homePresenter.getHomepage();
        homePageBean = new HomePageBean();
        homePageBean = homePageBean.intiHome();
        initMenu(homePageBean.getMenuBeans());
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                homePresenter.getHomepage();
            }
        });
    }

    private void initGoods(List<HomeResult.GoodsTjBean> goodsBeans) {
        GoodsAdapter goodsAdapter = new GoodsAdapter(mContext, 1);
        rvList.setNestedScrollingEnabled(false);
        rvList.setLayoutManager(new GridLayoutManager(mContext, 2));
        rvList.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(goodsBeans);
    }

    private void initNewUnveileds(List<HomeResult.GoodsNewAwardBean> newUnveileds) {
        NewUnveiledsAdapter newUnveiledsAdapter = new NewUnveiledsAdapter(mContext);
        rvNewUnveileds.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvNewUnveileds.setLayoutManager(layoutManager);
        rvNewUnveileds.setAdapter(newUnveiledsAdapter);
        newUnveiledsAdapter.addFirstDataSet(newUnveileds);
        newUnveiledsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    HomeResult.GoodsNewAwardBean goodsNewAwardBean = (HomeResult.GoodsNewAwardBean) item;
                    FlashSaleDetailsActivity.start(getContext(), goodsNewAwardBean.getGoods_ID(), 1);
                }else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    private void initMenu(List<HomePageBean.MenuBean> menuBeans) {
        MenuAdapter menuAdapter = new MenuAdapter(mContext, 0);
        rvMenu.setNestedScrollingEnabled(false);
        rvMenu.setLayoutManager(new GridLayoutManager(mContext, 5));
        rvMenu.setAdapter(menuAdapter);
        menuAdapter.addFirstDataSet(menuBeans);
        menuAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    switch (position) {
                        case 0:
                            AccountRechargeActivity.start(getContext(), 0);
                            break;
                        case 1:
                            LuckDrawActivity.start(getContext());
                            break;
                        case 2:
                            FlashSaleActivity.start(getContext());
                            break;
                        case 3:
                            UnveiledActivity.start(getContext());
                            break;
                        case 4:

                            break;
                    }
                }else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    private void initLuckDraw(List<HomeResult.GoodsNewAwardBean> luckDrawBeans) {
        LuckDrawAdapter luckDrawAdapter = new LuckDrawAdapter(mContext);
        rvLuckDraw.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvLuckDraw.setLayoutManager(layoutManager);
        rvLuckDraw.setAdapter(luckDrawAdapter);
        luckDrawAdapter.addFirstDataSet(luckDrawBeans);
    }

    private void initKill(List<HomeResult.GoodsRushBean> secondKillBean) {
        if (!TextUtils.isEmpty(UserManage.getInstance().getServerTime())) {
            long current = System.currentTimeMillis();
            long lend = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset() + 24*60*60*1000;
            String serverTime = UserManage.getInstance().getServerTime();
            long now =  TimeUtils.string2Milliseconds(serverTime,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            long time =  lend - now;
            if (time > 0){
                long day = time / (24 * 60 * 60 * 1000);
                long hour = (time / (60 * 60 * 1000) - day * 24);
                long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long ss = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                countDownTimerView.setTime((int) hour, (int) min, (int) ss);
                countDownTimerView.start();
            }
        }
        KillAdapter killAdapter = new KillAdapter(mContext, 0);
        rvSecondKill.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvSecondKill.setLayoutManager(layoutManager);
        rvSecondKill.setAdapter(killAdapter);
        killAdapter.addFirstDataSet(secondKillBean);

            killAdapter.setOnItemClickListener((view, item, position) -> {
                if (UserManage.getInstance().getLoginBean() != null) {
                    HomeResult.GoodsRushBean goodsRushBean = (HomeResult.GoodsRushBean) item;
                    FlashSaleDetailsActivity.start(mContext, goodsRushBean.getRushId(), 1);
                }else {
                    LoginActivity.start(getContext());
                }
            });
    }

    private void initBanner(List<HomeResult.BannerBean> list) {
        List<String> stringList = new ArrayList<>();
        for (HomeResult.BannerBean bannerBean : list) {
            stringList.add(bannerBean.getBanner_Url());
        }
        //设置banner样式
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        bannerView.setImageLoader(new GlideImageLoader());
        //设置图片集合
        bannerView.setImages(stringList);
        //设置banner动画效果
        bannerView.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        bannerView.isAutoPlay(true);
        //设置轮播时间
        bannerView.setDelayTime(1500);
        bannerView.start();
    }


    @OnClick({R.id.fl_meg, R.id.tv_more, R.id.tv_chouj_more, R.id.tv_jiexiao_more, R.id.tv_for_you_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_meg:
                break;
            case R.id.tv_more:
                FlashSaleActivity.start(mContext);
                break;
            case R.id.tv_chouj_more:
                LuckDrawActivity.start(mContext);
                break;
            case R.id.tv_for_you_more:
                break;
            case R.id.tv_jiexiao_more:
                UnveiledActivity.start(mContext);
                break;
        }
    }

    @Override
    public void homePage(HomeResult homeResult) {
        initBanner(homeResult.getBanner());
        initKill(homeResult.getGoodsRush());
        initLuckDraw(homeResult.getGoodsNewAward());
        initGoods(homeResult.getGoodsTj());
        initNewUnveileds(homeResult.getGoodsNewAward());
        refreshLayout.finishRefresh(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (countDownTimerView != null) {
            countDownTimerView.stop();
        }
    }
}
