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

public class MenuAdapter extends BaseAdapter<HomePageBean.MenuBean> {

    public MenuAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.MenuBean item, int position) {
        holder.setImageResource(R.id.iv_img,item.getResId()).setText(R.id.tv_text,item.getText());
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.MenuBean item) {
        return R.layout.item_menu;
    }
}
