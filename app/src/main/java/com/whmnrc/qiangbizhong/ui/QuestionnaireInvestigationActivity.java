package com.whmnrc.qiangbizhong.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.parameter.QuestionnaireParam;
import com.whmnrc.qiangbizhong.presenter.home.QuestionnairePresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/15.
 */

public class QuestionnaireInvestigationActivity extends BaseActivity implements QuestionnairePresenter.QuestionnaireCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_man)
    ImageView ivMan;
    @BindView(R.id.iv_wuman)
    ImageView ivWuman;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.iv_item_4_1)
    ImageView ivItem41;
    @BindView(R.id.iv_item_4_2)
    ImageView ivItem42;
    @BindView(R.id.iv_item_4_3)
    ImageView ivItem43;
    @BindView(R.id.iv_item_4_4)
    ImageView ivItem44;
    @BindView(R.id.iv_item_4_5)
    ImageView ivItem45;
    @BindView(R.id.iv_item_4_6)
    ImageView ivItem46;
    @BindView(R.id.iv_item_4_7)
    ImageView ivItem47;
    @BindView(R.id.iv_item_4_8)
    ImageView ivItem48;
    @BindView(R.id.iv_item_5_1)
    ImageView ivItem51;
    @BindView(R.id.iv_item_5_2)
    ImageView ivItem52;
    @BindView(R.id.iv_item_6_1)
    ImageView ivItem61;
    @BindView(R.id.iv_item_6_2)
    ImageView ivItem62;
    @BindView(R.id.iv_item_6_3)
    ImageView ivItem63;
    @BindView(R.id.iv_item_6_4)
    ImageView ivItem64;
    @BindView(R.id.iv_item_7_1)
    ImageView ivItem71;
    @BindView(R.id.iv_item_7_2)
    ImageView ivItem72;
    @BindView(R.id.iv_item_7_3)
    ImageView ivItem73;
    @BindView(R.id.iv_item_7_4)
    ImageView ivItem74;
    @BindView(R.id.iv_item_7_5)
    ImageView ivItem75;
    @BindView(R.id.iv_item_7_6)
    ImageView ivItem76;
    @BindView(R.id.iv_item_7_7)
    ImageView ivItem77;
    
    private QuestionnairePresenter questionnairePresenter;
    private String sex;
    private String item4;
    private String item5;
    private String item6;
    private String item7;
    private DatePickerDialog datePickerDialog;

    public static void start(Context context) {
        Intent starter = new Intent(context, QuestionnaireInvestigationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_questionnaire_investigation;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("调查问卷");
        questionnairePresenter = new QuestionnairePresenter(this);
        datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tvBirthday.setText(year+"年"+month+"月"+dayOfMonth+"日");
            }
        });
    }


    @OnClick({R.id.tv_birthday,R.id.iv_back, R.id.iv_man, R.id.iv_wuman, R.id.iv_item_4_1, R.id.iv_item_4_2, R.id.iv_item_4_3, R.id.iv_item_4_4, R.id.iv_item_4_5, R.id.iv_item_4_6, R.id.iv_item_4_7, R.id.iv_item_4_8, R.id.iv_item_5_1, R.id.iv_item_5_2, R.id.iv_item_6_1, R.id.iv_item_6_2, R.id.iv_item_6_3, R.id.iv_item_6_4, R.id.iv_item_7_1, R.id.iv_item_7_2, R.id.iv_item_7_3, R.id.iv_item_7_4, R.id.iv_item_7_5, R.id.iv_item_7_6, R.id.iv_item_7_7, R.id.tv_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_birthday:
                datePickerDialog.show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_man:
                sex = "男";
                ivWuman.setImageResource(R.drawable.ic_selece_no);
                ivMan.setImageResource(R.drawable.ic_select);
                break;
            case R.id.iv_wuman:
                sex = "女";
                ivWuman.setImageResource(R.drawable.ic_select);
                ivMan.setImageResource(R.drawable.ic_selece_no);
                break;
            case R.id.iv_item_4_1:
                init4(1);
                break;
            case R.id.iv_item_4_2:
                init4(2);
                break;
            case R.id.iv_item_4_3:
                init4(3);
                break;
            case R.id.iv_item_4_4:
                init4(4);
                break;
            case R.id.iv_item_4_5:
                init4(5);
                break;
            case R.id.iv_item_4_6:
                init4(6);
                break;
            case R.id.iv_item_4_7:
                init4(7);
                break;
            case R.id.iv_item_4_8:
                init4(8);
                break;
            case R.id.iv_item_5_1:
                init5(1);
                break;
            case R.id.iv_item_5_2:
                init5(2);
                break;
            case R.id.iv_item_6_1:
                init6(1);
                break;
            case R.id.iv_item_6_2:
                init6(2);
                break;
            case R.id.iv_item_6_3:
                init6(3);
                break;
            case R.id.iv_item_6_4:
                init6(4);
                break;
            case R.id.iv_item_7_1:
                init7(1);
                break;
            case R.id.iv_item_7_2:
                init7(2);
                break;
            case R.id.iv_item_7_3:
                init7(3);
                break;
            case R.id.iv_item_7_4:
                init7(4);
                break;
            case R.id.iv_item_7_5:
                init7(5);
                break;
            case R.id.iv_item_7_6:
                init7(6);
                break;
            case R.id.iv_item_7_7:
                init7(7);
                break;
            case R.id.tv_release:
                submit();
                break;
        }
    }

    private void init6(int i) {
        ivItem61.setImageResource(R.drawable.ic_selece_no);
        ivItem62.setImageResource(R.drawable.ic_selece_no);
        ivItem63.setImageResource(R.drawable.ic_selece_no);
        ivItem64.setImageResource(R.drawable.ic_selece_no);

        switch (i){
            case 1:
                item6 = "IOS APP客户端";
                ivItem61.setImageResource(R.drawable.ic_select);
                break;
            case 2:
                item6 = "Andriod APP客户端";
                ivItem62.setImageResource(R.drawable.ic_select);
                break;
            case 3:
                item6 = "艾美链微信公众号";
                ivItem63.setImageResource(R.drawable.ic_select);
                break;
            case 4:
                item6 = "其他";
                ivItem64.setImageResource(R.drawable.ic_select);
                break;

        }

    }

    private void init5(int i) {
        ivItem51.setImageResource(R.drawable.ic_selece_no);
        ivItem52.setImageResource(R.drawable.ic_selece_no);

        switch (i){
            case 1:
                item5 = "使用过";
                ivItem51.setImageResource(R.drawable.ic_select);
                break;
            case 2:
                item5 = "没使用过";
                ivItem52.setImageResource(R.drawable.ic_select);
                break;
        }

    }

    private void init7(int i) {
        ivItem71.setImageResource(R.drawable.ic_selece_no);
        ivItem72.setImageResource(R.drawable.ic_selece_no);
        ivItem73.setImageResource(R.drawable.ic_selece_no);
        ivItem74.setImageResource(R.drawable.ic_selece_no);
        ivItem75.setImageResource(R.drawable.ic_selece_no);
        ivItem76.setImageResource(R.drawable.ic_selece_no);
        ivItem77.setImageResource(R.drawable.ic_selece_no);
        switch (i){
            case 1:
                item7 = "苹果手机";
                ivItem71.setImageResource(R.drawable.ic_select);
                break;
            case 2:
                item7 = "华为";
                ivItem72.setImageResource(R.drawable.ic_select);
                break;
            case 3:
                item7 = "OPPO";
                ivItem73.setImageResource(R.drawable.ic_select);
                break;
            case 4:
                item7 = "VIVO";
                ivItem74.setImageResource(R.drawable.ic_select);
                break;
            case 5:
                item7 = "三星";
                ivItem75.setImageResource(R.drawable.ic_select);
                break;
            case 6:
                item7 = "小米";
                ivItem76.setImageResource(R.drawable.ic_select);
                break;
            case 7:
                item7 = "其他";
                ivItem77.setImageResource(R.drawable.ic_select);
                break;

        }
    }

    private void init4(int type) {
        ivItem41.setImageResource(R.drawable.ic_selece_no);
        ivItem42.setImageResource(R.drawable.ic_selece_no);
        ivItem43.setImageResource(R.drawable.ic_selece_no);
        ivItem44.setImageResource(R.drawable.ic_selece_no);
        ivItem45.setImageResource(R.drawable.ic_selece_no);
        ivItem46.setImageResource(R.drawable.ic_selece_no);
        ivItem47.setImageResource(R.drawable.ic_selece_no);
        ivItem48.setImageResource(R.drawable.ic_selece_no);
        switch (type){
            case 1:
                item4 = "朋友口碑、亲友推荐当面吹的";
                ivItem41.setImageResource(R.drawable.ic_select);
                break;
            case 2:
                item4 = "微信朋友圈翻到的";
                ivItem42.setImageResource(R.drawable.ic_select);
                break;
            case 3:
                item4 = "微信公众号文章读来的";
                ivItem43.setImageResource(R.drawable.ic_select);
                break;
            case 4:
                item4 = "艾美链来单位提供过企业服务";
                ivItem44.setImageResource(R.drawable.ic_select);
                break;
            case 5:
                item4 = "百度等搜的";
                ivItem45.setImageResource(R.drawable.ic_select);
                break;
            case 6:
                item4 = "手机应用市场搜索到的";
                ivItem46.setImageResource(R.drawable.ic_select);
                break;
            case 7:
                item4 = "58到家、美团、hao123等网站";
                ivItem47.setImageResource(R.drawable.ic_select);
                break;
            case 8:
                item4 = "其他";
                ivItem48.setImageResource(R.drawable.ic_select);
                break;

        }

    }

    private void submit() {
        List<QuestionnaireParam> questionnaireParams = new ArrayList<>();
        if (!RegexUtils.isMobileSimple(etPhone.getText())){
            ToastUtils.showShort("手机号格式有误");
            return;
        }
        QuestionnaireParam questionnaireParam6 = new QuestionnaireParam();
        questionnaireParam6.setQuestionId("6");
        questionnaireParam6.setQuestionValue(sex);
        questionnaireParams.add(questionnaireParam6);
        if (TextUtils.isEmpty(sex)){
            ToastUtils.showShort("请选择性别");
            return;
        }
        QuestionnaireParam questionnaireParam = new QuestionnaireParam();
        questionnaireParam.setQuestionId("2");
        questionnaireParam.setQuestionValue(sex);
        questionnaireParams.add(questionnaireParam);
        if (TextUtils.isEmpty(tvBirthday.getText().toString())){
            ToastUtils.showShort("请输入生日");
            return;
        }
        QuestionnaireParam questionnaireParam1 = new QuestionnaireParam();
        questionnaireParam1.setQuestionId("3");
        questionnaireParam1.setQuestionValue(tvBirthday.getText().toString());
        questionnaireParams.add(questionnaireParam1);

        if (TextUtils.isEmpty(item4)){
            ToastUtils.showShort("请选择了解渠道");
            return;
        }
        QuestionnaireParam questionnaireParam2 = new QuestionnaireParam();
        questionnaireParam2.setQuestionId("4");
        questionnaireParam2.setQuestionValue(item4);
        questionnaireParams.add(questionnaireParam2);

        if (TextUtils.isEmpty(item5)){
            ToastUtils.showShort("请选择否使用过艾美链");
            return;
        }
        QuestionnaireParam questionnaireParam3 = new QuestionnaireParam();
        questionnaireParam3.setQuestionId("5");
        questionnaireParam3.setQuestionValue(item5);
        questionnaireParams.add(questionnaireParam3);

        if (TextUtils.isEmpty(item6)){
            ToastUtils.showShort("请选择您在哪个渠道使用艾美链");
            return;
        }
        QuestionnaireParam questionnaireParam4 = new QuestionnaireParam();
        questionnaireParam4.setQuestionId("6");
        questionnaireParam4.setQuestionValue(item6);
        questionnaireParams.add(questionnaireParam4);

        if (TextUtils.isEmpty(item7)){
            ToastUtils.showShort("请选择您的手机品牌");
            return;
        }
        QuestionnaireParam questionnaireParam5 = new QuestionnaireParam();
        questionnaireParam5.setQuestionId("7");
        questionnaireParam5.setQuestionValue(item7);
        questionnaireParams.add(questionnaireParam5);
        showLoading("提交中..");
        questionnairePresenter.submitquestion(etPhone.getText().toString(),questionnaireParams,this);

    }

    @Override
    public void error() {

    }

    @Override
    public void submitS() {
        this.finish();
    }
}
