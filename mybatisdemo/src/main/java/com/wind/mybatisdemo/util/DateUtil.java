package com.wind.mybatisdemo.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 计算时间
     *
     * @param startTime ： 开始时间
     * @param endTime   ： 结束时间
     * @param pattern   ： 格式，yyyy-MM-dd
     * @return
     */
    public static int caculateTotalTime(String startTime, String endTime, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date1 = null;
        Date date2 = null;
        Long l = 0L;
        try {
            date1 = formatter.parse(startTime);
            long ts1 = date1.getTime();
            date2 = formatter.parse(endTime);
            long ts2 = date2.getTime();

            l = (ts2 - ts1) / (1000 * 60 * 60 * 24);

        } catch (Exception ex) {
        }
        return l.intValue();
    }

    public static String add(String strDate, int amount) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(strDate));
            calendar.add(Calendar.SECOND, amount);
            Date date2 = calendar.getTime();
            return sdf.format(date2.getTime());
        } catch (Exception ex) {
        }
        return null;
    }

    public static Date add(Date date, int amount) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND, amount);
            return calendar.getTime();
        } catch (Exception ex) {
        }
        return null;
    }
}
