package edu.hsl.myappweather.util;

/**
 * Created by Administrator on 2016/5/26.
 */
public class WeekUtil {
    public static String getWeek(Object week_object) {
        String week = null;
        if (week_object instanceof Integer) {
            int week_int = (int) week_object;
            switch (week_int) {
                case 1:
                    week = "一";
                    break;
                case 2:
                    week = "二";
                    break;
                case 3:
                    week = "三";
                    break;
                case 4:
                    week = "四";
                    break;
                case 5:
                    week = "五";
                    break;
                case 6:
                    week = "六";
                    break;
                case 7:
                    week = "日";
                    break;
            }
        } else {
            week = week_object.toString();
        }
        return week;
    }
}
