package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.UserInfoBean;
import com.whmnrc.qiangbizhong.presenter.home.AwardPresenter;
import com.whmnrc.qiangbizhong.ui.home.adapter.UserInfoAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/26.
 */

public class UserListActivity extends BaseActivity implements AwardPresenter.UserCall{


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
    @BindView(R.id.fl_content)
    FrameLayout flContent;


    private UserInfoAdapter userInfoAdapter;
    private AwardPresenter awardPresenter;
    private String awardId;

    public static void start(Context context, String awardId) {
        Intent starter = new Intent(context, UserListActivity.class);
        starter.putExtra("awardId",awardId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_user_list;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("参与用户");
        userInfoAdapter = new UserInfoAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userInfoAdapter);
        awardId = getIntent().getStringExtra("awardId");
        awardPresenter = new AwardPresenter(this);
        showLoading("加载中..");
        awardPresenter.awardrecorduserlist(true,awardId,this);

        refresh.setOnRefreshListener(refreshLayout -> awardPresenter.awardrecorduserlist(true,awardId,this));

        refresh.setOnLoadMoreListener(refreshLayout -> awardPresenter.awardrecorduserlist(false,awardId,this));
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

    @Override
    public void awardUserBack(@NonNull List<UserInfoBean> list) {
        if (list.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        userInfoAdapter.addFirstDataSet(list);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(@NonNull List<UserInfoBean> list) {
        userInfoAdapter.addMoreDataSet(list);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_order);
            textView.setText("暂无更多数据~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

}
