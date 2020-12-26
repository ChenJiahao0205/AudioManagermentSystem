package pers.chenjiahao.audiomgs.utils;

import java.text.DecimalFormat;

public class TwoDecimalPlacesUtil {
    public static double twoDecimalPlace(double src){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.parseDouble(decimalFormat.format(src));
    }
}
