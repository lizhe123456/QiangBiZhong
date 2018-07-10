package com.whmnrc.qiangbizhong.ui.shopping;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.ui.shopping.adpter.ShopCarAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class ShopCarFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_all_select)
    TextView tvAllSelect;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.ll_total)
    LinearLayout llTotal;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;

    private List<ShopCarBean> shopCarBeans;
    private ShopCarAdapter shopCarAdapter;

    public static ShopCarFragment newInstance() {
        Bundle args = new Bundle();
        ShopCarFragment fragment = new ShopCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_car;
    }

    @Override
    protected void initData() {
        tvTitle.setText("购物车");
        ShopCarBean shopCarBean = new ShopCarBean();
        shopCarBean.initShopCar();
        shopCarBeans = shopCarBean.getList();
        rvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        shopCarAdapter = new ShopCarAdapter(getContext());
        rvGoodsList.setAdapter(shopCarAdapter);
        shopCarAdapter.addFirstDataSet(shopCarBeans);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @OnClick({R.id.tv_all_select, R.id.tv_collection, R.id.tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_all_select:
                break;
            case R.id.tv_collection:
                break;
            case R.id.tv_delete:
                break;
        }
    }
}
