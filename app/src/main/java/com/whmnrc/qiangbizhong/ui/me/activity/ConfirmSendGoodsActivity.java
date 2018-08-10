package com.whmnrc.qiangbizhong.ui.me.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.LiveryBean;
import com.whmnrc.qiangbizhong.presenter.me.LiveryPresenter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * Created by admin on 2018/8/10.
 */

public class ConfirmSendGoodsActivity extends BaseActivity implements LiveryPresenter.LiveryPresenterCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.t_item1)
    TextView tItem1;
    @BindView(R.id.et_brand)
    EditText etBrand;

    private LiveryPresenter liveryPresenter;
    private String waybillCompany;
    private String orderId;
    private List<LiveryBean> liveryBeans;

    public static void start(Fragment context,String orderId) {
        Intent starter = new Intent(context.getActivity(), ConfirmSendGoodsActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivityForResult(starter,101);
    }

    public static void start(Activity context, String orderId) {
        Intent starter = new Intent(context, ConfirmSendGoodsActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivityForResult(starter,101);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_send_goods;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("确认发货");
        liveryPresenter = new LiveryPresenter(this,this);
        orderId = getIntent().getStringExtra("orderId");
    }


    @OnClick({R.id.iv_back, R.id.tv_confirm,R.id.rl_wuliu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(waybillCompany)){
                    ToastUtils.showShort("请输入物流公司");
                    return;
                }
                if (TextUtils.isEmpty(etBrand.getText().toString().trim())){
                    ToastUtils.showShort("请输入物流单号");
                    return;
                }
                showLoading("发货中..");
                liveryPresenter.sendGoods(orderId,waybillCompany,etBrand.getText().toString().trim(),this);
                break;
            case R.id.rl_wuliu:
                showLoading("加载中..");
                liveryPresenter.getexpressdelivery();
                break;
        }
    }

    private void showVideoPicker(List<String> list) {
        OptionPicker picker = new OptionPicker(this,list);
        picker.setCycleDisable(false);
        picker.setDividerVisible(false);
        picker.setOffset(2);//偏移量
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                tItem1.setText(item);
                waybillCompany = liveryBeans.get(index).getItemValue();
            }
        });
        picker.show();
    }

    @Override
    public void error() {

    }

    @Override
    public void getexpressdelivery(List<LiveryBean> liveryBeans) {
        this.liveryBeans = liveryBeans;
        List<String> list = new ArrayList<>();
        for (LiveryBean liveryBean : liveryBeans) {
            list.add(liveryBean.getItemName());
        }
        showVideoPicker(list);
    }

    @Override
    public void updateOrder() {
        setResult(105);
        finish();
    }
}
