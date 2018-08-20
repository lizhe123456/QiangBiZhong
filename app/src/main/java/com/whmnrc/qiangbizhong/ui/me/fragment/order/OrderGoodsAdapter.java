package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.content.Context;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class OrderGoodsAdapter extends BaseAdapter<OrderListBean.DetailBean>{

    private int type;

    public OrderGoodsAdapter(Context context,int type ) {
        super(context);
        this.type = type;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DetailBean item, int position) {
        holder.setText(R.id.tv_goods_desc,item.getProduct_Name()).setText(R.id.tv_desc,item.getSpec_Name() +"  " + item.getSpecAttr_Name())
                .setText(R.id.tv_moeny,item.getSpecAttr_Price()+"")
                .setGlieuImage(R.id.iv_goods,item.getProduct_ImgPath())
                .setText(R.id.tv_goods_num,"x"+item.getOrderItem_Number());

        if (type == 0){
            holder.setOnClickListener(R.id.iv_goods, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShopDetailsActivity.start(getContext(),item.getProduct_ID());
                }
            });
            holder.setVisible(R.id.rl_moeny,false);
        }else if (type == 1){
            holder.setVisible(R.id.rl_moeny,true);
            holder.setText(R.id.tv_yu_moeny,""+item.getBond()).setText(R.id.tv_now_moeny,""+ (item.getProduct_Price() - item.getBond()));
        }else if (type == 2){
            holder.setVisible(R.id.rl_moeny,true);
            holder.setText(R.id.tv_yu_moeny,""+item.getBond()).setText(R.id.tv_now_moeny,""+ (item.getProduct_Price() - item.getBond()));
        }else if (type == 3){
            holder.setVisible(R.id.rl_moeny,false);

            holder.setOnClickListener(R.id.iv_goods, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YiMeiGoodsDetailsActivity.start(getContext(),item.getProduct_ID());
                }
            });
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.DetailBean item) {
        return R.layout.order_goods_item_v2;
    }
}
