package com.whmnrc.qiangbizhong.ui.shop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.ui.PhotoCatActivity;
import com.whmnrc.qiangbizhong.util.GsonUtil;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 */

public class ImageAdapter extends BaseAdapter<String> {


    private OnImgDelete onImgDelete;
    private int type;
    private boolean isFrist;

    public void setOnImgDelete(OnImgDelete onImgDelete) {
        this.onImgDelete = onImgDelete;
    }

    public ImageAdapter(Context context,int type) {
        super(context);
        this.type = type;
    }

    @Override
    public void addFirstDataSet(List<String> data) {
        super.addFirstDataSet(data);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, String item, int position) {
        if (!TextUtils.isEmpty(item)){
            holder.setGlieuImage(R.id.iv_img,item);
            holder.setVisible(R.id.iv_img_add,false);
            if (type == 0) {
                holder.setVisible(R.id.iv_delete, true)
                        .setOnClickListener(R.id.iv_delete, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (onImgDelete != null) {
                                    onImgDelete.delete(position);
                                }
                            }
                        });
            }else {
                holder.setVisible(R.id.iv_delete,false);
                holder.setOnClickListener(R.id.iv_img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new PhotoCatActivity().start(getContext(), GsonUtil.createGsonString(getDataSource()),position);
                    }
                });
            }
        }else {
            holder.setVisible(R.id.iv_img_add,true);
            holder.setVisible(R.id.iv_delete,false);
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, String item) {
        return R.layout.item_img_list;
    }

    public interface OnImgDelete{
        void delete(int position);
    }
}
