package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.presenter.yimei.SubstitutePresenter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.SoftHideKeyBoardUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 * 赠送
 */

public class GiveActivity extends BaseActivity implements SubstitutePresenter.AgentUserIdCall{

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
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.fl_moeny)
    LinearLayout flMoeny;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.bsv_view)
    NestedScrollView scrollView;
    @BindView(R.id.main)
    LinearLayout main;


    private SubstitutePresenter substitutePresenter;
    private OrderPresenter orderPresenter;

    private String userId;
    private String orderId;

    public static void start(Context context, String img,String name,String price, String num,String userId, String orderId) {
        Intent starter = new Intent(context, GiveActivity.class);
        starter.putExtra("img", img);
        starter.putExtra("name", name);
        starter.putExtra("price", price);
        starter.putExtra("num", num);
        starter.putExtra("userId",userId);
        starter.putExtra("orderId",orderId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_give;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("赠送礼物");
        substitutePresenter = new SubstitutePresenter(this);
        orderPresenter = new OrderPresenter(this);
        userId = getIntent().getStringExtra("userId");
        orderId = getIntent().getStringExtra("orderId");
        String img = getIntent().getStringExtra("img");
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String num = getIntent().getStringExtra("num");
        GlideuUtil.loadImageView(this,img,ivGoods);
        tvGoodsDesc.setText(name);
        tvDesc.setText("数量：x"+num);
        tvMoeny.setText(price);
        etDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvCount.setText(String.valueOf(etDesc.getText().length())+"/140字");
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_confirm:
                if (TextUtils.isEmpty(etDesc.getText().toString())){
                    ToastUtils.showShort("请输入赠送备注");
                    return;
                }
                if (!RegexUtils.isMobileSimple(etId.getText().toString())) {
                    ToastUtils.showShort("手机号格式有误");
                    return;
                }
                showLoading("提交中..");
                substitutePresenter.getAgentUserId(etId.getText().toString(),this);
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void getAgentUserIdS(String userId) {
        showLoading("提交中..");
        orderPresenter.giveorder(orderId,userId,etDesc.getText().toString());
    }
}
