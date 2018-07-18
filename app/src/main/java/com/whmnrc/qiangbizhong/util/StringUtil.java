package com.whmnrc.qiangbizhong.util;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/17.
 */

public class StringUtil {


    public static String wanString(String s){
        double num = Double.valueOf(s);
        if (num > 10000) {
            int d = (int) (num / 10000);
            return d + "万";
        }else {
            return s;
        }
    }

    public static String wanString(int s){
        double num = s;
        if (num > 10000) {
            int d = (int) (num / 10000);
            return d + "万";
        }else {
            return s+"";
        }
    }
}
