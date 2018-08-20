package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.model.bean.ShopDetailsBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.PayStuActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.bean.OrderBeanReq;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;
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
 * Created by lizhe on 2018/7/28.
 */


public class ShopConfirmOrderActivity extends BaseActivity implements OrderPresenter.PayPassCall,OrderPresenter.SubmitOrederCall,AddressPresenter.AddManageCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_address_more)
    TextView tvAddressMore;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;
    @BindView(R.id.id_select_address)
    RelativeLayout idSelectAddress;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.v_divider)
    View vDivider;
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTitle;
    @BindView(R.id.iv_img1)
    ImageView ivImg1;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_goods_spec)
    TextView tvGoodsSpec;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.tv_price1)
    TextView tvPrice1;
    @BindView(R.id.tv_num)
    TextView tvNum;

    private AddressBean addressBean;


    private OrderPresenter orderPresenter;
    private String desc;
    private ShopDetailsBean.StoreInfoBean storeInfoBean;
    private OrderBeanReq shopDetailsBean;
    private AddressPresenter addressPresenter;

    public static void start(Context context, OrderBeanReq orderBeanReq, ShopDetailsBean.StoreInfoBean storeInfoBean) {
        Intent starter = new Intent(context, ShopConfirmOrderActivity.class);
        starter.putExtra("orderBeanReq", JSON.toJSONString(orderBeanReq));
        starter.putExtra("storeInfoBean", JSON.toJSONString(storeInfoBean));
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_confirm_order_v2;
    }

    @Override
    protected void setData() {
        tvTitle.setText("确认订单");
        ivBack.setVisibility(View.VISIBLE);
        orderPresenter = new OrderPresenter(this);
        addressPresenter = new AddressPresenter(this);
        addressPresenter.getaddressList(this);
        shopDetailsBean = JSON.parseObject(getIntent().getStringExtra("orderBeanReq"), OrderBeanReq.class);
        storeInfoBean = JSON.parseObject(getIntent().getStringExtra("storeInfoBean"), ShopDetailsBean.StoreInfoBean.class);
        initGoods(shopDetailsBean);
    }

    private void initGoods(OrderBeanReq shopDetailsBean) {
        tvPrice.setText(StringUtil.weiString1(Double.parseDouble(shopDetailsBean.getPrice())));
        tvPrice1.setText(StringUtil.weiString1(Double.parseDouble(shopDetailsBean.getPrice())*shopDetailsBean.getCount()));
        tvYuyue.setText(StringUtil.weiString1(Double.parseDouble(shopDetailsBean.getPrice())*shopDetailsBean.getCount()));
        tvGoodsSpec.setText(shopDetailsBean.getSpec());
        tvGoodsName.setText(shopDetailsBean.getGoodsInfoBean().getGoods_Name());
        GlideuUtil.loadImageView(this, shopDetailsBean.getGoodsInfoBean().getGoods_ImaPath(), ivImg);
        tvCount.setText("x" + shopDetailsBean.getCount());
        etDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                desc = etDesc.getText().toString();
            }
        });
        tvOrderNum.setText(storeInfoBean.getStoreName());
        tvNum.setText("共计"+shopDetailsBean.getCount()+"件商品");
    }


    @OnClick({R.id.iv_back, R.id.tv_address_more, R.id.tv_tijiao, R.id.id_select_address, R.id.rl_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_address_more:
                SelectAddressActivity.start(this);
                break;
            case R.id.tv_tijiao:
                //提交订单
                PayDialogUtil.payDialogShow(this, new AlertEditTextDialog.ConfirmListenter() {
                    @Override
                    public void comfrim(String content) {
                        showLoading("支付中..");
                        orderPresenter.yzPass(content, ShopConfirmOrderActivity.this);
                    }
                });
                break;
            case R.id.id_select_address:
                SelectAddressActivity.start(this);
                break;
            case R.id.rl_address:
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
        this.finish();
        PayStuActivity.start(this,0);
    }

    @Override
    public void payPassBack() {
        if (addressBean != null) {
            showLoading("提交中..");
            List<com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.GoodsPriceListBean> list = new ArrayList<>();
            List<com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.RemarksListBean> list1 = new ArrayList<>();
            com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.GoodsPriceListBean goodsPriceList =
                    new com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.GoodsPriceListBean(shopDetailsBean.getPriceId(), shopDetailsBean.getCount());
            list.add(goodsPriceList);
            com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.RemarksListBean remarksList =
                    new com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter.RemarksListBean(storeInfoBean.getId(),desc);
            list1.add(remarksList);
            com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter parameter =
                    new com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity.Parameter(addressBean.getAddress_ID(),UserManage.getInstance().getUserID(),0,list,list1);
            orderPresenter.submitshoppingorder(parameter,ShopConfirmOrderActivity.this);
        } else {
            ToastUtils.showShort("请选择地址");
        }
    }



    @Override
    public void submitOrederBack() {
        this.finish();
        PayStuActivity.start(this,1);
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
}
