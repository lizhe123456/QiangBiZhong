package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AgentshopQueryTypeBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class RechargeCoreActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_stock)
    TextView tvStock;
    @BindView(R.id.et_recharge)
    EditText etRecharge;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_confirm_pay)
    TextView tvConfirmPay;

    private RechargeAdapter rechargeAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_recharge_core;
    }

    @Override
    protected void setData() {
        rvList.setLayoutManager(new LinearLayoutManager(this));

        rechargeAdapter = new RechargeAdapter(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_confirm_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm_pay:
                //确认

                break;
        }
    }

    public class RechargeAdapter extends BaseAdapter<AgentshopQueryTypeBean.ItemsBean>{

        public RechargeAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, AgentshopQueryTypeBean.ItemsBean item, int position) {
            holder.setText(R.id.tv_stock,item.getNumber() + "")
                    .setText(R.id.tv_old_price, item.getOldPrice() + "")
                    .setText(R.id.tv_price,item.getTotalPrice() + "");


        }

        @Override
        protected int getItemViewLayoutId(int position, AgentshopQueryTypeBean.ItemsBean item) {
            return R.layout.item_agent_recharge_list;
        }
    }

}
