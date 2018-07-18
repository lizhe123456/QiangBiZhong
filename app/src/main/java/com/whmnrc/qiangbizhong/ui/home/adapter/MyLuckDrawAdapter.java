package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.MyLuckDrawBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/17.
 */

public class MyLuckDrawAdapter extends BaseAdapter<MyLuckDrawBean>{

    public MyLuckDrawAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, MyLuckDrawBean item, int position) {
        holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                .setText(R.id.tv_now_moeny,item.getGoodsPrice_Price()+"")
                .setText(R.id.tv_old_moeny,item.getGoodsPrice_VirtualPrice()+"")
                .setText(R.id.tv_yuyue,"预约金"+item.getBond())
                .setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());
    }

    @Override
    protected int getItemViewLayoutId(int position, MyLuckDrawBean item) {
        return R.layout.item_my_luck_draw;
    }
}
