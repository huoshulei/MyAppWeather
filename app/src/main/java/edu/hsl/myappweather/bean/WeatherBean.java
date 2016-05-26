package edu.hsl.myappweather.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class WeatherBean {
    private String   date;
    private String   week;
    private String   nongli;
    private InfoBean info;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNongli() {
        return nongli;
    }

    public void setNongli(String nongli) {
        this.nongli = nongli;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public class InfoBean {
        private List<String> night;
        private List<String> day;

        public List<String> getNight() {
            return night;
        }

        public void setNight(List<String> night) {
            this.night = night;
        }

        public List<String> getDay() {
            return day;
        }

        public void setDay(List<String> day) {
            this.day = day;
        }
    }
}
