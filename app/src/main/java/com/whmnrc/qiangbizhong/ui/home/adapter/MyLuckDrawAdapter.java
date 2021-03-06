package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.MyLuckDrawBean;
import com.whmnrc.qiangbizhong.util.StringUtil;

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
                .setText(R.id.tv_now_moeny,StringUtil.wanString(item.getGoodsPrice_Price()))
                .setText(R.id.tv_old_moeny, StringUtil.wanString(item.getGoodsPrice_VirtualPrice()))
                .setText(R.id.tv_yuyue,"预约金"+item.getBond())
                .setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());
        TextView textView = holder.getView(R.id.tv_old_moeny);
        textView.getPaint().setAntiAlias(true);//抗锯齿
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);  // 设置中划线并加清晰
    }

    @Override
    protected int getItemViewLayoutId(int position, MyLuckDrawBean item) {
        return R.layout.item_my_luck_draw;
    }
}
