package com.whmnrc.qiangbizhong.util;

import java.math.RoundingMode;
import java.text.NumberFormat;

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

    public static String wanString(double s){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if ((double) s > 10000) {
            double d = (double) ((double) s / 10000);
            // 保留两位小数
            nf.setMaximumFractionDigits(2);
            // 如果不需要四舍五入，可以使用RoundingMode.DOWN
            nf.setRoundingMode(RoundingMode.DOWN);
            return nf.format(d) + "万";
        }else {
//            nf.setMaximumFractionDigits(2);
//            // 如果不需要四舍五入，可以使用RoundingMode.DOWN
//            nf.setRoundingMode(RoundingMode.DOWN);
            return ((int)(s))+"";
        }
    }

    public static String kmString(double d){
        double s = (double) ((double) d / 1000);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.DOWN);
        return nf.format(s)+"km";
    }

    public static String weiString1(double d){
        java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.00");
        String str = myformat.format(d);
        return str;
    }

}
