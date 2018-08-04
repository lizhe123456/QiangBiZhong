package com.whmnrc.qiangbizhong.ui.shop;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.ShopBean;
import com.whmnrc.qiangbizhong.presenter.shop.ShopPresenter;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.SearchGoodsActivity;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ShopGoodsAdapter;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ShopTypeAdapter;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class ShopFragment extends BaseFragment implements ShopPresenter.ShopIndexCall {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.tv_open)
    TextView tvOpen;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.v_height)
    View view;

    ShopBean shopBean;

    ShopPresenter shopPresenter;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private boolean isOpen = false;
    private ShopTypeAdapter menuAdapter;
    private boolean isColl = false;


    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initData() {
        tvTitle.setText("商城");
        shopPresenter = new ShopPresenter(mContext);
        showLoading("加载中..");
        shopPresenter.getshoppingindex(true, this);

        initMenu();
        initGoodsList();

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

        refresh.setOnRefreshListener(refreshLayout -> shopPresenter.getshoppingindex(true, this));

        refresh.setOnLoadMoreListener(refreshLayout -> shopPresenter.getshoppingindex(false, this));

        view.setVisibility(View.GONE);
    }

    private void initBanner(@Nullable List<ShopBean.BannerBean> list) {
        List<String> stringList = new ArrayList<>();
        for (ShopBean.BannerBean bannerBean : list) {
            stringList.add(bannerBean.getBanner_Url());
        }
        //设置图片集合
        if (bannerView != null) {
            bannerView.setImages(stringList);
            bannerView.start();
        }
    }

    private void initMenu() {
        menuAdapter = new ShopTypeAdapter(getContext());
        rvMenu.setAdapter(menuAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 5);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMenu.setLayoutManager(gridLayoutManager);
        menuAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    ShopBean.TypeListBean typeListBean = (ShopBean.TypeListBean) item;
                    SearchGoodsActivity.start(mContext, typeListBean.getId());
                }else {
                    LoginActivity.start(mContext);
                }
            }
        });
    }

    private void initGoodsList() {
        yiMeiGoodsAdapter = new ShopGoodsAdapter(mContext);
        rvGoods.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoods.setAdapter(yiMeiGoodsAdapter);

    }

    ShopGoodsAdapter yiMeiGoodsAdapter;

    @OnClick({R.id.ll_search, R.id.fl_open})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_search:
                if (UserManage.getInstance().getLoginBean() != null) {
                    SearchGoodsActivity.start(mContext, "");
                }else {
                    LoginActivity.start(mContext);
                }
                break;
            case R.id.fl_open:
                if (isOpen) {
                    isOpen = false;
                    menuAdapter.setOpen(isOpen, shopBean.getTypeList());
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_open);
                    tvOpen.setText(getString(R.string.open));
                    tvOpen.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLeft, null);
                    tvOpen.setCompoundDrawablePadding(20);
                } else {
                    isOpen = true;
                    menuAdapter.setOpen(isOpen, shopBean.getTypeList());
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_take_up);
                    tvOpen.setText(getString(R.string.take_up));
                    tvOpen.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLeft, null);
                    tvOpen.setCompoundDrawablePadding(20);
                }
                break;
        }
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void shoIndex(@NonNull ShopBean shopBean) {
        this.shopBean = shopBean;
        initBanner(shopBean.getBanner());
        menuAdapter.setOpen(isOpen, shopBean.getTypeList());
        yiMeiGoodsAdapter.addFirstDataSet(shopBean.getPalteList());
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(@NonNull List<ShopBean.PalteListBean> palteListBeans) {
        yiMeiGoodsAdapter.addMoreDataSet(palteListBeans);
        refresh.finishLoadMore(true);
    }

}
