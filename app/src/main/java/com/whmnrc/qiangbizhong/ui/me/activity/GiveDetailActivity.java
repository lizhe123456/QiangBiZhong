package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.GiveOrderDetailBean;
import com.whmnrc.qiangbizhong.presenter.me.GivePresenter;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsListActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiOrderDetailsActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class GiveDetailActivity extends BaseActivity implements GivePresenter.GiveOrderDetailCall {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_goods)
    ImageView ivGoods;
    @BindView(R.id.tv_goods_desc)
    TextView tvGoodsDesc;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.fl_moeny)
    LinearLayout flMoeny;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.iv_user_head_1)
    RoundedImageView ivUserHead1;
    @BindView(R.id.tv_name_1)
    TextView tvName1;
    @BindView(R.id.iv_user_head_2)
    RoundedImageView ivUserHead2;
    @BindView(R.id.tv_name_2)
    TextView tvName2;
    @BindView(R.id.tv_time_2)
    TextView tvTime2;
    @BindView(R.id.tv_time_1)
    TextView tvTime1;

    private GivePresenter givePresenter;
    private String orderId;
    private GiveOrderDetailBean giveOrderDetailBean;


    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, GiveDetailActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_give_detail;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("赠送记录");
        givePresenter = new GivePresenter(this);
        orderId = getIntent().getStringExtra("orderId");
        showLoading("加载中..");
        givePresenter.giveorderdetail(orderId, this);
    }

    @Override
    public void error() {

    }

    @Override
    public void getGiveOrderDetail(GiveOrderDetailBean giveOrderDetailBean) {
        this.giveOrderDetailBean = giveOrderDetailBean;
        GlideuUtil.loadImageView(this,giveOrderDetailBean.getGiveDetail().getGoods_ImaPath(),ivGoods);
        tvGoodsDesc.setText(giveOrderDetailBean.getGiveDetail().getGoods_Name());
        tvDesc.setText("数量：x"+giveOrderDetailBean.getOrderInfo().getOrder_Number());
        tvMoeny.setText(giveOrderDetailBean.getOrderInfo().getOrder_Money()+"");
        tvContent.setText(giveOrderDetailBean.getGiveDetail().getContext());
        GlideuUtil.loadImageView(this,giveOrderDetailBean.getGiveDetail().getFromGiveHead(),ivUserHead1);
        tvName1.setText(giveOrderDetailBean.getGiveDetail().getFromGiveNick());
        GlideuUtil.loadImageView(this,giveOrderDetailBean.getGiveDetail().getGiveUserHead(),ivUserHead2);
        tvName2.setText(giveOrderDetailBean.getGiveDetail().getGiveUserNick());
        tvTime2.setText(giveOrderDetailBean.getGiveDetail().getCreateDate());
        tvTime1.setText(giveOrderDetailBean.getGiveDetail().getCreateDate());

    }


    @OnClick({R.id.iv_back, R.id.iv_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_goods:
                if (giveOrderDetailBean != null) {
                    if (!giveOrderDetailBean.getGiveDetail().getFromUserId().equals(UserManage.getInstance().getUserID())) {
                        YiMeiOrderDetailsActivity.start(this, giveOrderDetailBean.getOrderInfo().getOrder_ID());
                    }
                }
                break;
        }
    }
}
