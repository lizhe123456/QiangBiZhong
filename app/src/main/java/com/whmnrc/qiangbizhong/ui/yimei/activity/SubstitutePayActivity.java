package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.parameter.YiMeiOrderParam;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.presenter.yimei.SubstitutePresenter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.widget.YiMeiDialog;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 */

public class SubstitutePayActivity extends BaseActivity implements SubstitutePresenter.AgentUserIdCall,OrderPresenter.SubmitOrederCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_phone)
    EditText etPhone;

    private SubstitutePresenter substitutePresenter;
    private OrderPresenter orderPresenter;
    private YiMeiOrderParam yiMeiOrderParam;

    public static void start(Context context, YiMeiOrderParam yiMeiOrderParam,String price, String name) {
        Intent starter = new Intent(context, SubstitutePayActivity.class);
        starter.putExtra("goodsId", GsonUtil.createGsonString(yiMeiOrderParam));
        starter.putExtra("price",price);
        starter.putExtra("name",name);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_substitute_pay;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("发起代付");
        substitutePresenter = new SubstitutePresenter(this);
        orderPresenter = new OrderPresenter(this);
        yiMeiOrderParam = GsonUtil.changeGsonToBean(getIntent().getStringExtra("goodsId"),YiMeiOrderParam.class);
        tvPrice.setText(getIntent().getStringExtra("price"));
        tvName.setText(getIntent().getStringExtra("name"));
    }


    @OnClick({R.id.iv_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_confirm:
                //发起代付
                if (!RegexUtils.isMobileSimple(etPhone.getText().toString())) {
                    ToastUtils.showShort("手机号格式有误");
                    return;
                }
                showLoading("提交中..");
                substitutePresenter.getAgentUserId(etPhone.getText().toString(),this);
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void getAgentUserIdS(String userId) {
        yiMeiOrderParam.setAgentPayUserId(userId);
        showLoading("提交中..");
        orderPresenter.yiMeiOrder(yiMeiOrderParam,this);
    }

    @Override
    public void submitOrederBack() {
        YiMeiDialog yiMeiDialog = new YiMeiDialog(this);
        yiMeiDialog.show();
    }

    @Override
    public void recharge() {

    }
}
