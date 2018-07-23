package com.whmnrc.qiangbizhong.ui.me;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.test.mock.MockContext;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AddressManageActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.CouponActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.GiveActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyCollectionActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyShopActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.OpinionBackActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.ReleaseGoodsActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.UserInfoActivity;
import com.whmnrc.qiangbizhong.ui.me.adapter.OderMenuAdapter;
import com.whmnrc.qiangbizhong.ui.me.adapter.OptionAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class MineFragment extends BaseFragment implements UserManage.UserInfoCall{

    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.iv_head)
    RoundedImageView ivHead;
    @BindView(R.id.tv_purchase_restrictions)
    TextView tvPurchaseRestrictions;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_yudou)
    TextView tvYudou;
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.rv_option)
    RecyclerView rvOption;
    @BindView(R.id.refresh)
    SmartRefreshLayout refreshLayout;

    ImmersionBar mImmersionBar;

    private LoginBean loginBean;

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        update();

    }

    public void update(){
        loginBean = UserManage.getInstance().getLoginBean();
        if (loginBean != null){
            tvUsername.setText(loginBean.getUserInfo_NickName());
            GlideuUtil.loadImageView(mContext,loginBean.getUserInfo_HeadImg(),ivHead);
            tvYudou.setText(loginBean.getUserInfo_Money()+"");
            tvPurchaseRestrictions.setText("今日可购"+ StringUtil.wanString(loginBean.getUserInfo_TotalMoney()));
        }else {
            tvUsername.setText("请先登录");
            GlideuUtil.loadImageView(mContext,"",ivHead);
            tvYudou.setText(0+"");
            tvPurchaseRestrictions.setText("今日可购"+ 0);
        }
        MineBean mineBean = new MineBean();
        mineBean.initMineBean();
        initMenu(mineBean.getMenuBeans());
        initOption(mineBean.getItemBeans());
        initMenu(mineBean.getMenuBeans());
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {
        mImmersionBar = ImmersionBar.with(this)
                .statusBarColor(R.color.tv_navigation_select)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .flymeOSStatusBarFontColor(R.color.white);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    UserManage.getInstance().getUserInfo(MineFragment.this);
                }else {
                    refreshLayout.finishRefresh(3000);
                }
            }
        });
    }

    private void initOption(List<MineBean.ItemBean> itemBeans) {
        rvOption.setLayoutManager(new LinearLayoutManager(getContext()));
        rvOption.setNestedScrollingEnabled(false);
        OptionAdapter optionAdapter = new OptionAdapter(getContext());
        rvOption.setAdapter(optionAdapter);
        optionAdapter.addFirstDataSet(itemBeans);
        optionAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (loginBean == null){
                    LoginActivity.start(mContext);
                    return;
                }
                switch (position){
                    case 0:
                        //赠送记录
                        GiveActivity.start(mContext);
                        break;
                    case 1:
                        //我的抵用券
                        CouponActivity.start(mContext);
                        break;
                    case 2:
                        //成为会员
                        AccountRechargeActivity.start(getContext(),1);
                        break;
                    case 3:
                        //我是代理商
                        MyShopActivity.start(mContext);
                        break;
                    case 4:
                        //商品发布
                        ReleaseGoodsActivity.start(mContext);
                        break;
                    case 5:
                        //我的收藏
                        MyCollectionActivity.start(mContext);
                        break;
                    case 6:
                        //收货信息
                        AddressManageActivity.start(getContext());
                        break;
                    case 7:
                        //意见反馈
                        OpinionBackActivity.start(mContext);
                        break;
                    case 8:
                        //设置
                        UserInfoActivity.start(getContext());
                        break;
                }
            }
        });
    }


    private void initMenu(List<MineBean.MenuBean> menuBeans) {
        OderMenuAdapter oderMenuAdapter;
        if (loginBean == null) {
            oderMenuAdapter = new OderMenuAdapter(getContext(),false);
        }else {
            oderMenuAdapter = new OderMenuAdapter(getContext(),true);
        }
        rvMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMenu.setNestedScrollingEnabled(false);
        rvMenu.setAdapter(oderMenuAdapter);
        oderMenuAdapter.addFirstDataSet(menuBeans);

    }



    @OnClick({R.id.iv_scan, R.id.iv_head, R.id.tv_purchase_restrictions,R.id.tv_username})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                break;
            case R.id.iv_head:
                if (loginBean == null){
                    LoginActivity.start(getContext());
                }
                break;
            case R.id.tv_purchase_restrictions:
                break;
            case R.id.tv_username:
                if (loginBean == null){
                    LoginActivity.start(getContext());
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mImmersionBar.destroy();
    }

    @Override
    public void userInfoBack(LoginBean loginBean) {
        this.loginBean = loginBean;
        update();
        refreshLayout.finishRefresh(true);
    }
}
