package com.whmnrc.qiangbizhong.ui.me.fragment.order;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class OrderGoodsAdapter extends BaseAdapter<OrderListBean.GoodsBean>{

    public OrderGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.GoodsBean item, int position) {
        holder.setText(R.id.tv_goods_desc,item.getDesc()).setText(R.id.tv_desc,"")
                .setText(R.id.tv_moeny,item.getPrice())
                .setGlieuImage(R.id.iv_goods,item.getUrl())
                .setText(R.id.tv_goods_num,"x"+item.getNum());
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.GoodsBean item) {
        return R.layout.order_goods_item_v2;
    }
}
