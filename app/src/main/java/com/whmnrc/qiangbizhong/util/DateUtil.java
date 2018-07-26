package com.whmnrc.qiangbizhong.util;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class DateUtil {

    public static String getDate(String date){
        String serverTime = UserManage.getInstance().getServerTime();
        long now = com.whmnrc.qiangbizhong.util.TimeUtils.string2Milliseconds(serverTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        long start = com.whmnrc.qiangbizhong.util.TimeUtils.string2Milliseconds(date, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        long time = start - now;
        if (time > 0) {
            long day = time / (24 * 60 * 60 * 1000);
            long hour = (time / (60 * 60 * 1000) - day * 24);
            long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long ss = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            return ((int) ((int) hour + (day * 24)) < 10 ? "0" + ((int) hour + (day * 24)) : (int) hour + (day * 24)) +":"+((int) min < 10 ? "0" + (int) min : (int) min) +":"+ ((int) ss < 10 ? "0" + (int) ss : (int) ss);
        }else {
            return "00:00:00";
        }
    }
}
