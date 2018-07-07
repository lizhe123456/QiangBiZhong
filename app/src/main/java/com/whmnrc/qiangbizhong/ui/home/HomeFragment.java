package com.whmnrc.qiangbizhong.ui.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.ui.home.adapter.KillAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.LuckDrawAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.MenuAdapter;
import com.whmnrc.qiangbizhong.ui.home.adapter.NewUnveiledsAdapter;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class HomeFragment extends BaseFragment {


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

    private HomePageBean homePageBean;

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
        homePageBean = new HomePageBean();
        homePageBean = homePageBean.intiHome();
        initBanner(homePageBean.getBanner());
        initKill(homePageBean.getSecondKillBean());
        initLuckDraw(homePageBean.getLuckDrawBeans());
        initMenu(homePageBean.getMenuBeans());
        initNewUnveileds(homePageBean.getNewUnveileds());
        initGoods(homePageBean.getGoodsBeans());
    }

    private void initGoods(List<HomePageBean.GoodsBean> goodsBeans) {
        KillAdapter killAdapter = new KillAdapter(mContext,1);
        rvList.setNestedScrollingEnabled(false);
        rvList.setLayoutManager(new GridLayoutManager(mContext,2));
        rvList.setAdapter(killAdapter);
        killAdapter.addFirstDataSet(goodsBeans);
    }

    private void initNewUnveileds(List<HomePageBean.NewUnveiled> newUnveileds) {
        NewUnveiledsAdapter newUnveiledsAdapter = new NewUnveiledsAdapter(mContext);
        rvNewUnveileds.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvNewUnveileds.setLayoutManager(layoutManager);
        rvNewUnveileds.setAdapter(newUnveiledsAdapter);
        newUnveiledsAdapter.addFirstDataSet(newUnveileds);
    }

    private void initMenu(List<HomePageBean.MenuBean> menuBeans) {
        MenuAdapter menuAdapter = new MenuAdapter(mContext,0);
        rvMenu.setNestedScrollingEnabled(false);
        rvMenu.setLayoutManager(new GridLayoutManager(mContext,5));
        rvMenu.setAdapter(menuAdapter);
        menuAdapter.addFirstDataSet(menuBeans);
    }

    private void initLuckDraw(List<HomePageBean.LuckDrawBean> luckDrawBeans) {
        LuckDrawAdapter luckDrawAdapter = new LuckDrawAdapter(mContext);
        rvLuckDraw.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvLuckDraw.setLayoutManager(layoutManager);
        rvLuckDraw.setAdapter(luckDrawAdapter);
        luckDrawAdapter.addFirstDataSet(luckDrawBeans);
    }

    private void initKill(HomePageBean.SecondKillBean secondKillBean) {
        KillAdapter killAdapter = new KillAdapter(mContext,0);
        rvSecondKill.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvSecondKill.setLayoutManager(layoutManager);
        rvSecondKill.setAdapter(killAdapter);
        killAdapter.addFirstDataSet(secondKillBean.getList());
    }

    private void initBanner(List<String> banner) {
        bannerView.setImages(banner);
        bannerView.start();
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }


    @OnClick(R.id.fl_meg)
    public void onViewClicked() {
    }

}
