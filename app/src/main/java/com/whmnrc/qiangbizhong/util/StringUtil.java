package com.whmnrc.qiangbizhong.util;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/17.
 */

public class StringUtil {

    public static String wanString(double value){
//        if ((double) s > 10000) {
//            NumberFormat nf = NumberFormat.getNumberInstance();
//            double d = (double) ((double) s / 10000);
//            // 保留两位小数
//            nf.setMaximumFractionDigits(2);
//            // 如果不需要四舍五入，可以使用RoundingMode.DOWN
//            nf.setRoundingMode(RoundingMode.DOWN);
//            return nf.format(d) + "万";
//        }else {
//            NumberFormat nf1 = NumberFormat.getInstance();
//            nf1.format(s);
//
//            return subZeroAndDot(s + "");
//        }
        if(value != 0.00){
            String string;
            if (value > 100000) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
                string = df.format(value);
            }else {
                java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                string = df.format(value);
            }
            return subZeroAndDot(string);
        }else{
            return "0";
        }

    }

    public static String mString(double value) {
        if(value != 0.00){
            String string;
            if (value > 100000) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
                string = df.format(value);
            }else {
                java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                string = df.format(value);
            }
            return subZeroAndDot(string);
        }else{
            return "0";
        }
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public static String kmString(double d){
        double s = (double) ((double) d / 1000);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.DOWN);
        return nf.format(s)+"km";
    }



}
