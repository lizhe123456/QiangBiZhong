package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class KillAdapter extends BaseAdapter<HomePageBean.GoodsBean>{

    private int width;

    public KillAdapter(Context context,int type) {
        super(context);
        if (type == 0) {
            width = (int) ((ScreenUtils.getScreenWidth() - 45) / 2.5);
        }else {
            width =  ((ScreenUtils.getScreenWidth() - 45) / 2);
        }
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.GoodsBean item, int position) {
        holder.setText(R.id.tv_moeny,item.getMoney()).setText(R.id.tv_goods_name,item.getName()).setGlieuImage(R.id.iv_img,item.getUrl());
        ImageView imageView = holder.getView(R.id.iv_img);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);

    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.GoodsBean item) {
        return R.layout.item_home_kill;
    }
}
