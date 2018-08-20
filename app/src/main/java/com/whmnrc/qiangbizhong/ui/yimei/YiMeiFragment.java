package com.whmnrc.qiangbizhong.ui.yimei;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.model.bean.YiMeiIndexBean;
import com.whmnrc.qiangbizhong.presenter.yimei.YiMeiPresenter;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsListActivity;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.YiMeiGoodsAdapter;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.YiMeiMenuAdapter;
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

public class YiMeiFragment extends BaseFragment implements YiMeiPresenter.MedicalIndexCall {
//public class YiMeiFragment extends BaseFragment {


    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.tv_open)
    TextView tvOpen;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private boolean isOpen = false;
    private List<YiMeiIndexBean.TypeListBean> menuBeans;
    private YiMeiMenuAdapter menuAdapter;
    private YiMeiGoodsAdapter mYiMeiGoodsAdapter;
    private YiMeiPresenter mYiMeiPresenter;

    public static YiMeiFragment newInstance() {
        Bundle args = new Bundle();
        YiMeiFragment fragment = new YiMeiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yimei;
    }

    @Override
    protected void initData() {
        initMenu();
        initGoodsList();
        mYiMeiPresenter = new YiMeiPresenter(mContext);
        mYiMeiPresenter.medicalIndex(true, this);

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

        refresh.setOnRefreshListener(refreshLayout-> mYiMeiPresenter.medicalIndex(true,this));

        refresh.setOnLoadMoreListener(refreshLayout -> mYiMeiPresenter.medicalIndex(false,this));
    }

    private void initGoodsList() {
        mYiMeiGoodsAdapter = new YiMeiGoodsAdapter(getContext());
        rvGoods.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGoods.setAdapter(mYiMeiGoodsAdapter);
    }

    private void initMenu() {
        menuAdapter = new YiMeiMenuAdapter(getContext());
        rvMenu.setAdapter(menuAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 5);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMenu.setLayoutManager(gridLayoutManager);
        menuAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    YiMeiIndexBean.TypeListBean typeListBean = (YiMeiIndexBean.TypeListBean) item;
                    YiMeiGoodsListActivity.start(getContext(), typeListBean.getId());
                }else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    private void initBanner(List<YiMeiIndexBean.BannerBean> banners) {
        List<String> list = new ArrayList<>();
        for (YiMeiIndexBean.BannerBean bannerBean :banners) {
            list.add(bannerBean.getBanner_Url());
        }
        bannerView.setImages(list);
        bannerView.start();
    }


    @OnClick({R.id.ll_search, R.id.fl_open})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_search:
                if (UserManage.getInstance().getLoginBean() != null) {
                    YiMeiGoodsListActivity.start(mContext);
                } else {
                    LoginActivity.start(getContext());
                }
                break;
            case R.id.fl_open:
                if (isOpen) {
                    isOpen = false;
                    menuAdapter.setOpen(isOpen, menuBeans);
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_open);
                    tvOpen.setText(getString(R.string.open));
                    tvOpen.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLeft, null);
                    tvOpen.setCompoundDrawablePadding(20);
                } else {
                    isOpen = true;
                    menuAdapter.setOpen(isOpen, menuBeans);
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
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void medicalIndexBack(@NonNull YiMeiIndexBean yiMeiIndexBean) {
        initBanner(yiMeiIndexBean.getBanner());
        menuBeans = yiMeiIndexBean.getTypeList();
        menuAdapter.addFirstDataSet(menuBeans);
        mYiMeiGoodsAdapter.addFirstDataSet(yiMeiIndexBean.getMedicalList());
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(@NonNull List<YiMeiIndexBean.MedicalListBean> listBeans) {
        mYiMeiGoodsAdapter.addMoreDataSet(listBeans);
        refresh.finishLoadMore(true);
    }


}
