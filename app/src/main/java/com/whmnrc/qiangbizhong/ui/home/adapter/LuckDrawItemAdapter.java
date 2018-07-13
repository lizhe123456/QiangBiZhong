package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class LuckDrawItemAdapter extends BaseAdapter<LuckDrawBean.LuckDrawGoodsBean>{

    private int width;


    public LuckDrawItemAdapter(Context context) {
        super(context);
        width = ((ScreenUtils.getScreenWidth() - 45)/2);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, LuckDrawBean.LuckDrawGoodsBean item, int position) {
        holder.setText(R.id.tv_goods_name,item.getName()).setText(R.id.tv_renshu,item.getNum()).setText(R.id.tv_time,item.getJuliTime()).setText(R.id.tv_edit,item.getCanyu()).setText(R.id.tv_date,item.getTime());
        holder.setGlieuImage(R.id.iv_img,item.getUrl());
        ImageView imageView = holder.getView(R.id.iv_img);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);
    }

    @Override
    protected int getItemViewLayoutId(int position, LuckDrawBean.LuckDrawGoodsBean item) {
        return R.layout.item_luck_draw;
    }
}
