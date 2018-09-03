package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.OrderdetailBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OrderGoodsAdapter;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2018/8/10.
 */

public class ShopOrderDetailActivity extends BaseActivity implements OrderPresenter.OrderDetailCall,OrderPresenter.OrderUpdateCall, OrderPresenter.CollectCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.order_state)
    TextView orderState;
    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_item_0)
    TextView tvItem0;
    @BindView(R.id.tv_item_1)
    TextView tvItem1;
    @BindView(R.id.tv_order_num_2)
    TextView tvOrderNum2;
    @BindView(R.id.tv_order_num_3)
    TextView tvOrderNum3;
    @BindView(R.id.tv_order_num_4)
    TextView tvOrderNum4;
    @BindView(R.id.tv_order_num_5)
    TextView tvOrderNum5;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.tv_btn)
    TextView tvBtn;
    @BindView(R.id.ll_btn_1)
    LinearLayout llBtn1;
    @BindView(R.id.ll_tv_order_num1)
    LinearLayout llTvOrder;

    private OrderPresenter orderPresenter;
    private String orderId;
    private OrderGoodsAdapter orderGoodsAdapter;

    public static void start(Fragment context, String orderId) {
        Intent starter = new Intent(context.getContext(), ShopOrderDetailActivity.class);
        starter.putExtra("orderId",orderId);
        context.startActivityForResult(starter,101);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ShopOrderDetailActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_order_details;
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



    @OnClick({R.id.iv_back,R.id.tv_btn})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_btn:

                break;


        }

    }

    @Override
    public void error() {

    }

    @Override
    public void updateData() {
        setResult(102);
        finish();
    }

    OrderdetailBean orderdetailBean;

    @Override
    public void orderDetail(OrderdetailBean orderdetailBean) {
        this.orderdetailBean = orderdetailBean;
        orderGoodsAdapter = new OrderGoodsAdapter(this,orderdetailBean.getOrder_CreateType());

        rvGoodsList.setAdapter(orderGoodsAdapter);
        orderGoodsAdapter.addFirstDataSet(orderdetailBean.getDetail());
        tvId.setText(orderdetailBean.getUserInfo_NickName());
        tvPhone.setText(orderdetailBean.getUserInfo_Mobile());
        tvCity.setText(orderdetailBean.getAddress_FullAddress());
        tvItem0.setText(orderdetailBean.getOrder_No());
        tvItem1.setText(orderdetailBean.getOrder_PayNo());
        tvOrderNum2.setText(orderdetailBean.getOrder_CreateTime());
        tvTitle1.setText("付款时间：");
        tvOrderNum3.setText(orderdetailBean.getOrder_CreateTime());
//        if (orderdetailBean.getOrder_State() != 1) {
//            tvTitle1.setText("付款时间：");
//            tvOrderNum3.setText(orderdetailBean.getOrder_DeliverGoodsTime());
//        }else {
//            tvTitle1.setText("运单号：");
//            tvOrderNum4.setText(orderdetailBean.getOrder_WaybillNumber() == null ? "" : orderdetailBean.getOrder_WaybillNumber());
//        }
        tvOrderNum4.setText(orderdetailBean.getOrder_WaybillNumber() == null ? "" : orderdetailBean.getOrder_WaybillNumber() + "(" + orderdetailBean.getOrder_WaybillCompany() + ")");
        if (orderdetailBean.getOrder_State() == -5){
            llTvOrder.setVisibility(View.VISIBLE);
            if (orderdetailBean.getOrder_RefundRemark() != null) {
                tvOrderNum5.setText(orderdetailBean.getOrder_RefundRemark() + "");
            }

            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，正在等待退款");
            tvBtn.setText("处理退款");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(ShopOrderDetailActivity.this).builder()
                            .setTitle("提示")
                            .setMsg("确认要退款吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setPositiveButton("确认", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    orderPresenter.returngoods(orderdetailBean.getOrder_ID(),ShopOrderDetailActivity.this);
                                }
                            }).show();

                }
            });

        }else if (orderdetailBean.getOrder_State() == 0){
            //0未支付
            tvBtn.setVisibility(View.GONE);
        }else if (orderdetailBean.getOrder_State() == 1){
            //1已支付
            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，正在等待发货");
            tvBtn.setText("确认发货");
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ConfirmSendGoodsActivity.start(ShopOrderDetailActivity.this,orderdetailBean.getOrder_ID());
                }
            });
        }else if (orderdetailBean.getOrder_State() == 2){
            //2待收货
            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，正在等待收货");
            tvBtn.setText("确认收货");
            tvBtn.setVisibility(View.GONE);
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(ShopOrderDetailActivity.this).builder()
                            .setTitle("提示")
                            .setMsg("确定要收货吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View dialog) {
                                }
                            }).setPositiveButton("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View dialog) {
                            showLoading("收货中..");
                            orderPresenter.collectgoods(orderdetailBean.getOrder_ID(), ShopOrderDetailActivity.this);
                        }
                    }).show();
                }
            });
        }else if (orderdetailBean.getOrder_State() == 3){
            tvBtn.setVisibility(View.GONE);

        }else if (orderdetailBean.getOrder_State() == 4){
            tvBtn.setVisibility(View.GONE);
            //已取消
            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，已取消");
            llBtn1.setVisibility(View.GONE);
        }else if (orderdetailBean.getOrder_State() == 5){
            tvBtn.setVisibility(View.GONE);
            //已退款
            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，已收到退款");
            llBtn1.setVisibility(View.GONE);
        }else if (orderdetailBean.getOrder_State() == 6){
            //6抢购成功

        }else if (orderdetailBean.getOrder_State() == 7){
            //6抢购失败

        }else if (orderdetailBean.getOrder_State() == 8){
            //7已中奖

        }else if (orderdetailBean.getOrder_State() == 9){
            //8未中奖

        }else if (orderdetailBean.getOrder_State() == 10){
            tvBtn.setVisibility(View.GONE);
            //已完成
            orderState.setText("买家（"+orderdetailBean.getUserInfo_NickName()+"）" + "的订单，已完成");
            llBtn1.setVisibility(View.GONE);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            if (resultCode == 105){
                orderPresenter.orderdetail(orderId,this);
            }
        }
    }

    @Override
    public void collect() {
        setResult(102);
        finish();
    }
}
