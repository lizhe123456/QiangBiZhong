package com.whmnrc.qiangbizhong.ui.shop.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopGoodsBean;
import com.whmnrc.qiangbizhong.util.StringUtil;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class ShopListAdapter extends BaseAdapter<ShopGoodsBean> {

    private int width;

    public ShopListAdapter(Context context) {
        super(context);
        width =  ((ScreenUtils.getScreenWidth() - SizeUtils.dp2px(40)) / 2);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopGoodsBean item, int position) {
        holder.setText(R.id.tv_price, StringUtil.wanString(item.getGoods_PriceMin())).setText(R.id.tv_goods_name,item.getGoods_Name()).setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());
        ImageView imageView = holder.getView(R.id.iv_img);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);

    }

    @Override
    protected int getItemViewLayoutId(int position, ShopGoodsBean item) {
        return R.layout.item_shop_goods_list;
    }
}
