package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.permissions.RxPermissions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.presenter.yimei.YiMeiPresenter;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.YiMeiSearchAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import static com.whmnrc.qiangbizhong.app.Constants.latitude;
import static com.whmnrc.qiangbizhong.app.Constants.longitude;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 * 医美商品列表
 */

public class YiMeiGoodsListActivity extends BaseActivity implements YiMeiPresenter.SearchCall,TextView.OnEditorActionListener{


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
    @BindView(R.id.et_keyword)
    EditText etKeyword;

    //请求类型
    private int type;


    private YiMeiPresenter yiMeiPresenter;

    private AMapLocationClient mapLocationClient = null;
    private boolean isFrist;

    AMapLocationListener mAMapLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {

            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                    latitude = amapLocation.getLatitude();
                    longitude = amapLocation.getLongitude();
                    if (!isFrist) {
                        req(1);
                        isFrist = true;
                    }
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    LogUtils.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                    if (!isFrist) {
                        showEmpty();
                        isFrist = true;
                    }
                }
            }
        }
    };

    private YiMeiSearchAdapter mYiMeiSearchAdapter;
    private String typeId;

    public static void start(Context context) {
        Intent starter = new Intent(context, YiMeiGoodsListActivity.class);
        context.startActivity(starter);
    }

    public static void start(Context context,String typeId) {
        Intent starter = new Intent(context, YiMeiGoodsListActivity.class);
        starter.putExtra("typeId",typeId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void setData() {
        yiMeiPresenter = new YiMeiPresenter(this);
        mYiMeiSearchAdapter = new YiMeiSearchAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mYiMeiSearchAdapter);
        typeId = getIntent().getStringExtra("typeId");

        refresh.setOnRefreshListener(refreshLayout -> yiMeiPresenter.medicalsearchlist(true, etKeyword.getText().toString(), type, latitude, longitude,typeId, this));
        refresh.setOnLoadMoreListener(refreshLayout -> yiMeiPresenter.medicalsearchlist(false, etKeyword.getText().toString(), type, latitude, longitude,typeId, this));

        etKeyword.setOnEditorActionListener(this);
        initLocation();
        mYiMeiSearchAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                YiMeiGoodsBean yiMeiGoodsBean = (YiMeiGoodsBean) item;
                YiMeiGoodsDetailsActivity.start(YiMeiGoodsListActivity.this,yiMeiGoodsBean.getGoods_ID());
            }
        });
    }

    private void initLocation() {
        mapLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setInterval(10000);
        option.setHttpTimeOut(20000);
        //给定位客户端对象设置定位参数
        mapLocationClient.setLocationOption(option);
        mapLocationClient.setLocationListener(mAMapLocationListener);
        //启动定位
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        mapLocationClient.startLocation();
                    } else {
                        ToastUtils.showShort("未开启定位功能");
                    }
                });
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
        switch (i) {
            case 1:
                type = 0;
                viewItem1.setVisibility(View.VISIBLE);
                tvItem1.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                type = 1;
                viewItem2.setVisibility(View.VISIBLE);
                tvItem2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                type = 2;
                viewItem3.setVisibility(View.VISIBLE);
                tvItem3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }

        showLoading("加载中..");
        yiMeiPresenter.medicalsearchlist(true, etKeyword.getText().toString(), type, latitude, longitude,typeId, this);

    }

    @Override
    protected void onDestroy() {
        if (mapLocationClient != null) {
            mapLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
            mapLocationClient.onDestroy();
            mapLocationClient.setLocationListener(null);
        }
        super.onDestroy();
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }


    @Override
    public void searchGoods(List<YiMeiGoodsBean> yiMeiGoodsBeanList) {
        if (yiMeiGoodsBeanList.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mYiMeiSearchAdapter.addFirstDataSet(yiMeiGoodsBeanList);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<YiMeiGoodsBean> yiMeiGoodsBeanList) {
        mYiMeiSearchAdapter.addMoreDataSet(yiMeiGoodsBeanList);
        refresh.finishLoadMore(true);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            showLoading("加载中..");
            yiMeiPresenter.medicalsearchlist(true, etKeyword.getText().toString().trim(), type, latitude, longitude,typeId, this);
            KeyboardUtils.hideSoftInput(this);
            return true;
        }
        return false;
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_search);
            textView.setText("暂无更多数据~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

}
