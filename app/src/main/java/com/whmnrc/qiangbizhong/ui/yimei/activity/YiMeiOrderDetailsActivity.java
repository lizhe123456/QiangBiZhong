package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiOrderDetailBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.OrderDetailsActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.ShopOrderDetailActivity;
import com.whmnrc.qiangbizhong.ui.shopping.activity.EvaluateActivity;
import com.whmnrc.qiangbizhong.util.DateUtil;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.TimeUtils;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 */

public class YiMeiOrderDetailsActivity extends BaseActivity implements OrderPresenter.OrderDetailMedicalCall,
        OrderPresenter.OrderUpdateCall, OrderPresenter.CollectCall,OrderPresenter.PayPassCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.order_state)
    TextView orderState;
    @BindView(R.id.order_time)
    TextView orderTime;
    @BindView(R.id.ll_order_statu)
    LinearLayout llOrderStatu;
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
    @BindView(R.id.tv_volume_num)
    TextView tvVolumeNum;
    @BindView(R.id.iv_scan_ma)
    ImageView ivScanMa;
    @BindView(R.id.ll_volume)
    LinearLayout llVolume;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_item_0)
    TextView tvItem0;
    @BindView(R.id.tv_item_1)
    TextView tvItem1;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.tv_order_num_3)
    TextView tvOrderNum3;
    @BindView(R.id.tv_order_stu)
    TextView tvOrderStu;
    @BindView(R.id.tv_substitute)
    TextView tvSubstitute;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.ll_bottom_btn)
    LinearLayout llBottomBtn;

    private String orderId;
    private OrderPresenter orderPresenter;
    private YiMeiOrderDetailBean yiMeiOrderDetailBean;
    private long time;
    private boolean isFrist;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 10:
                    time -= 1000;
                    if (time < 0){
                        orderPresenter.orderdetailmedical(orderId,YiMeiOrderDetailsActivity.this);
                        orderTime.setText(formatCountDownTime(time));
                        timer.cancel();
                    }else {
                        orderTime.setText(formatCountDownTime(time));
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

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, YiMeiOrderDetailsActivity.class);
        starter.putExtra("orderId",orderId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_yimei_order_detail;
    }

    @Override
    protected void setData() {
        tvTitle.setText("订单详情");
        ivBack.setVisibility(View.VISIBLE);
        orderId = getIntent().getStringExtra("orderId");
        orderPresenter = new OrderPresenter(this);
        showLoading("加载中..");
        orderPresenter.orderdetailmedical(orderId,this);
        timer = new Timer();
    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void orderDetailMedical(YiMeiOrderDetailBean yiMeiOrderDetailBean) {
        this.yiMeiOrderDetailBean = yiMeiOrderDetailBean;
        tvGoodsDesc.setText(yiMeiOrderDetailBean.getDetail().get(0).getProduct_Name());
        tvPhone.setText(yiMeiOrderDetailBean.getUserInfo_Mobile());
        tvAddress.setText(yiMeiOrderDetailBean.getStoreAddress());
        tvStoreName.setText(yiMeiOrderDetailBean.getStoreName());
        tvId.setText(yiMeiOrderDetailBean.getUserInfo_NickName());
        //订单号
        tvItem0.setText(yiMeiOrderDetailBean.getOrder_No());
        //交易号
        tvItem1.setText(yiMeiOrderDetailBean.getOrder_PayNo());
        //下单时间
        tvOrderNum3.setText(yiMeiOrderDetailBean.getOrder_CreateTime());
        tvDesc.setText("数量：x"+yiMeiOrderDetailBean.getOrder_Number());
        tvMoeny.setText(yiMeiOrderDetailBean.getOrder_Money()+"");
        GlideuUtil.loadImageView(this,yiMeiOrderDetailBean.getDetail().get(0).getProduct_ImgPath(),ivGoods);

        if (yiMeiOrderDetailBean.getOrder_State() == -5){
            orderState.setText("您的订单正在退款中");
            tvOrderStu.setText("退款中");
            orderTime.setVisibility(View.GONE);
            //退款中
            tvPay.setVisibility(View.VISIBLE);

            tvPay.setText("取消退款");
            tvPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(YiMeiOrderDetailsActivity.this).builder()
                            .setTitle("提示")
                            .setMsg("确认要取消吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setPositiveButton("确认", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    orderPresenter.cannerrefund(yiMeiOrderDetailBean.getOrder_ID(),YiMeiOrderDetailsActivity.this);
                                }
                            }).show();
                }
            });
            llVolume.setVisibility(View.GONE);
        }else if (yiMeiOrderDetailBean.getOrder_State() == 0){
            orderState.setText("您的订单正在等待付款");
            tvOrderStu.setText("待付款");
            llVolume.setVisibility(View.GONE);
            time = 30 * 60 * 1000 - (TimeUtils.string2Milliseconds(UserManage.getInstance().getServerTime())
                    - TimeUtils.string2Milliseconds(yiMeiOrderDetailBean.getOrder_CreateTime()));
            orderTime.setText(formatCountDownTime(time));
            if (time > 0) {
                if (!isFrist) {
                    isFrist = true;
                    timer.schedule(timerTask, 0, 1000);
                }
            }
            //未支付
            tvSubstitute.setVisibility(View.VISIBLE);
            tvSubstitute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLoading("取消中..");
                    orderPresenter.canneragentpay(yiMeiOrderDetailBean.getOrder_ID(),YiMeiOrderDetailsActivity.this);
                }
            });
            tvCancel.setVisibility(View.VISIBLE);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLoading("取消中..");
                    orderPresenter.cannerorder(yiMeiOrderDetailBean.getOrder_ID(),YiMeiOrderDetailsActivity.this);
                }
            });
            tvPay.setVisibility(View.VISIBLE);
            tvPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PayDialogUtil.payDialogShow(YiMeiOrderDetailsActivity.this, new AlertEditTextDialog.ConfirmListenter() {
                        @Override
                        public void comfrim(String content) {
                            showLoading("支付中..");
                            orderPresenter.yzPass(content, YiMeiOrderDetailsActivity.this);
                        }
                    });

                }
            });
        }else if (yiMeiOrderDetailBean.getOrder_State() == 1){
            orderState.setText("您的订单已支付");
            tvOrderStu.setText("已支付");
            orderTime.setVisibility(View.GONE);

            tvVolumeNum.setText(yiMeiOrderDetailBean.getOrder_PayNo());
            byte [] input = Base64.decode(yiMeiOrderDetailBean.getQrCode(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(input, 0, input.length);
            ivScanMa.setImageBitmap(bitmap);
            //已支付
            tvPay.setVisibility(View.VISIBLE);
            tvPay.setText("申请退款");
            tvPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertEditTextDialog(YiMeiOrderDetailsActivity.this).builder().setTitle("是否确认申请退款")
                            .setTvFundZfPwd(false)
                            .setInputNume(20)
                            .setEidtMsg("请输入退款原因")
                            .setInputType(InputType.TYPE_CLASS_TEXT)
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setPositive1Button("确认", new AlertEditTextDialog.ConfirmListenter() {
                                @Override
                                public void comfrim(String content) {
                                    showLoading("退款中..");
                                    orderPresenter.submitrefund(yiMeiOrderDetailBean.getOrder_ID(),content,YiMeiOrderDetailsActivity.this);
                                }
                            }).show();
                }
            });

            if (TextUtils.isEmpty(yiMeiOrderDetailBean.getGiveRecordInfo().toString())) {
                tvCancel.setVisibility(View.VISIBLE);
                tvCancel.setText("赠送他人");
                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //赠送
                        GiveActivity.start(YiMeiOrderDetailsActivity.this, yiMeiOrderDetailBean.getDetail().get(0).getProduct_ImgPath(), yiMeiOrderDetailBean.getDetail().get(0).getProduct_Name(), StringUtil.weiString1(yiMeiOrderDetailBean.getOrder_Money()), yiMeiOrderDetailBean.getOrder_Number() + "", yiMeiOrderDetailBean.getUserInfo_ID(), yiMeiOrderDetailBean.getOrder_ID());
                    }
                });
            }
        }else if (yiMeiOrderDetailBean.getOrder_State() == 3){
            llVolume.setVisibility(View.GONE);
            orderState.setText("您的订单正在等待评价");
            tvOrderStu.setText("待评价");
            orderTime.setVisibility(View.GONE);
            //待评价
            tvPay.setVisibility(View.VISIBLE);

            tvPay.setText("去评价");
            tvPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderListBean orderListBean = new OrderListBean();
                    orderListBean.setDetail(yiMeiOrderDetailBean.getDetail());
                    EvaluateActivity.start(YiMeiOrderDetailsActivity.this,orderListBean);
                }
            });
        }else if (yiMeiOrderDetailBean.getOrder_State() == 4){
            orderState.setText("您的订单已取消");
            tvOrderStu.setText("已取消");
            orderTime.setVisibility(View.GONE);
            llVolume.setVisibility(View.GONE);
            //已取消
            llBottomBtn.setVisibility(View.GONE);
        }else if (yiMeiOrderDetailBean.getOrder_State() == 5){
            orderState.setText("您的订单已退款");
            tvOrderStu.setText("已退款");
            orderTime.setVisibility(View.GONE);
            //已退款
            llBottomBtn.setVisibility(View.GONE);
            llVolume.setVisibility(View.GONE);
        }else if (yiMeiOrderDetailBean.getOrder_State() == 10) {
            orderState.setText("您的订单已完成");
            tvOrderStu.setText("已完成");
            orderTime.setVisibility(View.GONE);
            //已完成
            llBottomBtn.setVisibility(View.GONE);
            llVolume.setVisibility(View.GONE);
        }
    }

    public String formatCountDownTime(long timeLeft) {
        timeLeft = timeLeft/1000;
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
    public void updateData() {
        orderPresenter.orderdetailmedical(orderId,this);
    }

    @Override
    public void collect() {
        orderPresenter.orderdetailmedical(orderId,this);
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    public void payPassBack() {
        showLoading("支付中..");
        orderPresenter.paymedicalorder(yiMeiOrderDetailBean.getOrder_ID());
    }
}
