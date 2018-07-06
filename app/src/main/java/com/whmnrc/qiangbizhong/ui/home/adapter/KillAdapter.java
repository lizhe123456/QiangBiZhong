package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class KillAdapter extends BaseAdapter<HomePageBean.GoodsBean>{

    public KillAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.GoodsBean item, int position) {
        holder.setText(R.id.tv_moeny,item.getMoney()).setText(R.id.tv_goods_name,item.getName()).setGlieuImage(R.id.iv_img,item.getUrl());
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.GoodsBean item) {
        return R.layout.item_home_kill;
    }
}
