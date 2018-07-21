package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/20.
 */

public class SearchGoodsActivity extends BaseActivity {


    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.view_item1)
    View viewItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.view_item2)
    View viewItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.view_item3)
    View viewItem3;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    //请求类型
    private int type;

    public static void start(Context context) {
        Intent starter = new Intent(context, SearchGoodsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void setData() {
        req(1);
    }


    @OnClick({R.id.iv_img, R.id.ll_item1, R.id.ll_item2, R.id.ll_item3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_img:
                this.finish();
                break;
            case R.id.ll_item1:
                //综合
                req(1);
                break;
            case R.id.ll_item2:
                //销量
                req(2);
                break;
            case R.id.ll_item3:
                //价格
                req(3);
                break;
        }
    }

    private void req(int i) {
        tvItem1.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem2.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem3.setTextColor(getResources().getColor(R.color.tv_191));
        viewItem1.setVisibility(View.INVISIBLE);
        viewItem2.setVisibility(View.INVISIBLE);
        viewItem3.setVisibility(View.INVISIBLE);
        switch (i){
            case 1:
                viewItem1.setVisibility(View.VISIBLE);
                tvItem1.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                viewItem2.setVisibility(View.VISIBLE);
                tvItem2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                viewItem3.setVisibility(View.VISIBLE);
                tvItem3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }
}
