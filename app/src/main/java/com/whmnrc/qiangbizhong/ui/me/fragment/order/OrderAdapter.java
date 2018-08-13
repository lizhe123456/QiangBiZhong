package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.OrderDetailsActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.ShopOrderDetailActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopsListActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiOrderDetailsActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 * 1已预约 0未支付 1已支付 2待收货 3待评价 4已取消  5抢购成功 6抢购失败 7已中奖 8未中奖 9已退款
 * Order_CreateType 0 商城商品订单 1抢购订单 2抽奖订单 3医美服务订单
 */

public class OrderAdapter extends BaseAdapter<OrderListBean> {

    private OnOrderListener onOrderListener;

    private Fragment activity;
    private boolean isShop;

    public OrderAdapter(Fragment activity, boolean isShop) {
        super(activity.getContext());
        this.activity = activity;
        this.isShop = isShop;
    }

    public void setOnOrderListener(OnOrderListener onOrderListener) {
        this.onOrderListener = onOrderListener;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean item, int position) {
        int num = 0;
        int moeny = 0;
        for (OrderListBean.DetailBean orderListBean : item.getDetail()) {
            num += orderListBean.getOrderItem_Number();
            moeny += orderListBean.getSpecAttr_Price() * orderListBean.getOrderItem_Number();
        }
        holder.setText(R.id.tv_num, "共有" + num + "件商品");
//        holder.setVisible(R.id.tv_btn_2,false);
//        holder.setVisible(R.id.tv_btn_3,false);
        holder.setText(R.id.tv_moeny, moeny + "");
        if (item.getOrder_CreateType() == 0) {
            if (item.getStoreInfo() != null) {
                holder.setText(R.id.tv_order_num, item.getStoreInfo().getStoreName() == null ? "" : item.getStoreInfo().getStoreName()).setOnClickListener(R.id.tv_order_num, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShopsListActivity.start(getContext(), item.getStoreInfo().getId());
                    }
                });
            } else {
                holder.setText(R.id.tv_order_num, "");
            }
        } else if (item.getOrder_CreateType() == 1) {
            holder.setText(R.id.tv_order_num, "抢购订单");
        } else if (item.getOrder_CreateType() == 2) {
            holder.setText(R.id.tv_order_num, "抽奖订单");
        } else if (item.getOrder_CreateType() == 3) {
            holder.setText(R.id.tv_order_num, "医美服务订单");
        }
        if (item.getOrder_State() == -1) {
            //-1已预约
            if (item.getOrder_CreateType() == 0) {
                //未支付
                if (item.getOrder_CreateType() == 3) {
                    holder.setText(R.id.order_state, "未支付");
                    holder.setText(R.id.tv_btn_2, "立即支付");
                    holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onOrderListener.payClick(item);
                        }
                    });
                    holder.setText(R.id.tv_btn_3, "取消代付");
                    holder.setOnClickListener(R.id.tv_btn_3, v -> {
                        if (onOrderListener != null)
                            onOrderListener.cancel(item);
                    });

                }
            } else if (item.getOrder_CreateType() == 1) {
                //抢购订单
                holder.setText(R.id.order_state, "已预约");
                holder.setText(R.id.tv_btn_2, "去抢购");
                holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onOrderListener.toQiangGou(item);
                    }
                });
                holder.setText(R.id.tv_btn_3, "取消抢购");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        FlashSaleDetailsActivity.start(getContext(), item.getRushRecord().getRushId(), 1);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.cancel(item);
                });
            } else if (item.getOrder_CreateType() == 2) {
                //抽奖订单
                holder.setText(R.id.order_state, "已预约");
                holder.setText(R.id.tv_btn_2, "去查看");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        AwardDetailActivity.start(getContext(), item.getAward().getGoodsAwardId());
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            } else if (item.getOrder_CreateType() == 3) {
                //医美服务订单
            } else if (item.getOrder_CreateType() == 4) {

            }


        } else if (item.getOrder_State() == -5) {
            if (isShop) {
                holder.setText(R.id.order_state, "退款中");
                holder.setVisible(R.id.tv_btn_3, false);
                holder.setText(R.id.tv_btn_2, "处理退款");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.returnGoods(item);
                });
            } else {
                holder.setText(R.id.order_state, "退款中");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setText(R.id.tv_btn_2, "取消退款");
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.qxRefund(item);
                });
            }
        } else if (item.getOrder_State() == 0) {
            if (isShop) {
                //0未支付
                holder.setText(R.id.order_state, "未支付");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //0未支付
                holder.setText(R.id.order_state, "未支付");
                holder.setText(R.id.tv_btn_2, "去支付");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.payClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        } else if (item.getOrder_State() == 1) {
            if (isShop) {
                holder.setText(R.id.order_state, "已支付");
                holder.setText(R.id.tv_btn_2, "确认发货");
                holder.setVisible(R.id.tv_btn_3, false);
                holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onOrderListener != null)
                            onOrderListener.sendGoods(item);
                    }
                });
            } else {
                //1已支付
                holder.setText(R.id.order_state, "已支付");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setText(R.id.tv_btn_2, "申请退款");
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.refund(item);
                });
            }
        } else if (item.getOrder_State() == 2) {
            if (isShop) {
                holder.setText(R.id.order_state, "待收货");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
//                holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (onOrderListener != null)
//                            onOrderListener.collectGoods(item);
//                    }
//                });
            } else {
                //2待收货
                holder.setText(R.id.order_state, "待收货");
                holder.setText(R.id.tv_btn_2, "确认收货");
                holder.setVisible(R.id.tv_btn_2, true);
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.collectGoods(item);
                });
            }
        } else if (item.getOrder_State() == 3) {
            if (isShop) {
                holder.setText(R.id.order_state, "待评价");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //待评价
                holder.setText(R.id.order_state, "待评价");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setText(R.id.tv_btn_2, "去评价");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.evaluate(item);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        } else if (item.getOrder_State() == 4) {
            if (isShop) {
                holder.setText(R.id.order_state, "已取消");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //已取消
                holder.setText(R.id.order_state, "已取消");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            }
        } else if (item.getOrder_State() == 5) {
            if (isShop) {
                holder.setText(R.id.order_state, "已退款");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //已退款
                holder.setText(R.id.order_state, "已退款");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        } else if (item.getOrder_State() == 6) {
            if (isShop) {
                holder.setText(R.id.order_state, "抢购成功");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //6抢购成功
                holder.setText(R.id.order_state, "抢购成功");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.payClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        } else if (item.getOrder_State() == 7) {
            if (isShop) {
                holder.setText(R.id.order_state, "抢购失败");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //6抢购失败
                holder.setText(R.id.order_state, "抢购失败");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            }
        } else if (item.getOrder_State() == 8) {
            if (isShop) {
                holder.setText(R.id.order_state, "已中奖");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //7已中奖
                holder.setText(R.id.order_state, "已中奖");
                holder.setText(R.id.tv_btn_2, "付尾款");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        onOrderListener.payClick(item);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        } else if (item.getOrder_State() == 9) {
            if (isShop) {
                holder.setText(R.id.order_state, "未中奖");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            } else {
                //8未中奖
                holder.setText(R.id.order_state, "未中奖");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setVisible(R.id.tv_btn_3, false);
            }
        } else if (item.getOrder_State() == 10) {
            if (isShop) {
                holder.setText(R.id.order_state, "已完成");
                holder.setVisible(R.id.tv_btn_3, false);
                holder.setVisible(R.id.tv_btn_2, false);
            } else {
                holder.setText(R.id.order_state, "已完成");
                holder.setText(R.id.tv_btn_3, "联系客服");
                holder.setVisible(R.id.tv_btn_2, false);
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }
        }


        RecyclerView goodsList = holder.getView(R.id.rv_goods_list);
        OrderGoodsAdapter adapter = new OrderGoodsAdapter(getContext(), item.getOrder_CreateType());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        goodsList.setLayoutManager(layoutManager);
        goodsList.setAdapter(adapter);
        adapter.addFirstDataSet(item.getDetail());
        if (item.getOrder_CreateType() == 0) {
            adapter.setOnItemClickListener((view, item1, position1) -> {
                if (isShop) {
                    ShopOrderDetailActivity.start(activity, item.getOrder_ID());
                } else {
                    OrderDetailsActivity.start(activity, item.getOrder_ID());
                }
            });
        } else if (item.getOrder_CreateType() == 1) {
            adapter.setOnItemClickListener((view, item1, position1) ->
            {
                if (isShop) {
                    ShopOrderDetailActivity.start(activity, item.getOrder_ID());
                } else {
                    OrderDetailsActivity.start(activity, item.getOrder_ID());
                }
            });
        } else if (item.getOrder_CreateType() == 2) {
            adapter.setOnItemClickListener((view, item1, position1) -> AwardDetailActivity.start(getContext(), item.getAward().getGoodsAwardId()));
        } else if (item.getOrder_CreateType() == 3) {
            adapter.setOnItemClickListener((view, item1, position1) -> YiMeiOrderDetailsActivity.start(getContext(), item.getOrder_ID()));
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean item) {
        return R.layout.wait_order_item;
    }
}
