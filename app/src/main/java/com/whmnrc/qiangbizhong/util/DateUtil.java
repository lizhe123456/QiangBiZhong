package com.whmnrc.qiangbizhong.util;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class DateUtil {

    public static String getDate(String date){
        long time = TimeUtils.getTimeSpanByNow(date, TimeConstants.SEC);
        Date date1 = new Date(time); // long类型转成Date类型
        return TimeUtils.date2String(date1,  new SimpleDateFormat("HH:dd:ss"));
    }
}
