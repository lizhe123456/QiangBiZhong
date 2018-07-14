package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class OpenLuckDrawFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private LuckDrawPresenter luckDrawPresenter;
    private OpenLuckDrawAdapter openLuckDrawAdapter;

    public static OpenLuckDrawFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type",type);
        OpenLuckDrawFragment fragment = new OpenLuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_open_luck_draw;
    }

    @Override
    protected void initData() {
        openLuckDrawAdapter = new OpenLuckDrawAdapter(mContext);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvList.setLayoutManager(gridLayoutManager);
        rvList.setAdapter(openLuckDrawAdapter);
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        luckDrawPresenter.awardlist2(1,this::luckDrawBack);
        List<LuckDrawGoodsBean> luckDrawGoodsBeans = new ArrayList<>();


        openLuckDrawAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
//                FlashSaleDetailsActivity.start(mContext);
            }
        });
    }

    private void luckDrawBack(List<LuckDrawGoodsBean> luckDrawGoodsBeans) {
        openLuckDrawAdapter.addFirstDataSet(luckDrawGoodsBeans);
    }

    class OpenLuckDrawAdapter extends BaseAdapter<LuckDrawGoodsBean>{

        private int width;

        private OpenLuckDrawAdapter(Context context) {
            super(context);
            width = ((ScreenUtils.getScreenWidth() - 45)/2);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, LuckDrawGoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getAwardTime()).setText(R.id.tv_time,item.getAwardTime()).setText(R.id.tv_surplus,"").setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());

            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, LuckDrawGoodsBean item) {
            return R.layout.item_open_luch_open;
        }
    }

}
