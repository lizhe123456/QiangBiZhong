package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.model.bean.OrderdetailBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order2Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OrderGoodsAdapter;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopsListActivity;
import com.whmnrc.qiangbizhong.ui.shopping.activity.EvaluateActivity;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/3.
 */

public class OrderDetailsActivity extends BaseActivity implements OrderPresenter.OrderDetailCall,
        OrderPresenter.CancelCall, OrderPresenter.CollectCall, OrderPresenter.PayBackS, OrderPresenter.PayPassCall, OrderPresenter.OrderUpdateCall {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.order_state)
    TextView orderState;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.xian)
    View xian;
    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.ll_btn)
    LinearLayout llBtn;
    @BindView(R.id.tv_item_0)
    TextView tvItem0;
    @BindView(R.id.tv_item_1)
    TextView tvItem1;
    @BindView(R.id.tv_order_num_2)
    TextView tvOrderNum2;
    @BindView(R.id.tv_order_num_3)
    TextView tvOrderNum3;
    @BindView(R.id.tv_btn)
    TextView tvBtn;
    @BindView(R.id.ll_btn_1)
    LinearLayout llBtn_1;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_order_user)
    TextView tvOrderUser;
    @BindView(R.id.tv_order_phone)
    TextView tvOrderPhone;

    private OrderPresenter orderPresenter;
    private String orderId;
    private OrderGoodsAdapter orderGoodsAdapter;

    public static void start(Fragment context, String orderId) {
        Intent starter = new Intent(context.getContext(), OrderDetailsActivity.class);
        starter.putExtra("orderId",orderId);
        context.startActivityForResult(starter,101);
    }
    @Override
    protected int setLayout() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void setData() {
        tvTitle.setText("订单详情");
        ivBack.setVisibility(View.VISIBLE);
        orderPresenter = new OrderPresenter(this);
        orderId = getIntent().getStringExtra("orderId");
        showLoading("加载中..");
        orderPresenter.orderdetail(orderId,this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGoodsList.setLayoutManager(layoutManager);

    }


    @OnClick({R.id.iv_back, R.id.order_state, R.id.tv_order_num, R.id.tv_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.order_state:
                break;
            case R.id.tv_order_num:
                if (orderdetailBean != null) {
                    ShopsListActivity.start(this, orderdetailBean.getOrder_StoreId());
                }
                break;
            case R.id.tv_btn:
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            if (resultCode == 102){
                orderPresenter.orderdetail(orderId,this);
            }
        }
    }


    OrderdetailBean orderdetailBean;

    @Override
    public void orderDetail(OrderdetailBean orderdetailBean) {
        this.orderdetailBean = orderdetailBean;
        orderGoodsAdapter = new OrderGoodsAdapter(this,orderdetailBean.getOrder_CreateType());

        rvGoodsList.setAdapter(orderGoodsAdapter);
        orderGoodsAdapter.addFirstDataSet(orderdetailBean.getDetail());
        tvItem0.setText(orderdetailBean.getOrder_No());
        tvItem1.setText(orderdetailBean.getOrder_PayNo());
        tvOrderNum2.setText(orderdetailBean.getOrder_CreateTime());
        tvOrderNum3.setText(orderdetailBean.getOrder_WaybillNumber() == null ? "" : orderdetailBean.getOrder_WaybillNumber() + "(" + orderdetailBean.getOrder_WaybillCompany() + ")");
        tvOrderUser.setText(orderdetailBean.getUserInfo_NickName());
        tvOrderPhone.setText(orderdetailBean.getAddress_Mobile());

        int num = 0;
        double moeny = 0;
        for (OrderListBean.DetailBean detailBean :orderdetailBean.getDetail()) {
            num += detailBean.getOrderItem_Number();
            moeny += detailBean.getSpecAttr_Price() * (double)detailBean.getOrderItem_Number();
        }

        tvMoeny.setText(moeny+"");
        tvNum.setText("共"+num+"件商品");
        tvOrderNum.setText(orderdetailBean.getStoreName());
        if (orderdetailBean.getOrder_State() == -5){
            orderState.setText("您的订单正在退款中");
            tvBtn.setText("取消退款");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(OrderDetailsActivity.this).builder()
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
                                    orderPresenter.cannerrefund(orderdetailBean.getOrder_ID(),OrderDetailsActivity.this);
                                }
                            }).show();

                }
            });

        }else if (orderdetailBean.getOrder_State() == 0){
            //0未支付

        }else if (orderdetailBean.getOrder_State() == 1){
            //1已支付
            orderState.setText("您的订单等待发货");
            tvBtn.setText("申请退款");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertEditTextDialog(OrderDetailsActivity.this).builder().setTitle("是否确认申请退款")
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
                                    orderPresenter.submitrefund(orderdetailBean.getOrder_ID(),content,OrderDetailsActivity.this);
                                }
                            }).show();
            }
            });
        }else if (orderdetailBean.getOrder_State() == 2){
            //2待收货
            orderState.setText("您的订单等待收货");
            tvBtn.setText("确认收货");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(OrderDetailsActivity.this).builder()
                            .setTitle("提示")
                            .setMsg("确定要收货吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).setNegativeButton("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View sweetAlertDialog) {
                            showLoading("收货中..");
                            orderPresenter.collectgoods(orderdetailBean.getOrder_ID(), OrderDetailsActivity.this);
                        }
                    }).show();
                }
            });
        }else if (orderdetailBean.getOrder_State() == 3){
            //待评价
            orderState.setText("您的订单等待评价");
            tvBtn.setText("去评价");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderListBean orderListBean = new OrderListBean();
                    orderListBean.setDetail(orderdetailBean.getDetail());
                    EvaluateActivity.start(OrderDetailsActivity.this,orderListBean);
                }
            });

        }else if (orderdetailBean.getOrder_State() == 4){
            //已取消
            orderState.setText("您的订单已取消");
            llBtn_1.setVisibility(View.GONE);
        }else if (orderdetailBean.getOrder_State() == 5){
            //已退款
            orderState.setText("您的订单已退款");
            llBtn_1.setVisibility(View.GONE);
        }else if (orderdetailBean.getOrder_State() == 6){
            //6抢购成功

        }else if (orderdetailBean.getOrder_State() == 7){
            //6抢购失败

        }else if (orderdetailBean.getOrder_State() == 8){
            //7已中奖

        }else if (orderdetailBean.getOrder_State() == 9){
            //8未中奖

        }else if (orderdetailBean.getOrder_State() == 10){
            //已完成
            orderState.setText("您的订单已完成");
            llBtn_1.setVisibility(View.GONE);
        }

        if (orderdetailBean.getOrder_CreateType() == 0) {

        }else if (orderdetailBean.getOrder_CreateType() == 3){

        }


    }

    @Override
    public void payPassBack() {
        setResult(102);
        finish();
    }

    @Override
    public void updateData() {
        setResult(102);
        finish();
    }

    @Override
    public void cancelS() {
        setResult(102);
        finish();
    }

    @Override
    public void collect() {
        setResult(102);
        finish();
    }

    @Override
    public void payS() {
        setResult(102);
        finish();
    }

    @Override
    public void recharge() {
        setResult(102);
        finish();
    }
}
