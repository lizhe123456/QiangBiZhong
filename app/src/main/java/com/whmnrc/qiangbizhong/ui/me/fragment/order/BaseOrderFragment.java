package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;

import butterknife.BindView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public abstract class BaseOrderFragment extends BaseFragment{

    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;
    @BindView(R.id.refresh)
    protected SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    protected OrderAdapter mAdapter;
    protected OrderListBean orderBean;

    @Override
    protected int setLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData() {
        initRecyclerView();
    }

    public void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = new OrderAdapter(getContext());
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



    public abstract void setClick();

    public abstract int request();

    public void getData(int type, boolean isR){

    }



    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
//            TextView textView = view.findViewById(R.id.tv_empty_msg);
//            imageView.setImageResource(R.drawable.order_empty);
//            textView.setText("暂无更多订单~");
        }
    }
}
