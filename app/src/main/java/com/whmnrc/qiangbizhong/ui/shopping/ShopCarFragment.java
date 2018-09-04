package com.whmnrc.qiangbizhong.ui.shopping;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.model.bean.SpecBean;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.SpecPresenter;
import com.whmnrc.qiangbizhong.presenter.shopcar.ShopCarPresenter;
import com.whmnrc.qiangbizhong.ui.shop.bean.OrderBeanReq;
import com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity;
import com.whmnrc.qiangbizhong.ui.shopping.adpter.ShopCarAdapter;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.SelectParamPopupWindow;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class ShopCarFragment extends BaseFragment implements ShopCarPresenter.CarCall
        ,SpecPresenter.GoodsSpecCall,ShopCarPresenter.CarStatuCall,CollectionPresenter.CollectionCall{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_all_select)
    TextView tvAllSelect;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.ll_total)
    LinearLayout llTotal;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private List<ShopCarBean> shopCarBeans;
    private ShopCarAdapter shopCarAdapter;
    private ShopCarPresenter mShopCarPresenter;
    private CollectionPresenter mCollectionPresenter;
    private SpecPresenter mSpecPresenter;
    private boolean isEdit;

    private boolean isAll;


    private int zS;

    @Override
    public void onResume() {
        super.onResume();
        if (mShopCarPresenter != null){
            if (UserManage.getInstance().getLoginBean() != null) {
                mShopCarPresenter.getcarlist(this);
            }
        }
    }

    private int sposition;
    private int fposition;
    private String cid;



    public static ShopCarFragment newInstance() {
        Bundle args = new Bundle();
        ShopCarFragment fragment = new ShopCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_car;
    }

    @Override
    protected void initData() {
        tvTitle.setText("购物车");
        tvMenu.setText("编辑");
        tvMenu.setTextColor(mContext.getResources().getColor(R.color.tv_191));
        tvMenu.setVisibility(View.VISIBLE);
        mShopCarPresenter = new ShopCarPresenter(getActivity());
        mSpecPresenter = new SpecPresenter(getActivity());
        mCollectionPresenter = new CollectionPresenter(getActivity());
        showLoading("加载中..");
        mShopCarPresenter.getcarlist(this);
        rvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        shopCarAdapter = new ShopCarAdapter(getContext(),mShopCarPresenter);
        rvGoodsList.setAdapter(shopCarAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                Drawable drawableLeft = getResources().getDrawable(
                        R.drawable.ic_selece_no);
                tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
                mShopCarPresenter.getcarlist(ShopCarFragment.this);
            }
        });
        shopCarAdapter.setOnEditCall(new ShopCarAdapter.OnEditCall() {

            @Override
            public void jiaOrjian(int position,String carId, int type) {

            }

            @Override
            public void updateSpec(int fposition,int position,String carId, String goodsId) {
                //请求规格接口，弹出选择规格框，选择规格，修改购物车信息
                sposition = position;
                ShopCarFragment.this.fposition = fposition;
                ShopCarFragment.this.cid = carId;
                showLoading("加载中..");
                mSpecPresenter.getgoodsspecattr(goodsId,ShopCarFragment.this);
            }

            @Override
            public void heji() {
                //合计后修改价格
                ShopCarFragment.this.heji();
            }

            @Override
            public void isAll() {
                //改变全选按钮
                if (ShopCarFragment.this.isAll()){
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_select);
                    tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
                }else {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_selece_no);
                    tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
                }
            }

            @Override
            public void sonSelect(int position) {
                shopCarAdapter.setSelect(position,true);
            }

            @Override
            public void updateData() {
                mShopCarPresenter.getcarlist(ShopCarFragment.this);
            }
        });
    }

    //是否全选
    private boolean isAll(){
        boolean isAll = false;
        for (ShopCarBean shopCarBean : shopCarAdapter.getDataSource()) {
            if (shopCarBean.isSelect()){
                for (ShopCarBean.GoodsBean goodsBean: shopCarBean.getGoods()) {
                    if (goodsBean.isSelect()){
                        isAll = true;
                    }else {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return isAll;
    }


    @OnClick({R.id.tv_all_select, R.id.tv_collection, R.id.tv_delete, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_all_select:
                //全选
                if (!isAll){
                    isAll = true;
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_select);
                    tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
                    shopCarAdapter.allSelect(true);
                }else {
                    isAll = false;
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_selece_no);
                    tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
                    shopCarAdapter.allSelect(false);
                }
                ShopCarFragment.this.heji();
                break;
            case R.id.tv_collection:
                //批量移入收藏夹
                collection();
                break;
            case R.id.tv_delete:
                if (isEdit){
                    //批量删除购物车
                    delete();
                }else {
                    //结算
                    buy();
                }
                break;
            case R.id.tv_menu:
                if (shopCarAdapter != null){
                    if (isEdit){
                        isEdit = false;
                        tvMenu.setText("编辑");
                        shopCarAdapter.setEdit(false);
                        llTotal.setVisibility(View.VISIBLE);
                        tvCollection.setVisibility(View.GONE);
                        tvDelete.setText("结算("+zS+")");
                    }else {
                        isEdit = true;
                        tvMenu.setText("完成");
                        shopCarAdapter.setEdit(true);
                        llTotal.setVisibility(View.GONE);
                        tvCollection.setVisibility(View.VISIBLE);
                        tvDelete.setText("删除");
                    }
                }

                break;
        }
    }

    //收藏
    public void collection(){
        List<String> list = new ArrayList<>();
        for (ShopCarBean shopCarBean : shopCarAdapter.getDataSource()) {
            for (ShopCarBean.GoodsBean goodsBean : shopCarBean.getGoods()) {
                if (goodsBean.isSelect()){
                    list.add(goodsBean.getGoods_ID());
                }
            }
        }
        if (list.size() > 0) {
            mCollectionPresenter.addcollectionlist(list,this);
        }else {
            ToastUtils.showShort("未选中商品");
        }
    }

    //移除
    public void delete(){
        List<String> list = new ArrayList<>();
        for (ShopCarBean shopCarBean : shopCarAdapter.getDataSource()) {
            for (ShopCarBean.GoodsBean goodsBean : shopCarBean.getGoods()) {
                if (goodsBean.isSelect()){
                    list.add(goodsBean.getBuyCar_ID());
                }
            }
        }
        if (list.size() > 0) {
            new AlertDialog(getContext()).builder().setCancelable(true)
                    .setTitle("提示")
                    .setNegativeButton("取消", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    })
                    .setPositiveButton("确认", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mShopCarPresenter.deletecars(list,ShopCarFragment.this);
                }
            }).setMsg("确定要删除吗?").show();
        }else {
            ToastUtils.showShort("未选中商品");
        }
    }

    public void buy(){
        List<ShopCarBean> shopCarBeans = new ArrayList<>();
        for (ShopCarBean shopCarBean :shopCarAdapter.getDataSource()) {
            if (shopCarBean.isSelect()){
                ShopCarBean shopCarBean1 = shopCarBean;
                List<ShopCarBean.GoodsBean> list = new ArrayList<>();
                for (ShopCarBean.GoodsBean goodsBean : shopCarBean1.getGoods()) {
                    if (goodsBean.isSelect()){
                        list.add(goodsBean);
                    }
                    shopCarBean1.setGoods(list);
                }
                shopCarBeans.add(shopCarBean1);
            }
        }
        if (zS > 0) {
            ShopConfirmOrderActivity.start(getContext(), shopCarBeans, tvMoeny.getText().toString());
        }else {
            ToastUtils.showShort("未选中任何商品");
        }
    }

    //合计
    private void heji(){
        double num = 0;
        zS = 0;
        for (ShopCarBean shopCarBean :shopCarAdapter.getDataSource()) {
            for (ShopCarBean.GoodsBean goodsBean :shopCarBean.getGoods()) {
                if (goodsBean.isSelect()){
                    num += goodsBean.getGoodsPrice_Price() * (double) goodsBean.getBuyCar_Num();
                    zS += goodsBean.getBuyCar_Num();
                }
            }
        }
        tvMoeny.setText(StringUtil.wanString(num));
        if (isEdit) {
            tvDelete.setText("删除");
        }else {
            tvDelete.setText("结算(" + zS + ")");
        }
    }

    @Override
    public void error() {
        refresh.finishRefresh(true);
    }

    @Override
    public void showCarList(List<ShopCarBean> shopCarBeans) {
        if (shopCarBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            rvGoodsList.setVisibility(View.VISIBLE);
        }
        shopCarAdapter.addFirstDataSet(shopCarBeans);
        refresh.finishRefresh(true);
        isAll = false;
        Drawable drawableLeft = getResources().getDrawable(
                R.drawable.ic_selece_no);
        tvAllSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null ,null);
        shopCarAdapter.allSelect(false);
        heji();
    }


    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_shopcar);
            textView.setVisibility(View.GONE);
        }
        vsEmpty.setVisibility(View.VISIBLE);
        rvGoodsList.setVisibility(View.GONE);
    }

    @Override
    public void spceBack(SpecBean specBean) {
        SelectParamPopupWindow selectParamPopupWindow = new SelectParamPopupWindow(getActivity(),specBean,0);
        selectParamPopupWindow.showPop(getActivity().getCurrentFocus(),getActivity());
        selectParamPopupWindow.setOnCancelListener(new SelectParamPopupWindow.OnCancelListener() {
            @Override
            public void onCancel() {
                //无需操作
            }

            @Override
            public void onBuy(OrderBeanReq orderBeanReq) {
                showLoading("修改中..");

                mShopCarPresenter.updatecar(cid,orderBeanReq.getGoodsId(),orderBeanReq.getPriceId(),ShopCarFragment.this);
            }

            @Override
            public void onAddCar(String goodsId, String priceId, int count) {
                //无需操作
            }
        });
    }

    @Override
    public void csS() {

    }

    @Override
    public void updateS() {
        mShopCarPresenter.getcarlist(this);

    }

    @Override
    public void jj() {

    }


    @Override
    public void deleteCar() {
        mShopCarPresenter.getcarlist(this);

    }

    @Override
    public void cS() {

    }
}
