package com.whmnrc.qiangbizhong.ui.shopping.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.SelectAddressActivity;
import com.whmnrc.qiangbizhong.ui.shopping.adpter.ShopConfirmAdapter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商城确认订单
 */

public class ShopConfirmOrderActivity extends BaseActivity implements AddressPresenter.AddManageCall
        ,OrderPresenter.PayPassCall,OrderPresenter.SubmitOrederCall {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_address_more)
    TextView tvAddressMore;
    @BindView(R.id.id_select_address)
    RelativeLayout idSelectAddress;
    @BindView(R.id.iv_img1)
    ImageView ivImg1;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.rv_shop)
    RecyclerView rvShop;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;
    @BindView(R.id.tv_tijiao)
    TextView tvTijiao;
    private List<ShopCarBean> shopCarBeans;

    private ShopConfirmAdapter shopConfirmAdapter;
    private AddressPresenter addressPresenter;
    private OrderPresenter orderPresenter;
    private AddressBean addressBean;



    public static void start(Context context, List<ShopCarBean> shopCarBeans, String hej) {
        Intent starter = new Intent(context, ShopConfirmOrderActivity.class);
        starter.putExtra("goodsData", GsonUtil.createGsonString(shopCarBeans));
        starter.putExtra("hej",hej);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_shop_confirm_order;
    }

    @Override
    protected void setData() {
        tvTitle.setText("确认订单");
        ivBack.setVisibility(View.VISIBLE);
        showLoading("加载中..");
        shopCarBeans = GsonUtil.changeGsonToList(getIntent().getStringExtra("goodsData"), ShopCarBean.class);
        String hej = getIntent().getStringExtra("hej");
        shopConfirmAdapter = new ShopConfirmAdapter(this);
        orderPresenter = new OrderPresenter(this);
        rvShop.setLayoutManager(new LinearLayoutManager(this));
        rvShop.setAdapter(shopConfirmAdapter);

        shopConfirmAdapter.addFirstDataSet(shopCarBeans);
        tvYuyue.setText(hej);
        addressPresenter = new AddressPresenter(this);
        addressPresenter.getaddressList(this);

    }


    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_tijiao,R.id.id_select_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.rl_address:
                SelectAddressActivity.start(this);
                break;
            case R.id.tv_tijiao:
                //提交订单
                    PayDialogUtil.payDialogShow(this, new AlertEditTextDialog.ConfirmListenter() {
                        @Override
                        public void comfrim(String content) {
                            showLoading("支付中..");
                            orderPresenter.yzPass(content,ShopConfirmOrderActivity.this);
                        }
                    });
                break;
            case R.id.id_select_address:
                SelectAddressActivity.start(this);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102) {
            if (resultCode == 101) {
                addressBean = data.getParcelableExtra("address");
                if (addressBean != null) {
                    tvAddress.setText(addressBean.getProviceName() + addressBean.getCityName() + addressBean.getRegionName() + addressBean.getAddress_Detail());
                    tvPhone.setText(addressBean.getAddress_Mobile());
                    tvName.setText(addressBean.getAddress_Name());
                    idSelectAddress.setVisibility(View.GONE);
                    rlAddress.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    @Override
    public void error() {

    }

    @Override
    public void getAddressList(List<AddressBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAddress_IsDefault() == 1){
                addressBean = list.get(i);
            }
        }
        if (addressBean != null) {
            tvAddress.setText(addressBean.getProviceName() + addressBean.getCityName() + addressBean.getRegionName() + addressBean.getAddress_Detail());
            tvPhone.setText(addressBean.getAddress_Mobile());
            tvName.setText(addressBean.getAddress_Name());
            idSelectAddress.setVisibility(View.GONE);
            rlAddress.setVisibility(View.VISIBLE);
        }else {
            idSelectAddress.setVisibility(View.VISIBLE);
            rlAddress.setVisibility(View.GONE);
        }
    }

    @Override
    public void updateData() {

    }

    @Override
    public void payPassBack() {
        if (addressBean != null) {
            showLoading("提交中..");
            List<Parameter.GoodsPriceListBean> list = new ArrayList<>();
            List<Parameter.RemarksListBean> list1 = new ArrayList<>();
            for (ShopCarBean shopCarBean : shopConfirmAdapter.getDataSource()) {
                for (ShopCarBean.GoodsBean goodsBean : shopCarBean.getGoods()) {
                    Parameter.GoodsPriceListBean goodsPriceList = new Parameter.GoodsPriceListBean(goodsBean.getGoodsPrice_ID(), goodsBean.getBuyCar_Num());
                    list.add(goodsPriceList);
                }
                Parameter.RemarksListBean remarksList = new Parameter.RemarksListBean(shopCarBean.getStoreId(),shopCarBean.getEtDsec());
                list1.add(remarksList);
            }
            Parameter parameter = new Parameter(addressBean.getAddress_ID(),UserManage.getInstance().getUserID(),0,list,list1);
            orderPresenter.submitshoppingorder(parameter,this);
        } else {
            ToastUtils.showShort("请选择地址");
        }
    }


    @Override
    public void submitOrederBack() {
//        StatusActivity.start(this,R.id.s);
        MyOrderActivity.start(this,0);
        this.finish();
    }

    @Override
    public void recharge() {
        new AlertDialog(this).builder()
                .setTitle("提示")
                .setMsg("余额不足,请充值！")
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountRechargeActivity.start(ShopConfirmOrderActivity.this,1);
            }
        }).show();
    }

    public static class Parameter{

        /**
         * AddressId : string
         * GoodsPriceList : [{"Key":"string","Value":0}]
         * RemarksList : [{"Key":"string","Value":"string"}]
         * UserId : string
         * IsAgentPay : 0
         * AgentPayUserId : string
         */

        private String AddressId;
        private String UserId;
        private int IsAgentPay;
        private String AgentPayUserId;
        private List<GoodsPriceListBean> GoodsPriceList;
        private List<RemarksListBean> RemarksList;

        public Parameter(String addressId, String userId, int isAgentPay , List<GoodsPriceListBean> goodsPriceList, List<RemarksListBean> remarksList) {
            AddressId = addressId;
            UserId = userId;
            IsAgentPay = isAgentPay;
            GoodsPriceList = goodsPriceList;
            RemarksList = remarksList;
        }

        public Parameter(String addressId, String userId, int isAgentPay, String agentPayUserId, List<GoodsPriceListBean> goodsPriceList, List<RemarksListBean> remarksList) {
            AddressId = addressId;
            UserId = userId;
            IsAgentPay = isAgentPay;
            AgentPayUserId = agentPayUserId;
            GoodsPriceList = goodsPriceList;
            RemarksList = remarksList;
        }

        public String getAddressId() {
            return AddressId;
        }

        public void setAddressId(String AddressId) {
            this.AddressId = AddressId;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public int getIsAgentPay() {
            return IsAgentPay;
        }

        public void setIsAgentPay(int IsAgentPay) {
            this.IsAgentPay = IsAgentPay;
        }

        public String getAgentPayUserId() {
            return AgentPayUserId;
        }

        public void setAgentPayUserId(String AgentPayUserId) {
            this.AgentPayUserId = AgentPayUserId;
        }

        public List<GoodsPriceListBean> getGoodsPriceList() {
            return GoodsPriceList;
        }

        public void setGoodsPriceList(List<GoodsPriceListBean> GoodsPriceList) {
            this.GoodsPriceList = GoodsPriceList;
        }

        public List<RemarksListBean> getRemarksList() {
            return RemarksList;
        }

        public void setRemarksList(List<RemarksListBean> RemarksList) {
            this.RemarksList = RemarksList;
        }

        public static class GoodsPriceListBean {

            public GoodsPriceListBean(String key, int value) {
                Key = key;
                Value = value;
            }

            /**
             * Key : string
             * Value : 0
             */

            private String Key;
            private int Value;

            public String getKey() {
                return Key;
            }

            public void setKey(String Key) {
                this.Key = Key;
            }

            public int getValue() {
                return Value;
            }

            public void setValue(int Value) {
                this.Value = Value;
            }
        }

        public static class RemarksListBean {
            /**
             * Key : string
             * Value : string
             */

            private String Key;
            private String Value;

            public RemarksListBean(String key, String value) {
                Key = key;
                Value = value;
            }

            public String getKey() {
                return Key;
            }

            public void setKey(String Key) {
                this.Key = Key;
            }

            public String getValue() {
                return Value;
            }

            public void setValue(String Value) {
                this.Value = Value;
            }
        }
    }
}
