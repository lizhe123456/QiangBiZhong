package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.CommentBean;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ImageAdapter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class CommentAdapter extends BaseAdapter<CommentBean>{

    public CommentAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, CommentBean item, int position) {
        holder.setText(R.id.tv_time,item.getCreateDate())
                .setText(R.id.tv_desc,item.getTextContext())
                .setText(R.id.tv_name,item.getUserInfo_NickName())
                .setGlieuImage(R.id.iv_head,item.getUserInfo_HeadImg());

        RecyclerView recyclerView = holder.getView(R.id.rv_img_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        ImageAdapter imageAdapter = new ImageAdapter(getContext(),1);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.addFirstDataSet(item.getImages());
    }

    @Override
    protected int getItemViewLayoutId(int position, CommentBean item) {
        return R.layout.item_comment_list;
    }

}
