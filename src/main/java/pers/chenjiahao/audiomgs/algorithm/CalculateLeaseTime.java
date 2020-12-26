package pers.chenjiahao.audiomgs.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateLeaseTime {
    /**
     * 租借时间计算(2月默认28天)
     * @param startLeaseTime 租借日期
     * @param returnDate 退还日期
     * @return 天数:小时/24
     */
    public static double calculateTime(Date startLeaseTime,Date returnDate){
        long startTime = format(startLeaseTime);
        long endTime = format(returnDate);
        long total = endTime - startTime;
        return total / 86400000.0;
    }

    private static long format(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            time = simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }




    public static double calculateTime(String time1,String time2){
        long startTime = format(time1);
        long endTime = format(time2);
        long total = endTime - startTime;
        System.out.println(total / 86400000.0);
        return 0;
    }

    private static long format(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            time = simpleDateFormat.parse(s).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
