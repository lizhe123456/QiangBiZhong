package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiOrderDetailBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class DaiPayActivity extends BaseActivity implements OrderPresenter.OrderDetailMedicalCall,OrderPresenter.PayPassCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_substitute)
    TextView tvSubstitute;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;

    private String orderId;
    private OrderPresenter orderPresenter;
    private boolean isOverdue;
    private YiMeiOrderDetailBean yiMeiOrderDetailBean;

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, DaiPayActivity.class);
        starter.putExtra("orderId",orderId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_dai_pay;
    }

    @Override
    protected void setData() {
        tvTitle.setText("找人代付");
        ivBack.setVisibility(View.VISIBLE);
        orderId = getIntent().getStringExtra("orderId");
        orderPresenter = new OrderPresenter(this);
        showLoading("加载中..");
        orderPresenter.orderdetailmedical(orderId,this);

    }


    @OnClick({R.id.iv_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_confirm:
                if (isOverdue){
                    PayDialogUtil.payDialogShow(this, new AlertEditTextDialog.ConfirmListenter() {
                        @Override
                        public void comfrim(String content) {
                            showLoading("支付中..");
                            orderPresenter.yzPass(content,DaiPayActivity.this);
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void orderDetailMedical(YiMeiOrderDetailBean yiMeiOrderDetailBean) {
        this.yiMeiOrderDetailBean = yiMeiOrderDetailBean;
        if (yiMeiOrderDetailBean != null) {
            tvPrice.setText((yiMeiOrderDetailBean.getOrder_Money() * yiMeiOrderDetailBean.getOrder_Number()) + "");
            tvStoreName.setText(yiMeiOrderDetailBean.getStoreName());
            tvGoodsName.setText(yiMeiOrderDetailBean.getDetail().get(0).getProduct_Name());
            tvName.setText(yiMeiOrderDetailBean.getDetail().get(0).getProduct_Name());
            tvUserName.setText(yiMeiOrderDetailBean.getUserInfo_NickName());
            if (yiMeiOrderDetailBean.getOrder_State() == 0) {
                btnConfirm.setText("慷慨付款");
                isOverdue = true;
            } else if (yiMeiOrderDetailBean.getOrder_State() == 1) {
                btnConfirm.setText("已支付");
                isOverdue = false;
            } else if (yiMeiOrderDetailBean.getOrder_State() == 4) {
                btnConfirm.setText("已取消");
                isOverdue = false;
            }
        }
    }

    @Override
    public void payPassBack() {
        orderPresenter.paymedicalorder(yiMeiOrderDetailBean.getOrder_ID());
    }
}
