package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.YiMeiOrderDetailBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.TimeUtils;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class DaiPayActivity extends BaseActivity implements OrderPresenter.OrderDetailMedicalCall, OrderPresenter.PayPassCall ,OrderPresenter.OrderUpdateCall{

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
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;

    private long time;
    private String orderId;
    private OrderPresenter orderPresenter;
    private boolean isOverdue;
    private YiMeiOrderDetailBean yiMeiOrderDetailBean;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 10:
                    time -= 1000;
                    if (time < 0) {
                        orderPresenter.orderdetailmedical(orderId, DaiPayActivity.this);
                        tvTime.setText(formatCountDownTime(time));
                        timer.cancel();
                    } else {
                        tvTime.setText(formatCountDownTime(time));
                    }
                    break;
            }
        }
    };

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.sendEmptyMessage(10);
        }
    };

    private Timer timer;
    private boolean isFrist;

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, DaiPayActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_dai_pay;
    }

    @Override
    protected void setData() {
        tvTitle.setText("发起代付");
        ivBack.setVisibility(View.VISIBLE);
        orderId = getIntent().getStringExtra("orderId");
        orderPresenter = new OrderPresenter(this);
        showLoading("加载中..");
        orderPresenter.orderdetailmedical(orderId, this);

    }


    @OnClick({R.id.iv_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_confirm:
                if (isOverdue) {
                    PayDialogUtil.payDialogShow(this, new AlertEditTextDialog.ConfirmListenter() {
                        @Override
                        public void comfrim(String content) {
                            showLoading("支付中..");
                            orderPresenter.yzPass(content, DaiPayActivity.this);
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
            tvSubstitute.setText("代付金额");
            YiMeiOrderDetailBean.AgentPayInfo agentPayInfo = null;
            if (timer != null){
                timer.cancel();
                timer = null;
            }
            if (yiMeiOrderDetailBean.getOrder_State() == 0) {
                if (!TextUtils.isEmpty(yiMeiOrderDetailBean.getAgentPayInfo())) {
                    agentPayInfo = GsonUtil.changeGsonToBean(yiMeiOrderDetailBean.getAgentPayInfo(), YiMeiOrderDetailBean.AgentPayInfo.class);
                    if (agentPayInfo.getPayStatus() == 0) {

                        time = 30 * 60 * 1000 - (TimeUtils.string2Milliseconds(UserManage.getInstance().getServerTime())
                                - TimeUtils.string2Milliseconds(yiMeiOrderDetailBean.getOrder_CreateTime()));
                        tvTime.setText(formatCountDownTime(time));
                        if (time > 0) {
                            if (!isFrist) {
                                isFrist = true;
                                timer = new Timer();
                                timer.schedule(timerTask, 0, 1000);
                            }
                        }
                        btnConfirm.setText("慷慨付款");
                        btnConfirm.setVisibility(View.VISIBLE);
                    } else if (agentPayInfo.getPayStatus() == 1) {
                        tvTime.setText("订单代付已取消");
                        btnConfirm.setVisibility(View.GONE);
                    } else if (agentPayInfo.getPayStatus() == 2) {
                        tvTime.setText("订单已代付");
                        btnConfirm.setVisibility(View.GONE);
                    }
                    isOverdue = true;
                }
            } else if (yiMeiOrderDetailBean.getOrder_State() == 1) {
                tvTime.setText("订单已支付");
                btnConfirm.setVisibility(View.GONE);
                isOverdue = false;
            } else if (yiMeiOrderDetailBean.getOrder_State() == 4) {
                btnConfirm.setVisibility(View.GONE);
                tvTime.setText("订单已取消");
                isOverdue = false;
            }
        }
    }

    public String formatCountDownTime(long timeLeft) {
        timeLeft = timeLeft / 1000;
        String h, m, s;
        if (timeLeft < 0) {
            return "0时0分0秒自动取消订单";
        }
        DecimalFormat format = new DecimalFormat("00");
        h = format.format(timeLeft / 3600);
        m = format.format(timeLeft % 3600 / 60);
        s = format.format(timeLeft % 3600 % 60);
        return h + "时" + m + "分" + s + "秒自动取消订单";
    }


    @Override
    public void payPassBack() {
        orderPresenter.paymedicalorder(yiMeiOrderDetailBean.getOrder_ID(),this);
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        super.onDestroy();
    }

    @Override
    public void updateData() {
        orderPresenter.orderdetailmedical(orderId, this);
    }
}
