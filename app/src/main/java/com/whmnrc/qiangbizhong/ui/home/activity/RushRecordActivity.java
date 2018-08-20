package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.RushRecordBean;
import com.whmnrc.qiangbizhong.presenter.home.FlashSalePresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/18.
 */

public class RushRecordActivity extends BaseActivity implements FlashSalePresenter.FlashSaleRecordCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private RushRecordAdapter rushRecordAdapter;
    private FlashSalePresenter flashSalePresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, RushRecordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_rush_record;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("抢购记录");
        rushRecordAdapter = new RushRecordAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(rushRecordAdapter);
        flashSalePresenter = new FlashSalePresenter(this);
        showLoading("加载中..");
        flashSalePresenter.myRushGoodSrecord(true,RushRecordActivity.this);
        refresh.setOnRefreshListener(refreshLayout -> flashSalePresenter.myRushGoodSrecord(true,RushRecordActivity.this));

        refresh.setOnLoadMoreListener(refreshLayout -> flashSalePresenter.myRushGoodSrecord(false,RushRecordActivity.this));

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }


    @Override
    public void onFlashSaleRecord(List<RushRecordBean> rushRecordBeans) {
        if (rushRecordBeans.size() == 0){
            showEmpty();
            recyclerView.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        rushRecordAdapter.addFirstDataSet(rushRecordBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<RushRecordBean> rushRecordBeans) {
        rushRecordAdapter.addMoreDataSet(rushRecordBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("暂无更多数据~");
            vsEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    class RushRecordAdapter extends BaseAdapter<RushRecordBean>{
        private int width;

        private RushRecordAdapter(Context context) {
            super(context);
            width = ((ScreenUtils.getScreenWidth() - 45) / 2);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, RushRecordBean item, int position) {
            holder.setText(R.id.tv_time,item.getRushEndTime())
                    .setText(R.id.tv_goods_name, item.getGoods_Name())
                    .setGlieuImage(R.id.iv_img, item.getGoods_ImaPath());

            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);
            holder.setOnClickListener(R.id.ll_goods, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlashSaleDetailsActivity.start(getContext(),item.getRushId());
                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, RushRecordBean item) {
            return R.layout.item_rush_record;
        }

    }
}
