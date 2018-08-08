package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.parameter.SpecParam;
import com.whmnrc.qiangbizhong.presenter.shop.SpecPresenter;
import com.whmnrc.qiangbizhong.util.GsonUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class AddSpecActivity extends BaseActivity implements SpecPresenter.SpecStatuCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_item1)
    EditText etItem1;
    @BindView(R.id.et_item2)
    EditText etItem2;
    @BindView(R.id.et_item3)
    EditText etItem3;
    @BindView(R.id.et_item4)
    EditText etItem4;
    @BindView(R.id.et_item5)
    EditText etItem5;
    @BindView(R.id.et_brand)
    EditText etBrand;

    private SpecPresenter specPresenter;
    private SpecParam specParam;
    private int type;

    public static void start(Context context, SpecParam specParam) {
        Intent starter = new Intent(context, AddSpecActivity.class);
        starter.putExtra("specParam", GsonUtil.createGsonString(specParam));
        context.startActivity(starter);
    }

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, AddSpecActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_add_spec;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        String data = getIntent().getStringExtra("specParam");

        if (TextUtils.isEmpty(data)){
            specParam = new SpecParam();
            specParam.setGoods_ID(getIntent().getStringExtra("goodsId"));
            tvTitle.setText("新增商品规格");
            type = 0;
        }else {
            specParam = GsonUtil.changeGsonToBean(data, SpecParam.class);
            tvTitle.setText("编辑商品规格");
            type = 1;
            if (specParam != null) {
                etItem1.setText(specParam.getGoodsPrice_SpecName() == null ? "" : specParam.getGoodsPrice_SpecName());
                etItem2.setText(specParam.getGoodsPrice_AttrName() == null ? "" : specParam.getGoodsPrice_AttrName());
                etItem3.setText(specParam.getGoodsPrice_Price() == null ? "" : specParam.getGoodsPrice_Price());
                etItem4.setText(specParam.getGoodsPrice_VirtualPrice() == null ? "" : specParam.getGoodsPrice_VirtualPrice());
                etItem5.setText(specParam.getGoodsPrice_Stock() == null ? "" : specParam.getGoodsPrice_Stock());
                etBrand.setText(specParam.getGoodsPrice_Sort() == null ? "" : specParam.getGoodsPrice_Sort());
            }
        }
        specPresenter = new SpecPresenter(this);

    }


    @OnClick({R.id.iv_back, R.id.tv_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_release:
                //新增规格
                if (TextUtils.isEmpty(etItem1.getText().toString())){
                    ToastUtils.showShort("请输入规格");
                    return;
                }
                specParam.setGoodsPrice_SpecName(etItem1.getText().toString());

                if (TextUtils.isEmpty(etItem2.getText().toString())){
                    ToastUtils.showShort("请输入属性");
                    return;
                }
                specParam.setGoodsPrice_AttrName(etItem2.getText().toString());

                if (TextUtils.isEmpty(etItem3.getText().toString())){
                    ToastUtils.showShort("请输入价格");
                    return;
                }
                specParam.setGoodsPrice_Price(etItem3.getText().toString());

                if (TextUtils.isEmpty(etItem4.getText().toString())){
                    ToastUtils.showShort("请输入价格");
                    return;
                }
                specParam.setGoodsPrice_VirtualPrice(etItem4.getText().toString());

                if (TextUtils.isEmpty(etItem5.getText().toString())){
                    ToastUtils.showShort("请输入库存");
                    return;
                }
                specParam.setGoodsPrice_Stock(etItem5.getText().toString());

                if (TextUtils.isEmpty(etBrand.getText().toString())){
                    ToastUtils.showShort("请输入序号");
                    return;
                }
                specParam.setGoodsPrice_Sort(etBrand.getText().toString());

                showLoading("提交中..");
                if (type == 0){
                    specPresenter.addSpec(specParam,this);
                }else if (type == 1){
                    specPresenter.updateSpec(specParam,this);
                }

                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void specBack() {
        ToastUtils.showShort("操作成功");
        this.finish();
    }
}
