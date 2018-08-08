package com.whmnrc.qiangbizhong.ui.shopping.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.whmnrc.qiangbizhong.ui.StatusActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ConfirmOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.SelectAddressActivity;
import com.whmnrc.qiangbizhong.ui.shopping.adpter.ShopConfirmAdapter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

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
            List<GoodsPriceList> list = new ArrayList<>();
            List<RemarksList> list1 = new ArrayList<>();
            for (ShopCarBean shopCarBean : shopConfirmAdapter.getDataSource()) {
                for (ShopCarBean.GoodsBean goodsBean : shopCarBean.getGoods()) {
                    GoodsPriceList goodsPriceList = new GoodsPriceList(goodsBean.getGoodsPrice_ID(), goodsBean.getBuyCar_Num());
                    list.add(goodsPriceList);
                }
                RemarksList remarksList = new RemarksList(shopCarBean.getStoreId(),shopCarBean.getEtDsec());
                list1.add(remarksList);
            }
            Parameter parameter = new Parameter(addressBean.getAddress_ID(),list,list1, UserManage.getInstance().getUserID(),0);
            orderPresenter.submitshoppingorder(parameter,this);
        } else {
            ToastUtils.showShort("请选择地址");
        }
    }


    @Override
    public void submitOrederBack() {
//        StatusActivity.start(this,R.id.s);
        MyOrderActivity.start(this,0);
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
        String AddressId;
        List<GoodsPriceList> GoodsPriceList;
        List<RemarksList> RemarksList;
        String UserId;
        int IsAgentPay;

        public Parameter(String addressId, List<ShopConfirmOrderActivity.GoodsPriceList> goodsPriceList, List<ShopConfirmOrderActivity.RemarksList> remarksList, String userId, int IsAgentPay) {
            AddressId = addressId;
            GoodsPriceList = goodsPriceList;
            RemarksList = remarksList;
            UserId = userId;
            this.IsAgentPay = IsAgentPay;
        }

        public String getAddressId() {
            return AddressId;
        }

        public void setAddressId(String addressId) {
            AddressId = addressId;
        }

        public List<ShopConfirmOrderActivity.GoodsPriceList> getGoodsPriceList() {
            return GoodsPriceList;
        }

        public void setGoodsPriceList(List<ShopConfirmOrderActivity.GoodsPriceList> goodsPriceList) {
            GoodsPriceList = goodsPriceList;
        }

        public List<ShopConfirmOrderActivity.RemarksList> getRemarksList() {
            return RemarksList;
        }

        public void setRemarksList(List<ShopConfirmOrderActivity.RemarksList> remarksList) {
            RemarksList = remarksList;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }
    }

    public static class RemarksList {
        String key;
        String value;

        public RemarksList(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class GoodsPriceList {
        String key;
        int value;

        public GoodsPriceList(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
