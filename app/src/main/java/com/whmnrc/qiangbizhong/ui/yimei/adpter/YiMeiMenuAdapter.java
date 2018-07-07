package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.YiMeiBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class YiMeiMenuAdapter extends BaseAdapter<YiMeiBean.MenuBean> {

    public YiMeiMenuAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, YiMeiBean.MenuBean item, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, YiMeiBean.MenuBean item) {
        return R.layout.item_yimei_menu;
    }
}
