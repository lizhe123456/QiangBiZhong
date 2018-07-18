package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.MyLuckDrawBean;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.home.adapter.MyLuckDrawAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.GsonUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class MyLuckDrawFragment extends BaseFragment implements LuckDrawPresenter.MyLuckDrawCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.v_divider)
    View vDivider;
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTitle;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private LuckDrawPresenter luckDrawPresenter;

    private MyLuckDrawAdapter myLuckDrawAdapter;

    public static MyLuckDrawFragment newInstance() {
        Bundle args = new Bundle();
        MyLuckDrawFragment fragment = new MyLuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_my_luck_draw;
    }

    @Override
    protected void initData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("我的奖品");
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        luckDrawPresenter.awardlist(this);
        myLuckDrawAdapter = new MyLuckDrawAdapter(mContext);
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
        rvList.setAdapter(myLuckDrawAdapter);
//        GlideuUtil.loadImageView(mContext,"",ivImg);
    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        getActivity().finish();
    }

    @Override
    public void error() {

    }

    @Override
    public void myLuckDraw(List<MyLuckDrawBean> myLuckDrawBeans) {
        myLuckDrawAdapter.addFirstDataSet(myLuckDrawBeans);
    }
}
