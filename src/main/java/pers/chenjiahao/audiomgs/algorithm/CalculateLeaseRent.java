package pers.chenjiahao.audiomgs.algorithm;

import pers.chenjiahao.audiomgs.utils.TwoDecimalPlacesUtil;

public class CalculateLeaseRent {
    /**
     * 计算租金
     * @param deposit 租借时缴纳的押金 (默认收取了7天的)
     * @param totalLeaseTime 租借时间
     * @return
     */
    public static Double calculateRent(double deposit,double totalLeaseTime){
        return TwoDecimalPlacesUtil.twoDecimalPlace((deposit / 7) * totalLeaseTime);
    }
}
