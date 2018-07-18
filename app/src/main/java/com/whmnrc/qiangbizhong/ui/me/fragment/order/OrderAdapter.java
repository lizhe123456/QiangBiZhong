package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 * 1已预约 0未支付 1已支付 2待收货 3待评价 4已取消  5抢购成功 6抢购失败 7已中奖 8未中奖 9已退款
 * Order_CreateType 0 商城商品订单 1抢购订单 2抽奖订单 3医美服务订单
 */

public class OrderAdapter extends BaseAdapter<OrderListBean> {

    private OnOrderListener onOrderListener;

    public OrderAdapter(Context context) {
        super(context);
    }

    public void setOnOrderListener(OnOrderListener onOrderListener) {
        this.onOrderListener = onOrderListener;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean item, int position) {
        holder.setText(R.id.tv_num,"共有"+item.getOrder_Number()+"件商品");
//        holder.setVisible(R.id.tv_btn_2,false);
//        holder.setVisible(R.id.tv_btn_3,false);
        if (item.getOrder_CreateType() == 0){
            holder.setText(R.id.tv_order_num,"商城商品订单");
        }else if (item.getOrder_CreateType() == 1){
            holder.setText(R.id.tv_order_num,"抢购订单");
        }else if (item.getOrder_CreateType() == 2){
            holder.setText(R.id.tv_order_num,"抽奖订单");
        }else if (item.getOrder_CreateType() == 3){
            holder.setText(R.id.tv_order_num,"医美服务订单");
        }
        if (item.getOrder_State() == -1){
            //-1已预约
            if (item.getOrder_CreateType() == 0){
                //商城商品订单
            }else if (item.getOrder_CreateType() == 1){
                //抢购订单
                holder.setText(R.id.order_state,"已支付");
                holder.setText(R.id.tv_btn_2,"去抢购");
                holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onOrderListener.toQiangGou(item);
                    }
                });
                holder.setText(R.id.tv_btn_3,"取消抢购");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        FlashSaleDetailsActivity.start(getContext(),item.getRushRecord().getRushId(),1);
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.cancel(item);
                });
            }else if (item.getOrder_CreateType() == 2){
                //抽奖订单
                holder.setText(R.id.order_state,"等待开奖");
                holder.setText(R.id.tv_btn_2,"去查看");
                holder.setText(R.id.tv_btn_3,"联系客服");
                holder.setOnClickListener(R.id.tv_btn_2, v -> {
                    if (onOrderListener != null)
                        AwardDetailActivity.start(getContext(),item.getAward().getGoodsAwardId());
                });
                holder.setOnClickListener(R.id.tv_btn_3, v -> {
                    if (onOrderListener != null)
                        onOrderListener.customerServicePhoneClick(item);
                });
            }else if (item.getOrder_CreateType() == 3){
                //医美服务订单
            }else if (item.getOrder_CreateType() == 4){

            }


        }else if (item.getOrder_State() == 0){
            //0未支付
            holder.setText(R.id.order_state,"未支付");
            holder.setText(R.id.tv_btn_2,"去支付");
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setOnClickListener(R.id.tv_btn_2, v -> {
                if (onOrderListener != null)
                    onOrderListener.payClick(item);
            });
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
        }else if (item.getOrder_State() == 1){
            //1已支付
            holder.setText(R.id.order_state,"已支付");
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
        }else if (item.getOrder_State() == 2){
            //2待收货
            holder.setText(R.id.order_state,"待收货");
            holder.setText(R.id.tv_btn_2,"确认收货");
            holder.setVisible(R.id.tv_btn_2,true);
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
            holder.setOnClickListener(R.id.tv_btn_2, v -> {
                if (onOrderListener != null)
                    onOrderListener.collectGoods(item);
            });
        }else if (item.getOrder_State() == 3){
            //已完成

        }else if (item.getOrder_State() == 4){
            //已取消
            holder.setText(R.id.order_state,"已取消");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setVisible(R.id.tv_btn_3,false);
        }else if (item.getOrder_State() == 6){
            //5抢购成功
            holder.setText(R.id.order_state,"抢购成功");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setOnClickListener(R.id.tv_btn_2, v -> {
                if (onOrderListener != null)
                    onOrderListener.payClick(item);
            });
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
        }else if (item.getOrder_State() == 7){
            //6抢购失败
            holder.setText(R.id.order_state,"抢购失败");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setVisible(R.id.tv_btn_3,false);
        }else if (item.getOrder_State() == 8){
            //7已中奖
            holder.setText(R.id.order_state,"已中奖");
            holder.setText(R.id.tv_btn_2,"付尾款");
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setOnClickListener(R.id.tv_btn_2, v -> {
                if (onOrderListener != null)
                    onOrderListener.payClick(item);
            });
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
        }else if (item.getOrder_State() == 9){
            //8未中奖
            holder.setText(R.id.order_state,"未中奖");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setVisible(R.id.tv_btn_3,false);
        }else if (item.getOrder_State() == 10){
            holder.setText(R.id.order_state,"已完成");
            holder.setText(R.id.tv_btn_3,"联系客服");
            holder.setText(R.id.tv_btn_2,"去评价");
            holder.setVisible(R.id.tv_btn_2,false);
            holder.setOnClickListener(R.id.tv_btn_3, v -> {
                if (onOrderListener != null)
                    onOrderListener.customerServicePhoneClick(item);
            });
            holder.setOnClickListener(R.id.tv_btn_2, v -> {
                if (onOrderListener != null)
                    onOrderListener.evaluate(item);
            });
        }


        RecyclerView goodsList = holder.getView(R.id.rv_goods_list);
        OrderGoodsAdapter adapter = new OrderGoodsAdapter(getContext(),item.getOrder_CreateType());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        goodsList.setLayoutManager(layoutManager);
        goodsList.setAdapter(adapter);
        adapter.addFirstDataSet(item.getDetail());
        if (item.getOrder_CreateType() == 0){

        }else if (item.getOrder_CreateType() == 1){
            adapter.setOnItemClickListener((view, item1, position1) ->
                    FlashSaleDetailsActivity.start(getContext(),item.getRushRecord().getRushId(),0));
        }else if (item.getOrder_CreateType() == 2){
            adapter.setOnItemClickListener((view, item1, position1) -> AwardDetailActivity.start(getContext(),item.getAward().getGoodsAwardId()));
        }else if (item.getOrder_CreateType() == 3){

        }

    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean item) {
        return R.layout.wait_order_item;
    }
}