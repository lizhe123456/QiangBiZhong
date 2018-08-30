package com.whmnrc.qiangbizhong.ui.me.fragment.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.AgentShopBean;
import com.whmnrc.qiangbizhong.presenter.me.AgentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class GoodsInfoFragment extends BaseFragment implements AgentPresenter.AgentShopInfoCall{


    @BindView(R.id.tv_sorck)
    TextView tvSorck;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_zhe)
    TextView tvZhe;

    private AgentPresenter agentPresenter;

    public static GoodsInfoFragment newInstance() {
        Bundle args = new Bundle();
        GoodsInfoFragment fragment = new GoodsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_info;
    }

    @Override
    protected void initData() {
        agentPresenter = new AgentPresenter(getActivity());
        showLoading("加载中..");
        agentPresenter.getagentshopinfo(this);
    }

    @Override
    public void error() {

    }

    @Override
    public void AgentShopInfoaBack(AgentShopBean agentShopBean) {
        tvSorck.setText(agentShopBean.getStock()+"");
        tvPrice.setText("¥ "+agentShopBean.getPrice());
        tvZhe.setText(agentShopBean.getDiscount()+"折");
    }
}
