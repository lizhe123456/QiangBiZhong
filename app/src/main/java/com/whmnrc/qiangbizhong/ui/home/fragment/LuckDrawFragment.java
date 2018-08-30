package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.presenter.home.AwardPresenter;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.home.adapter.LuckDrawItemAdapter;
import com.whmnrc.qiangbizhong.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LuckDrawFragment extends BaseFragment implements AwardPresenter.AwardCall {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private AwardPresenter awardPresenter;


    public static LuckDrawFragment newInstance() {
        Bundle args = new Bundle();
        LuckDrawFragment fragment = new LuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private LuckDrawItemAdapter luckDrawItemAdapter;

    @Override
    public void onResume() {
        super.onResume();
        if (awardPresenter != null){
            awardPresenter.getAwardList(this,true);
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_luck_draw;
    }

    @Override
    protected void initData() {
        awardPresenter = new AwardPresenter(getActivity());
        luckDrawItemAdapter = new LuckDrawItemAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvGoods.setLayoutManager(gridLayoutManager);
        rvGoods.setAdapter(luckDrawItemAdapter);
        showLoading("加载中..");
        awardPresenter.getAwardList(this,true);
        tvTitle.setText("抽奖");
        ivBack.setVisibility(View.VISIBLE);

        luckDrawItemAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                LuckDrawBean.GoodsBean goodsBean = (LuckDrawBean.GoodsBean) item;
                AwardDetailActivity.start(getContext(), goodsBean.getAwardId());
            }
        });
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setIndicatorGravity(BannerConfig.CENTER);
        bannerView.setImageLoader(new GlideImageLoader());

        bannerView.setBannerAnimation(Transformer.Default);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(1500);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                awardPresenter.getAwardList(LuckDrawFragment.this,true);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                awardPresenter.getAwardList(LuckDrawFragment.this,false);
            }
        });
    }


    private void initBanner(List<String> list) {
        if (list != null) {
            bannerView.setImages(list);
            bannerView.start();
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                getActivity().finish();
                break;
        }
    }

    @Override
    public void awardBack(@NonNull LuckDrawBean luckDrawBeans) {
        List<String> list = new ArrayList<>();
        for (LuckDrawBean.BannerBean bannerBean : luckDrawBeans.getBanner()) {
            list.add(bannerBean.getBanner_Url());
        }
        initBanner(list);
        if (luckDrawBeans.getGoods().size() == 0){
            showEmpty();
            rvGoods.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            rvGoods.setVisibility(View.VISIBLE);
        }
        luckDrawItemAdapter.addFirstDataSet(luckDrawBeans.getGoods());
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<LuckDrawBean.GoodsBean> goodsBean) {
        luckDrawItemAdapter.addMoreDataSet(goodsBean);
        refresh.finishLoadMore(true);
    }


    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("暂无更多数据~");
            vsEmpty.setVisibility(View.VISIBLE);
            rvGoods.setVisibility(View.GONE);
        }
    }




}
