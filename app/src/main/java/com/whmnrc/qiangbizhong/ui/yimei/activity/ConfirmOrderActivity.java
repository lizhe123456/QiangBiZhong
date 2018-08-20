package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.parameter.YiMeiOrderParam;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.PayStuActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
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
 * Created by lizhe on 2018/8/13.
 */

public class ConfirmOrderActivity extends BaseActivity implements OrderPresenter.SubmitOrederCall,OrderPresenter.PayPassCall{
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_now_moeny)
    LinearLayout llNowMoeny;
    @BindView(R.id.tv_edit_count)
    TextView tvEditCount;
    @BindView(R.id.tv_substitute)
    TextView tvSubstitute;
    @BindView(R.id.et_phone)
    TextView etPhone;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;
    @BindView(R.id.tv_tijiao)
    TextView tvTijiao;

    private YiMeiGoodsDetailBean yiMeiGoodsDetailBean;
    private OrderPresenter orderPresenter;
    private YiMeiOrderParam yiMeiOrderParam;

    private int count = 1;
    private boolean isSubstitute;
    private String agentPayUserId;

    public static void start(Context context, YiMeiGoodsDetailBean yiMeiGoodsDetailBean) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("goods", GsonUtil.createGsonString(yiMeiGoodsDetailBean));
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_order_yimei;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("确认订单");
        String data = getIntent().getStringExtra("goods");
        orderPresenter = new OrderPresenter(this);
        yiMeiOrderParam = new YiMeiOrderParam();
        yiMeiGoodsDetailBean = GsonUtil.changeGsonToBean(data,YiMeiGoodsDetailBean.class);
        if (yiMeiGoodsDetailBean != null) {
            GlideuUtil.loadImageView(this, yiMeiGoodsDetailBean.getGoods().getGoods_ImaPath(), ivImg);
        }

        tvGoodsName.setText(yiMeiGoodsDetailBean.getGoods().getGoods_Name());
        tvPrice.setText(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price()+"");
        tvYuyue.setText(""+(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price() * count));
        tvEditCount.setText("1");
    }

    public void submitOrder(){
        yiMeiOrderParam.setAddressId("");
//        yiMeiOrderParam.setAgentPayUserId();
        List<YiMeiOrderParam.GoodsPriceListBean> listBeans = new ArrayList<>();
        listBeans.add(new YiMeiOrderParam.GoodsPriceListBean(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_ID(),count));
        yiMeiOrderParam.setGoodsPriceList(listBeans);
        yiMeiOrderParam.setRemarksList(new ArrayList<>());
        if (isSubstitute) {
            yiMeiOrderParam.setIsAgentPay(1);
        }else {
            yiMeiOrderParam.setIsAgentPay(0);
        }
        if (!RegexUtils.isMobileSimple(etPhone.getText().toString())) {
            ToastUtils.showShort("手机号格式有误");
            return;
        }
        yiMeiOrderParam.setPhone(etPhone.getText().toString());
        yiMeiOrderParam.setUserId(UserManage.getInstance().getUserID());
        yiMeiOrderParam.setAgentPayUserId("");
        if (isSubstitute){
            //代付
//            跳转页面
            SubstitutePayActivity.start(this,yiMeiOrderParam,
                    ""+(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price() * count),yiMeiGoodsDetailBean.getGoods().getGoods_Name());
        }else {
            //自己支付
            //提交订单
            PayDialogUtil.payDialogShow(this, new AlertEditTextDialog.ConfirmListenter() {
                @Override
                public void comfrim(String content) {
                    showLoading("支付中..");
                    orderPresenter.yzPass(content, ConfirmOrderActivity.this);
                }
            });

        }

    }

    @OnClick({R.id.iv_back, R.id.tv_tijiao,R.id.tv_jia,R.id.tv_jian,R.id.tv_substitute})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_tijiao:
                submitOrder();
                break;
            case R.id.tv_jia:
                count++;
                tvEditCount.setText(count+"");
                tvYuyue.setText(""+(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price() * count));
                break;
            case R.id.tv_jian:
                if (count > 1) {
                    count--;
                    tvEditCount.setText(count + "");
                    tvYuyue.setText(""+(yiMeiGoodsDetailBean.getGoodsPrice().getGoodsPrice_Price() * count));
                }
                break;
            case R.id.tv_substitute:
                if (isSubstitute){
                    isSubstitute = false;
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvSubstitute.setCompoundDrawables(null, null, nav_up, null);
                }else {
                    isSubstitute = true;
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_select);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvSubstitute.setCompoundDrawables(null, null, nav_up, null);
                }
                break;
        }
    }

    @Override
    public void error() {
        this.finish();
        PayStuActivity.start(this,0);
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
                AccountRechargeActivity.start(ConfirmOrderActivity.this,1);
            }
        }).show();
    }

    @Override
    public void payPassBack() {
        showLoading("提交中..");
        orderPresenter.yiMeiOrder(yiMeiOrderParam,this);
    }
}
