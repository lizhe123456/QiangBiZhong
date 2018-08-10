package com.whmnrc.qiangbizhong.widget;

import android.content.Context;
import android.text.InputType;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/24.
 */

public class PayDialogUtil {

    public static void payDialogShow(Context context, AlertEditTextDialog.ConfirmListenter confirmListenter){
        new AlertEditTextDialog(context).builder()
                .setMinTitle("设置支付密码")
                .setTvFundZfPwd(true)
                .setTitle("支付密码")
                .setInputNume(6)
                .setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD)
                .setEidtMsg("请输入支付密码")
                .setPositiveButton("确认", confirmListenter).show();

    }



}
