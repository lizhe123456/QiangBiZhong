package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ShopConfirmOrderAdapter;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/28.
 */


public class ShopConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_address_more)
    TextView tvAddressMore;
    @BindView(R.id.rv_shop)
    RecyclerView rvShop;
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

    private AddressBean addressBean;

    private ShopConfirmOrderAdapter shopConfirmOrderAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_confirm_order;
    }

    @Override
    protected void setData() {
        tvTitle.setText("确认订单");
        ivBack.setVisibility(View.VISIBLE);
        shopConfirmOrderAdapter = new ShopConfirmOrderAdapter(this);
        rvShop.setLayoutManager(new LinearLayoutManager(this));
        rvShop.setAdapter(shopConfirmOrderAdapter);
    }


    @OnClick({R.id.iv_back, R.id.tv_address_more, R.id.tv_tijiao,R.id.id_select_address, R.id.rl_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_address_more:
                SelectAddressActivity.start(this);
                break;
            case R.id.tv_tijiao:
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



}
