package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.CommentBean;
import com.whmnrc.qiangbizhong.presenter.me.EvaluatePresenter;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.CommentAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class CommentListActivity extends BaseActivity implements EvaluatePresenter.EvaluateListCall {

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

    private CommentAdapter mCommentAdapter;

    EvaluatePresenter evaluatePresenter;

    private String goodsId;

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, CommentListActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_comment_list;
    }

    @Override
    protected void setData() {
        tvTitle.setText("全部评论");
        ivBack.setVisibility(View.VISIBLE);
        goodsId = getIntent().getStringExtra("goodsId");
        mCommentAdapter = new CommentAdapter(this);
        evaluatePresenter = new EvaluatePresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mCommentAdapter);
        evaluatePresenter.evaluateList(goodsId,true,this);

        refresh.setOnRefreshListener(refreshLayout -> evaluatePresenter.evaluateList(goodsId,true,CommentListActivity.this));
        refresh.setOnLoadMoreListener(refreshLayout -> evaluatePresenter.evaluateList(goodsId,false,CommentListActivity.this));

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void evaluateList(List<CommentBean> commentBeans) {
        mCommentAdapter.addFirstDataSet(commentBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<CommentBean> commentBeans) {
        mCommentAdapter.addMoreDataSet(commentBeans);
        refresh.finishLoadMore(true);
    }
}
