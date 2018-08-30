package com.whmnrc.qiangbizhong.ui.me;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.permissions.RxPermissions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AddressManageActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AgentActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.CouponActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.GiveActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyCollectionActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.OpinionBackActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.SecondActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.ShapeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.UserInfoActivity;
import com.whmnrc.qiangbizhong.ui.me.adapter.OderMenuAdapter;
import com.whmnrc.qiangbizhong.ui.me.adapter.OptionAdapter;
import com.whmnrc.qiangbizhong.ui.me.goods.ReleaseGoodsActivity;
import com.whmnrc.qiangbizhong.ui.shop.shopenter.ShopEnter1Activity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
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
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTtile;
    @BindView(R.id.nv_s)
    NestedScrollView nestedScrollView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.v_divider)
    View vDivider;

    ImmersionBar mImmersionBar;

    private LoginBean loginBean;
    private static final int REQUEST_CODE = 101;
    private OrderPresenter orderPresenter;
    private int height = SizeUtils.dp2px(150);

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (UserManage.getInstance().getLoginBean() != null) {
            UserManage.getInstance().getUserInfo(MineFragment.this);
        }else {
            MineBean mineBean = new MineBean();
            tvUsername.setText("请先登录");
            GlideuUtil.loadImageView(mContext,"",ivHead);
            tvYudou.setText(0+"");
            tvPurchaseRestrictions.setText("今日可购"+ 0);
            mineBean.initMineBean(0);
            initMenu(mineBean.getMenuBeans());
            initOption(mineBean.getItemBeans());
            loginBean = null;
        }

    }

    public void update(){
        MineBean mineBean = new MineBean();
        if (loginBean != null){
            tvUsername.setText(loginBean.getUserInfo_NickName());
            GlideuUtil.loadImageView(mContext,loginBean.getUserInfo_HeadImg(),ivHead);
            tvYudou.setText(((int) loginBean.getUserInfo_Money())+"");
            tvPurchaseRestrictions.setText("今日可购"+ StringUtil.wanString(loginBean.getUserInfo_TotalMoney()));
            mineBean.initMineBean(loginBean.getUserType());
        }else {
            tvUsername.setText("请先登录");
            GlideuUtil.loadImageView(mContext,"",ivHead);
            tvYudou.setText(0+"");
            tvPurchaseRestrictions.setText("今日可购"+ 0);
            mineBean.initMineBean(0);
        }


        initMenu(mineBean.getMenuBeans());
        initOption(mineBean.getItemBeans());
        orderPresenter = new OrderPresenter(getActivity());
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

//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
////                int y =  oldScrollY - scrollY;
//                if (scrollY <= 0) {   //设置标题的背景颜色
//                    tvTitle.setTextColor(getResources().getColor(R.color.transparent));
//                    llAllTtile.setBackgroundColor(getResources().getColor(R.color.transparent));
//                    vDivider.setBackgroundColor(getResources().getColor(R.color.transparent));
////                    llAllTtile.setBackgroundColor(Color.argb((int) 0, 144,151,166));
//                } else if (scrollY > 0 && scrollY <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
//                    float scale = (float) scrollY / height;
//                    float alpha = (255 * scale);
//                    tvTitle.setTextColor(Color.argb((int) alpha, 36,36,36));
//                    llAllTtile.setBackgroundColor(Color.argb((int) alpha, 255,255,255));
//                    vDivider.setBackgroundColor(Color.argb((int) alpha, 221,221,221));
//                } else {    //滑动到banner下面设置普通颜色
//                    tvTitle.setTextColor(Color.argb((int) 255, 36,36,36));
//                    llAllTtile.setBackgroundColor(Color.argb((int) 255, 255,255,255));
//                    vDivider.setBackgroundColor(Color.argb((int) 255, 221,221,221));
//                }
//            }
//        });
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
                        if (loginBean.getUserType() == 2){
//                            SanActivity.start(mContext);
                            RxPermissions rxPermissions = new RxPermissions(getActivity());
                            rxPermissions
                                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA)
                                    .subscribe(granted -> {
                                        if (granted) {
                                            Intent intent = new Intent(getActivity(), SecondActivity.class);
                                            MineFragment.this.startActivityForResult(intent, REQUEST_CODE);
                                        } else {
                                            ToastUtils.showShort("未开启读写权限，请开启读写");
                                        }
                                    });

                        }else {
                            //赠送记录
                            GiveActivity.start(mContext);
                        }
                        break;
                    case 1:
                        //我的抵用券
                        if (loginBean.getUserType() == 2){
                            GiveActivity.start(mContext);
                        }else {
                            CouponActivity.start(mContext);
                        }
                        break;
                    case 2:
                        if (loginBean.getUserType() == 0){
                            //我要入驻
                            ShopEnter1Activity.start(mContext);
                        }else if (loginBean.getUserType() == 1){
                            //代理商
                            AgentActivity.start(getContext());
                        }else if (loginBean.getUserType() == 2){
                            //发布商品
//                            MyShopActivity.start(mContext);
                            CouponActivity.start(mContext);
//                            ReleaseGoodsActivity.start(getContext());
                        }else if (loginBean.getUserType() == 3){

                        }
                        break;
                    case 3:
                        //成为会员
                        if (loginBean.getUserType() == 2){
                            ReleaseGoodsActivity.start(getContext());
                        }else {
                            AccountRechargeActivity.start(getContext(),1);
                        }
                        break;
                    case 4:
                        //我的收藏
                        if (loginBean.getUserType() == 2){
                            AccountRechargeActivity.start(getContext(),1);
                        }else {
                            MyCollectionActivity.start(mContext);
                        }
                        break;
                    case 5:
                        //收货信息
                        if (loginBean.getUserType() == 2){
                            MyCollectionActivity.start(mContext);
                        }else {
                            AddressManageActivity.start(getContext());
                        }
                        break;
                    case 6:
                        //意见反馈
                        if (loginBean.getUserType() == 2){
                            AddressManageActivity.start(getContext());
                        }else {
                            OpinionBackActivity.start(mContext);
                        }
                        break;
                    case 7:
                        //设置
                        if (loginBean.getUserType() == 2){
                            OpinionBackActivity.start(mContext);
                        }else {
                            UserInfoActivity.start(getContext());
                        }
                        break;
                    case 8:
                        if (loginBean.getUserType() == 2){
                            UserInfoActivity.start(getContext());
                        }
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
                if (loginBean == null) {
                    LoginActivity.start(getContext());
                }else {
                    ShapeActivity.start(getContext());
                }
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    ToastUtils.showShort("解析结果:" + result);
                    new AlertDialog(getContext()).builder()
                            .setTitle("提示")
                            .setMsg("是否要核销该订单")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setPositiveButton("确认", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (UserManage.getInstance().getLoginBean().getStoreInfo() != null) {
                                        showLoading("核销中..");
                                        orderPresenter.confirmused(result, UserManage.getInstance().getLoginBean().getStoreInfo().getId());
                                    }
                                }
                            }).show();

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    ToastUtils.showShort("解析二维码失败");
                }
            }
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
