package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressJsonBean;
import com.whmnrc.qiangbizhong.model.bean.DataSave;
import com.whmnrc.qiangbizhong.util.GsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnter4Activity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_kaihu_hao)
    EditText tvKaihuHao;
    @BindView(R.id.tv_kaihu_name)
    EditText tvKaihuName;
    @BindView(R.id.tv_city)
    EditText tvCity;
    @BindView(R.id.tv_band_hao_2)
    EditText tvBandHao2;
    @BindView(R.id.tv_kaihu_city)
    TextView tvKaihuCity;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private ShopEnterP shopEnterP;

    private OptionsPickerView mOptionsPickerView;


    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private ArrayList<String> options1Items = new ArrayList<>();
    private List<AddressJsonBean> jsonBean;

    public static void start(Context context, ShopEnterP shopEnterP) {
        Intent starter = new Intent(context, ShopEnter4Activity.class);
        DataSave.setValue(shopEnterP);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter4;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
        shopEnterP = DataSave.getValue();
        initJsonData();
        initPickerView();
    }



    @OnClick({R.id.iv_back, R.id.tv_confirm,R.id.tv_kaihu_city})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(tvKaihuHao.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行账号");
                    return;
                }
                shopEnterP.setSettlementBankAccount(tvKaihuHao.getText().toString().trim());


                if (TextUtils.isEmpty(tvKaihuName.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行名称");
                    return;
                }
                shopEnterP.setBankName(tvKaihuName.getText().toString().trim());


                if (TextUtils.isEmpty(tvCity.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行支行名称");
                    return;
                }
                shopEnterP.setBankBranchName(tvCity.getText().toString().trim());

                if (TextUtils.isEmpty(tvBandHao2.getText().toString().trim())){
                    ToastUtils.showShort("请填写银行账号");
                    return;
                }
                shopEnterP.setBankAccount(tvBandHao2.getText().toString().trim());

                if (TextUtils.isEmpty(tvKaihuCity.getText().toString().trim())){
                    ToastUtils.showShort("请选择开户行所在地");
                    return;
                }
                shopEnterP.setSettlementBankName(tvKaihuCity.getText().toString().trim());

                ShopEnter5Activity.start(this,shopEnterP);
                break;
            case R.id.tv_kaihu_city:
                if (KeyboardUtils.isSoftInputVisible(this)){
                    KeyboardUtils.hideSoftInput(this);
                }
                mOptionsPickerView.show();
                break;
        }
    }

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
                tvKaihuCity.setText(options1Items.get(options1) + options2Items.get(options1).get(options2) + options3Items.get(options1).get(options2).get(options3));
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
}
