package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.AddAddressActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 */

public class SelectAddressActivity extends BaseActivity implements AddressPresenter.AddManageCall{
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.v_divider)
    View vDivider;
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    AddressAdapter addressAdapter;

    AddressPresenter addressPresenter;

    public static void start(Activity context) {
        Intent starter = new Intent(context, SelectAddressActivity.class);
        context.startActivityForResult(starter,102);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addressPresenter.getaddressList(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_select_address;
    }

    @Override
    protected void setData() {
        tvTitle.setText("选择地址");
        tvMenu.setText("新增");
        ivBack.setVisibility(View.VISIBLE);
        tvMenu.setVisibility(View.VISIBLE);
        addressAdapter = new AddressAdapter(this);
        addressPresenter = new AddressPresenter(this);
//        addressPresenter.getaddressList(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(addressAdapter);
        addressAdapter.setOnItemClickListener((view, item, position) -> {
            AddressBean addressBean = (AddressBean) item;
            Intent intent = new Intent();
            intent.putExtra("address",addressBean);
            setResult(101,intent);
            finish();
        });
    }

    @OnClick({R.id.tv_menu,R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_menu:
                AddAddressActivity.start(this);
                break;
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    public void getAddressList(List<AddressBean> list) {
        if (list.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAddress_IsDefault() == 1){
                AddressBean addressBean = list.remove(i);
                list.add(0,addressBean);
            }
        }
        addressAdapter.addFirstDataSet(list);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void error() {

    }

    class AddressAdapter extends BaseAdapter<AddressBean>{

        private AddressAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, AddressBean item, int position) {
            if (item.getAddress_IsDefault() == 1){
                holder.setVisible(R.id.tv_isDefault,true);
            }else{
                holder.setVisible(R.id.tv_isDefault,false);
            }

            holder.setText(R.id.tv_name,item.getAddress_Name())
                    .setText(R.id.tv_phone,item.getAddress_Mobile())
                    .setText(R.id.tv_address,item.getProviceName()+item.getCityName()+item.getRegionName()+item.getAddress_Detail());
        }

        @Override
        protected int getItemViewLayoutId(int position, AddressBean item) {
            return R.layout.item_select_address;
        }
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_address);
            textView.setText("暂无收货地址~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }


}
