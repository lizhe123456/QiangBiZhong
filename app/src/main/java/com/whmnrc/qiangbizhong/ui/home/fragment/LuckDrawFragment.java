package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.ui.home.adapter.LuckDrawItemAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LuckDrawFragment extends BaseFragment {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.rv_luck_draw)
    RecyclerView rvLuckDraw;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;

    public static LuckDrawFragment newInstance() {
        Bundle args = new Bundle();
        LuckDrawFragment fragment = new LuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private LuckDrawItemAdapter luckDrawItemAdapter;
    private OpenLuckAdapter openLuckAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_luck_draw;
    }

    @Override
    protected void initData() {
        LuckDrawBean luckDrawBean = new LuckDrawBean();
        luckDrawBean.initData();
        luckDrawItemAdapter = new LuckDrawItemAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvGoods.setLayoutManager(gridLayoutManager);
        rvGoods.setAdapter(luckDrawItemAdapter);
        luckDrawItemAdapter.addFirstDataSet(luckDrawBean.getLuckDrawGoodsBeans());
        openLuckAdapter = new OpenLuckAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvLuckDraw.setLayoutManager(layoutManager);
        rvLuckDraw.setAdapter(openLuckAdapter);
        openLuckAdapter.addFirstDataSet(luckDrawBean.getOpenLuckDrawBeans());
        tvTitle.setText("抽奖");
        ivBack.setVisibility(View.VISIBLE);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        initBanner(list);
    }

    private void initBanner(List<String> list) {
        bannerView.setImages(list);
        bannerView.start();
    }


    @OnClick({R.id.iv_back, R.id.tv_chouj_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                getActivity().finish();
                break;
            case R.id.tv_chouj_more:

                break;
        }
    }

    class OpenLuckAdapter extends BaseAdapter<LuckDrawBean.OpenLuckDrawBean> {

        public OpenLuckAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, LuckDrawBean.OpenLuckDrawBean item, int position) {
            holder.setGlieuImage(R.id.iv_img,item.getUrl())
                    .setGlieuImage(R.id.iv_head,item.getHeadUrl())
                    .setText(R.id.tv_time,item.getTime())
                    .setText(R.id.tv_name,item.getName());
        }

        @Override
        protected int getItemViewLayoutId(int position, LuckDrawBean.OpenLuckDrawBean item) {
            return R.layout.item_open_luck;
        }
    }
}
