package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.GiveRBean;
import com.whmnrc.qiangbizhong.presenter.me.GivePresenter;
import com.whmnrc.qiangbizhong.util.UserManage;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 * 赠送记录
 */

public class GiveActivity extends BaseActivity implements GivePresenter.GiveListCall{
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

    private GiveAdapter mGiveAdapter;
    private GivePresenter givePresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, GiveActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_give_r;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("赠送记录");
        mGiveAdapter = new GiveAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mGiveAdapter);
        givePresenter = new GivePresenter(this);
        showLoading("加载中..");
        givePresenter.getgivelist(true,this);

        refresh.setOnLoadMoreListener(refreshLayout -> {
            givePresenter.getgivelist(false,this);
        });

        refresh.setOnRefreshListener(refreshLayout -> {
            givePresenter.getgivelist(true,this);
        });

        mGiveAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                GiveRBean giveRBean = (GiveRBean) item;
                GiveDetailActivity.start(GiveActivity.this,giveRBean.getGiveId());
            }
        });

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("");
            textView.setTextColor(getResources().getColor(R.color.tv_navigation));
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void getGiveList(List<GiveRBean> giveRBeans) {
        if (giveRBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mGiveAdapter.addFirstDataSet(giveRBeans);
        refresh.finishRefresh(true);

    }

    @Override
    public void loadMore(List<GiveRBean> giveRBeans) {
        mGiveAdapter.addMoreDataSet(giveRBeans);
        refresh.finishLoadMore(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public class GiveAdapter extends BaseAdapter<GiveRBean>{

        public GiveAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, GiveRBean item, int position) {
            holder.setText(R.id.tv_title,item.getGoods_Name()).setText(R.id.tv_time,item.getCreateDate());
            if (item.getFromUserId().equals(UserManage.getInstance().getUserID())){
                //赠出
                holder.setText(R.id.tv_count,"赠出");

            }else {
                //接收
                holder.setText(R.id.tv_count,"接收");
            }
        }

        @Override
        protected int getItemViewLayoutId(int position, GiveRBean item) {
            return R.layout.item_give_r;
        }
    }
}
