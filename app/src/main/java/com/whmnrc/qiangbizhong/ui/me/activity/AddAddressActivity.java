package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressJsonBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddAddressActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.tt_item2)
    TextView ttItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_isDefault)
    TextView tvDefault;

    private OptionsPickerView mOptionsPickerView;

    private String item1Id;
    private String item2Id;
    private String item3Id;

    private boolean isDefault;
    private AddressPresenter addressPresenter;
    private Map<String,String> params = new HashMap<>();


    public static void start(Context context) {
        Intent starter = new Intent(context, AddAddressActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void setData() {
        tvTitle.setText("新增收货地址");
        ivBack.setVisibility(View.VISIBLE);
        addressPresenter = new AddressPresenter(this);
        initJsonData();
        initPickerView();
    }

    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private ArrayList<String> options1Items = new ArrayList<>();
    private List<AddressJsonBean> jsonBean;

    //城市json数据初始化
    private void initJsonData() {
        jsonBean = GsonUtil.changeGsonToList(getJson(this, "city.json"), AddressJsonBean.class);
        for (int i = 0; i < jsonBean.size(); i++) {
            options1Items.add(jsonBean.get(i).getAreaName());
            ArrayList<String> CityList = new ArrayList<>();
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();
            for (int c = 0; c < jsonBean.get(i).getCities().size(); c++) {
                String CityName = jsonBean.get(i).getCities().get(c).getAreaName();
                CityList.add(CityName);
                ArrayList<String> City_AreaList = new ArrayList<>();
                if (jsonBean.get(i).getCities().get(c).getCounties() == null
                        || jsonBean.get(i).getCities().get(c).getCounties().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCities().get(c).getCounties().size(); d++) {
                        String AreaName = jsonBean.get(i).getCities().get(c).getCounties().get(d).getAreaName();
                        //添加该城市所有地区数据
                        City_AreaList.add(AreaName);
                    }
                }
                //添加该省所有地区数据
                Province_AreaList.add(City_AreaList);
            }
            //添加城市数据
            options2Items.add(CityList);
            //添加地区数据
            options3Items.add(Province_AreaList);
        }
    }

    //选择器初始化
    private void initPickerView() {
        mOptionsPickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                tvItem1.setText(options1Items.get(options1));
                ttItem2.setText(options2Items.get(options1).get(options2));
                tvItem3.setText(options3Items.get(options1).get(options2).get(options3));
                item1Id = jsonBean.get(options1).getAreaId();
                item2Id = jsonBean.get(options1).getCities().get(options2).getAreaId();
                item3Id = jsonBean.get(options1).getCities().get(options2).getCounties().get(options3).getAreaId();
//                LogUtils.e(item1Id,item2Id,item3Id);
            }
        })
                .setTitleText("城市选择")
                .setCyclic(false, false, false)
                .setDividerColor(R.color.tv_999)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();
        //三级选择器
        mOptionsPickerView.setPicker(options1Items, options2Items, options3Items);
    }

    //获取.json文件转为string
    public String getJson(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }




    @OnClick({R.id.tv_item1, R.id.tt_item2, R.id.tv_item3,R.id.iv_back,R.id.tv_isDefault,R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_item1:
            case R.id.tt_item2:
            case R.id.tv_item3:
                mOptionsPickerView.show();
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_isDefault:
                if (!isDefault){
                    isDefault = true;
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_select);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvDefault.setCompoundDrawables(null, null, nav_up, null);
                }else {
                    isDefault = false;
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvDefault.setCompoundDrawables(null, null, nav_up, null);
                }
                break;
            case R.id.tv_confirm:
                params.put("Address_IsDefault",isDefault == true ? "1" : "0");
                params.put("UserInfo_ID", UserManage.getInstance().getUserID());
                if (TextUtils.isEmpty(etName.getText().toString())){
                    ToastUtils.showShort("收货人不能为空");
                    return;
                }
                params.put("Address_Name",etName.getText().toString());

                if (TextUtils.isEmpty(etPhone.getText().toString())){
                    ToastUtils.showShort("手机号不能为空");
                    return;
                }
                params.put("Address_Mobile",etPhone.getText().toString());

                if (TextUtils.isEmpty(item1Id) && TextUtils.isEmpty(item2Id) && TextUtils.isEmpty(item3Id)){
                    ToastUtils.showShort("请选择城市");
                    return;
                }
                params.put("Address_Region",item3Id);
                params.put("Address_City",item2Id );
                params.put("Address_Provice", item1Id);

                if (TextUtils.isEmpty(etAddress.getText().toString())){
                    ToastUtils.showShort("详细地址不能为空");
                    return;
                }
                params.put("Address_Detail",etAddress.getText().toString());
                showLoading("提交中");
                addressPresenter.addAddress(params,this::addressBack);
                break;
        }
    }

    private void addressBack() {
        ToastUtils.showShort("添加成功");
        this.finish();
    }
}
