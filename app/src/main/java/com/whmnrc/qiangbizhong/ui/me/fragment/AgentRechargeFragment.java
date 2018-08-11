package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AgentBean;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.RechargeCoreActivity;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 代理商充值
 */

public class AgentRechargeFragment extends BaseFragment implements RechargePresenter.AgentshopQueryCall,TextView.OnEditorActionListener{


    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.tv_sort)
    TextView tvSort;
    @BindView(R.id.tv_stock)
    TextView tvStock;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.iv_sort)
    ImageView ivSort;
    @BindView(R.id.iv_stock)
    ImageView ivStock;
    @BindView(R.id.iv_price)
    ImageView ivPrice;

    private RechargePresenter rechargePresenter;

    private String sortName;
    private String sortType;
    private String keyWord;
    private AgentRechargeAdapter agentRechargeAdapter;

    public static AgentRechargeFragment newInstance() {
        Bundle args = new Bundle();
        AgentRechargeFragment fragment = new AgentRechargeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_agent_recharge;
    }

    @Override
    protected void initData() {
        rechargePresenter = new RechargePresenter(getContext());
        rechargePresenter.agentshopQuery(sortName, sortType, keyWord, true, this);
        agentRechargeAdapter = new AgentRechargeAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(agentRechargeAdapter);
        refresh.setOnLoadMoreListener(refreshLayout -> {
            rechargePresenter.agentshopQuery(sortName, sortType, keyWord, false, this);
        });

        refresh.setOnRefreshListener(refreshLayout -> {
            rechargePresenter.agentshopQuery(sortName, sortType, keyWord, true, this);
        });

        etText.setOnEditorActionListener(this);
        agentRechargeAdapter.setAgentRechargeCall(new AgentRechargeCall() {
            @Override
            public void agentRecharge(AgentBean item) {
                RechargeCoreActivity.start(getContext(),item.getId());
            }
        });
        ivSort.setSelected(true);
        tvSort.setTextColor(getResources().getColor(R.color.colorAccent));
        ivStock.setSelected(false);
        tvStock.setTextColor(getResources().getColor(R.color.tv_191));
        ivPrice.setSelected(false);
        tvPrice.setTextColor(getResources().getColor(R.color.tv_191));
        sortName = "Sort";
        sortType = "asc";
        req();
    }


    @OnClick({R.id.ll_sort, R.id.ll_stock, R.id.ll_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_sort:
                ivSort.setSelected(true);
                tvSort.setTextColor(getResources().getColor(R.color.colorAccent));
                ivStock.setSelected(false);
                tvStock.setTextColor(getResources().getColor(R.color.tv_191));
                ivPrice.setSelected(false);
                tvPrice.setTextColor(getResources().getColor(R.color.tv_191));
                sortName = "Sort";
                sortType = "asc";
                break;
            case R.id.ll_stock:
                ivSort.setSelected(false);
                tvSort.setTextColor(getResources().getColor(R.color.tv_191));
                ivStock.setSelected(true);
                tvStock.setTextColor(getResources().getColor(R.color.colorAccent));
                ivPrice.setSelected(false);
                tvPrice.setTextColor(getResources().getColor(R.color.tv_191));
                sortName = "Stock";
                sortType = "desc";
                break;
            case R.id.ll_price:
                ivSort.setSelected(false);
                tvSort.setTextColor(getResources().getColor(R.color.tv_191));
                ivStock.setSelected(false);
                tvStock.setTextColor(getResources().getColor(R.color.tv_191));
                ivPrice.setSelected(true);
                tvPrice.setTextColor(getResources().getColor(R.color.colorAccent));
                sortName = "Price";
                sortType = "asc";
                break;
        }
        req();
    }

    public void req(){
        rechargePresenter.agentshopQuery(sortName, sortType, keyWord, true, this);
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
            textView.setText("");
            textView.setTextColor(getResources().getColor(R.color.tv_navigation));
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }


    @Override
    public void agentshopQuery(List<AgentBean> agentBeans) {
        if (agentBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        agentRechargeAdapter.addFirstDataSet(agentBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<AgentBean> agentBeans) {
        agentRechargeAdapter.addMoreDataSet(agentBeans);
        refresh.finishLoadMore(true);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            showLoading("加载中..");
            keyWord = etText.getText().toString();
            req();
            KeyboardUtils.hideSoftInput(getActivity());
            return true;
        }
        return false;
    }

    class AgentRechargeAdapter extends BaseAdapter<AgentBean>{

        private AgentRechargeCall agentRechargeCall;

        public AgentRechargeAdapter(Context context) {
            super(context);
        }

        public void setAgentRechargeCall(AgentRechargeCall agentRechargeCall) {
            this.agentRechargeCall = agentRechargeCall;
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, AgentBean item, int position) {
            holder.setText(R.id.tv_name,item.getAgentName())
                    .setText(R.id.tv_desc,"销量："+item.getSales())
                    .setText(R.id.tv_price,item.getStock()+"").setText(R.id.tv_buy,item.getDiscount()+"折")
                    .setGlieuImage(R.id.iv_img,item.getHeadImage());
            holder.setOnClickListener(R.id.tv_buy, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (agentRechargeCall != null){
                        agentRechargeCall.agentRecharge(item);
                    }
                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, AgentBean item) {
            return R.layout.item_agent_recharge;
        }
    }

    public interface AgentRechargeCall{

        void agentRecharge(AgentBean item);
    }


}
