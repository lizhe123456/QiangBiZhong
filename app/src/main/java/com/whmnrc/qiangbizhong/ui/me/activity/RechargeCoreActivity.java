package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AgentshopQueryTypeBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeCoreBean;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.OpenVipFragment;
import com.whmnrc.qiangbizhong.util.PwdCheckUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class RechargeCoreActivity extends BaseActivity implements RechargePresenter.QuerytypeListCall,RechargePresenter.RechargeCall{

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
    private String id;
    private RechargePresenter rechargePresenter;
    private RechargeCoreBean rechargeCoreBean;

    public static void start(Context context,String id) {
        Intent starter = new Intent(context, RechargeCoreActivity.class);
        starter.putExtra("id",id);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_recharge_core;
    }

    @Override
    protected void setData() {
        tvTitle.setText("充值中心");
        ivBack.setVisibility(View.VISIBLE);
        id = getIntent().getStringExtra("id");
        rechargePresenter = new RechargePresenter(this);
        rechargePresenter.querytype(id,this);
        rvList.setLayoutManager(new GridLayoutManager(this,3));
        rechargeAdapter = new RechargeAdapter(this);
        rvList.setAdapter(rechargeAdapter);
        rechargeAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                for (RechargeCoreBean.ItemsBean itemsBean : rechargeAdapter.getDataSource()) {
                    itemsBean.setSelect(false);
                }
                rechargeAdapter.getDataSource().get(position).setSelect(true);
                rechargeAdapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_confirm_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm_pay:
                //确认
                if (!PwdCheckUtil.isNumber(etRecharge)){
                    ToastUtils.showShort("输入格式有误");
                    return;
                }

                if (Integer.parseInt(etRecharge.getText().toString()) > 0){
                    ToastUtils.showShort("购买数量不能为0");
                    return;
                }
                String agentShopDiscountId = "";
                String agentshopId = "";

                if (rechargeCoreBean != null){
                    if (rechargeCoreBean.getAgentShopInfo() != null){
                        for (RechargeCoreBean.ItemsBean itemsBean : rechargeAdapter.getDataSource()) {
                            if (itemsBean.isSelect()){
                                agentShopDiscountId = itemsBean.getId();
                                agentshopId = itemsBean.getAgentShopId();
                            }
                        }
                    }
                }

                if (TextUtils.isEmpty(agentShopDiscountId)){
                    ToastUtils.showShort("未选择购买商品");
                    return;
                }

                if (TextUtils.isEmpty(agentshopId)){
                    ToastUtils.showShort("未选择购买商品");
                    return;
                }
                showLoading("购买中..");
                rechargePresenter.submitorder(etRecharge.getText().toString().trim(),"0",agentshopId,agentShopDiscountId,this);
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void querytype(RechargeCoreBean rechargeCoreBean) {
        this.rechargeCoreBean = rechargeCoreBean;
        if (rechargeCoreBean.getAgentShopInfo() != null){
            tvPrice.setText("¥"+rechargeCoreBean.getAgentShopInfo().getPrice() + "");
            tvStock.setText(rechargeCoreBean.getAgentShopInfo().getStock() + "");
        }
        if ( rechargeCoreBean.getItems().size() > 0) {
            rechargeCoreBean.getItems().get(0).setSelect(true);
        }
        rechargeAdapter.addFirstDataSet(rechargeCoreBean.getItems());
    }

    @Override
    public void rechargeBack() {

    }

    @Override
    public void rechargeData(RechargeBean rechargeBean) {

    }

    @Override
    public void payS(String data) {
        AliPayTools.aliSignPay(this, data, new OnSuccessAndErrorListener() {
            @Override
            public void onSuccess(String s) {
                ToastUtils.showShort("充值成功");
                rechargePresenter.rechargeQuery(1, RechargeCoreActivity.this);
            }

            @Override
            public void onError(String s) {
                rechargePresenter.rechargeQuery(1, RechargeCoreActivity.this);
                ToastUtils.showShort("充值失败");
            }
        });
    }

    public class RechargeAdapter extends BaseAdapter<RechargeCoreBean.ItemsBean>{

        public RechargeAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, RechargeCoreBean.ItemsBean item, int position) {
            LinearLayout linearLayout = holder.getView(R.id.ll_bg);
            if (item.isSelect()){
                linearLayout.setSelected(true);
                holder.setText(R.id.tv_stock,item.getNumber() + "").setTextColor(R.id.tv_stock,R.color.white)
                        .setText(R.id.tv_old_price, "¥"+item.getOldPrice() + "").setTextColor(R.id.tv_old_price,R.color.white)
                        .setText(R.id.tv_price,"¥"+item.getTotalPrice() + "").setTextColor(R.id.tv_price,R.color.white);
                holder.setBackgroundColor(R.id.tv_xian,R.color.white);
                holder.setImageResource(R.id.iv_img,R.drawable.ic_white_dou);
            }else {
                linearLayout.setSelected(false);
                holder.setText(R.id.tv_stock,item.getNumber() + "").setTextColor(R.id.tv_old_price,R.color.colorAccent)
                        .setText(R.id.tv_old_price, "¥"+item.getOldPrice() + "").setTextColor(R.id.tv_old_price,R.color.tv_navigation)
                        .setText(R.id.tv_price,"¥"+item.getTotalPrice() + "").setTextColor(R.id.tv_price,R.color.colorAccent);
                holder.setBackgroundColor(R.id.tv_xian,R.color.tv_navigation);
                holder.setImageResource(R.id.iv_img,R.drawable.ic_yudou);
            }

            TextView textView = holder.getView(R.id.tv_old_price);

            textView.getPaint().setAntiAlias(true);//抗锯齿
            textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);  // 设置中划线并加清晰

        }

        @Override
        protected int getItemViewLayoutId(int position, RechargeCoreBean.ItemsBean item) {
            return R.layout.item_agent_recharge_list;
        }
    }

}
