package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.presenter.home.AwardPresenter;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.home.adapter.LuckDrawItemAdapter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
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
 * Created by lizhe on 2018/7/9.
 */

public class LuckDrawFragment extends BaseFragment implements AwardPresenter.AwardCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;

    private AwardPresenter awardPresenter;


    public static LuckDrawFragment newInstance() {
        Bundle args = new Bundle();
        LuckDrawFragment fragment = new LuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private LuckDrawItemAdapter luckDrawItemAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_luck_draw;
    }

    @Override
    protected void initData() {
        awardPresenter = new AwardPresenter(getContext());
        luckDrawItemAdapter = new LuckDrawItemAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvGoods.setLayoutManager(gridLayoutManager);
        rvGoods.setAdapter(luckDrawItemAdapter);

        awardPresenter.getAwardList(0,this);
        tvTitle.setText("抽奖");
        ivBack.setVisibility(View.VISIBLE);

        luckDrawItemAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                LuckDrawBean.GoodsBean goodsBean = (LuckDrawBean.GoodsBean) item;
                AwardDetailActivity.start(getContext(),goodsBean.getAwardId());
            }
        });
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setIndicatorGravity(BannerConfig.CENTER);
        bannerView.setImageLoader(new GlideImageLoader());

        bannerView.setBannerAnimation(Transformer.Default);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(1500);
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
    public void awardBack(LuckDrawBean luckDrawBeans) {
        List<String> list = new ArrayList<>();
        for ( LuckDrawBean.BannerBean bannerBean:luckDrawBeans.getBanner()) {
            list.add(bannerBean.getBanner_Url());
        }
        initBanner(list);
        luckDrawItemAdapter.addFirstDataSet(luckDrawBeans.getGoods());
    }


    @Override
    public void error() {

    }
}
