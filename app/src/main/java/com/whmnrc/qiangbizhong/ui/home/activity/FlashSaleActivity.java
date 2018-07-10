package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 限时特价
 */

public class FlashSaleActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_navigation)
    RecyclerView rvNavigation;
    @BindView(R.id.rv_renqi)
    RecyclerView rvRenqi;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;

    public static void start(Context context) {
        Intent starter = new Intent(context, FlashSaleActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_flash_sale;
    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
