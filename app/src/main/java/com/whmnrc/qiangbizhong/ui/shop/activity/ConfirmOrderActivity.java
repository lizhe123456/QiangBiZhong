package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.util.GlideuUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class ConfirmOrderActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.iv_img)
    ImageView ivImg;

    private GoodsRushinfoBean goodsRushinfoBean;

    public static void start(Context context, GoodsRushinfoBean goodsRushinfoBean) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("goodsRushinfoBean", goodsRushinfoBean);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void setData() {
        goodsRushinfoBean = getIntent().getParcelableExtra("goodsRushinfoBean");
        GlideuUtil.loadImageView(this, goodsRushinfoBean.getRushGoodsInfo().getGoods_ImaPath(),ivImg);

        tvPrice.setText(String.valueOf(goodsRushinfoBean.getRushGoodsInfo().getPrice()));
        tvGoodsName.setText(goodsRushinfoBean.getRushGoodsInfo().getGoods_Name());
    }


    @OnClick({R.id.iv_back, R.id.tv_adress})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_adress:

                break;
        }
    }
}
