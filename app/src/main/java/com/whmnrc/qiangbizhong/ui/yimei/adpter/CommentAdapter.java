package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class CommentAdapter extends BaseAdapter<Object>{

    public CommentAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, Object item, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, Object item) {
        return R.layout.item_comment_list;
    }
}
