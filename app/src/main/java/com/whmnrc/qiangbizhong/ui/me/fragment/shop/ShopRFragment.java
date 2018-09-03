package com.whmnrc.qiangbizhong.ui.me.fragment.shop;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AgentSalesRecordBean;
import com.whmnrc.qiangbizhong.presenter.me.AgentPresenter;
import com.whmnrc.qiangbizhong.util.StringUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class ShopRFragment extends BaseFragment implements AgentPresenter.AgentSalesRecordCall{


    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    private AgentPresenter agentPresenter;
    private RAdapter rAdapter;

    public static ShopRFragment newInstance() {
        Bundle args = new Bundle();
        ShopRFragment fragment = new ShopRFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_r;
    }

    @Override
    protected void initData() {
        agentPresenter = new AgentPresenter(getActivity());
        showLoading("加载中..");
        agentPresenter.getagentsalesrecord(true,this);
        rAdapter = new RAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(rAdapter);
        refresh.setOnRefreshListener(refreshLayout -> {
            agentPresenter.getagentsalesrecord(true,this);
        });

        refresh.setOnLoadMoreListener(refreshLayout -> {
            agentPresenter.getagentsalesrecord(false,this);
        });
    }


    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void AgentSalesRecordBack(AgentSalesRecordBean agentSalesRecordBean) {
        if (agentSalesRecordBean.getRecordList().size() == 0 ){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        tvOrder.setText(agentSalesRecordBean.getRecordList().size()+"个");
        tvPrice.setText("¥ "+ StringUtil.wanString(agentSalesRecordBean.getSumMoney()));
        rAdapter.addFirstDataSet(agentSalesRecordBean.getRecordList());
        refresh.finishRefresh(true);
    }


    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("");
            textView.setTextColor(getResources().getColor(R.color.tv_navigation));
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void loadMore(List<AgentSalesRecordBean.RecordListBean> recordListBeans) {
        rAdapter.addMoreDataSet(recordListBeans);
        refresh.finishLoadMore(true);
    }

    private class RAdapter extends BaseAdapter<AgentSalesRecordBean.RecordListBean>{

        public RAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, AgentSalesRecordBean.RecordListBean item, int position) {
            holder.setText(R.id.tv_item1,item.getRecordOrderId())
                    .setText(R.id.tv_item2,item.getCreateDate())
                    .setText(R.id.tv_item4,item.getUserInfo_NickName())
                    .setText(R.id.tv_item5,"￥"+item.getMoney()+"元")
                    .setText(R.id.tv_item6,item.getNumber()+"");
        }

        @Override
        protected int getItemViewLayoutId(int position, AgentSalesRecordBean.RecordListBean item) {
            return R.layout.item_shop_r;
        }
    }
}
