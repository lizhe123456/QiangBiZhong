package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddressManageActivity extends BaseActivity implements AddressPresenter.AddManageCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    public static void start(Context context) {
        Intent starter = new Intent(context, AddressManageActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_address_manage;
    }

    @Override
    protected void setData() {
        tvMenu.setText("新增");
        tvMenu.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("收货地址管理");
        AddressPresenter addressPresenter = new AddressPresenter(this);
        addressPresenter.getaddressList(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                AddAddressActivity.start(this);
                break;
        }
    }

    @Override
    public void getAddressList(List<AddressBean> list) {

    }

    @Override
    public void deleteAddress() {

    }
}
