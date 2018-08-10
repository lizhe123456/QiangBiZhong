package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public abstract class BaseOrderFragment extends BaseFragment implements OrderPresenter.OrderCall{

    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;
    @BindView(R.id.refresh)
    protected SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    protected OrderAdapter mAdapter;
    protected OrderListBean orderBean;
    protected OrderPresenter orderPresenter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData() {
        initRecyclerView();
    }

    public void initRecyclerView() {
        orderPresenter = new OrderPresenter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = new OrderAdapter(this,isShop());
        recyclerView.setAdapter(mAdapter);
        setClick();
        getData(request(),true);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData(request(),true);
                refresh.finishRefresh(3000);
            }
        });

        refresh.setOnLoadMoreListener(refreshLayout -> {
            getData(request(),false);
            refresh.finishLoadMore(3000);
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            // 相当于onResume()方法--获取焦点
            if (orderPresenter != null){
                getData(request(),true);
            }
        }

    }

    public abstract void setClick();

    public abstract String request();

    public abstract boolean isShop();

    public void getData(String type, boolean isR){
        showLoading("加载中..");
        if (isShop()){
            orderPresenter.getShopOrderList(type+"",isR,this);
        }else {
            orderPresenter.getOrderList(type+"",isR,this);
        }

    }

    public void orderlistBack(List<OrderListBean> orderListBeans) {
        if (orderListBeans.size() == 0) {
            showEmpty();
            recyclerView.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        mAdapter.addFirstDataSet(orderListBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<OrderListBean> orderListBeans) {
        mAdapter.addMoreDataSet(orderListBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_order);
            textView.setText("暂无更多订单~");
            vsEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            if (resultCode == 102){
                refresh.autoRefresh();
            }
        }
    }
}
