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
import com.whmnrc.qiangbizhong.model.bean.GiveBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 * 赠送记录
 */

public class GiveActivity extends BaseActivity {
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

        List<GiveBean> list = new ArrayList<>();
        list.add(new GiveBean("【皮肤】【瑞月雅水光针2ml】美莱肤质，提亮肤色",2,1,"2018.06.08 14:31:23"));
        list.add(new GiveBean("瑞月雅水光针2ml】美莱肤质，提亮肤色瑞月雅水光\n" +
                "针2ml】美莱肤质，提亮肤色",1,1,"2018.06.08 14:31:23"));

        mGiveAdapter.addFirstDataSet(list);

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    public class GiveAdapter extends BaseAdapter<GiveBean>{

        public GiveAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, GiveBean item, int position) {
            holder.setText(R.id.tv_title,item.getTitle()).setText(R.id.tv_time,item.getTime());
            if (item.getZs() - item.getYl() == 0){
                holder.setVisible(R.id.tv_ly,false);
                holder.setVisible(R.id.tv_zs,false);
            }else {
                holder.setVisible(R.id.tv_ly,true);
                holder.setVisible(R.id.tv_zs,true);
                holder.setText(R.id.tv_ly,String.valueOf(item.getYl()));
                holder.setText(R.id.tv_zs,"/"+item.getYl()+"个");
            }


        }

        @Override
        protected int getItemViewLayoutId(int position, GiveBean item) {
            return R.layout.item_give_r;
        }
    }
}
