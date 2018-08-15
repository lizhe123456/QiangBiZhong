package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.NewsBean;
import com.whmnrc.qiangbizhong.presenter.yimei.NewsPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.GiveDetailActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class NewsListActivity extends BaseActivity implements NewsPresenter.MessageNoticeCall{


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

    private NewsPresenter newsPresenter;
    private NewsListAdapter newsListAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, NewsListActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (newsPresenter != null){
            newsPresenter.getmessagenotice(true,this);
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_news_list;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("我的消息");
        newsPresenter = new NewsPresenter(this);
        showLoading("加载中..");
        newsPresenter.getmessagenotice(true,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsListAdapter = new NewsListAdapter(this);
        recyclerView.setAdapter(newsListAdapter);
        newsListAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                NewsBean newsBean = (NewsBean) item;
                newsPresenter.setnoticeisread(newsBean.getNotice_ID());
                if (newsBean.getType() == 0){
                    NewsDetailActivity.start(NewsListActivity.this,newsBean.getNotice_ID());
                }else if (newsBean.getType() == 1){
                    //代付
                    DaiPayActivity.start(NewsListActivity.this,newsBean.getObjectId());
                }else if (newsBean.getType() == 2){
                    //赠送
                    GiveDetailActivity.start(NewsListActivity.this,newsBean.getObjectId());
                }
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                newsPresenter.getmessagenotice(true,NewsListActivity.this);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                newsPresenter.getmessagenotice(false,NewsListActivity.this);
            }
        });

    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void getmessagenotice(List<NewsBean> newsBeans) {
        if (newsBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        newsListAdapter.addFirstDataSet(newsBeans);
        refresh.finishRefresh(true);
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
    public void loadMore(List<NewsBean> newsBeans) {
        newsListAdapter.addMoreDataSet(newsBeans);
        refresh.finishLoadMore(true);
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    class NewsListAdapter extends BaseAdapter<NewsBean>{

        public NewsListAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, NewsBean item, int position) {
            String str = "";
            if (item.getType() == 0){
                str = "[公告]";
            }else if (item.getType() == 1){
                str = "[代付]";
            }else if (item.getType() == 2){
                str = "[赠送]";
            }
            String text = str + item.getNotice_Title();
            holder.setText(R.id.tv_title,text)
                    .setText(R.id.tv_time,item.getNotice_CreateTime());

            if (item.getReadStatus() == 0){
                holder.setTextColor(R.id.tv_title,R.color.tv_000).setTextColor(R.id.tv_time,R.color.tv_aaa);
                SpannableStringBuilder style = new SpannableStringBuilder(text);
                style.setSpan(new ForegroundColorSpan(Color.RED),0,4,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                TextView textView = holder.getView(R.id.tv_title);
                textView.setText(style);
            }else if (item.getReadStatus() == 1){
                holder.setTextColor(R.id.tv_title,R.color.tv_aaa).setTextColor(R.id.tv_time,R.color.tv_aaa);
            }
        }

        @Override
        protected int getItemViewLayoutId(int position, NewsBean item) {
            return R.layout.item_news_list;
        }
    }


}
