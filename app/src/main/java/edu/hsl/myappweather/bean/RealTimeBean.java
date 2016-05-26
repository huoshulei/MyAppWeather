package edu.hsl.myappweather.bean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class RealTimeBean {
    private String      date;
    private String      time;
    private String      city_name;
    private Object      week;
    private String      moon;
    private WindBean    wind;
    private WeatherBean weather;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Object getWeek() {
        return week;
    }

    public void setWeek(Object week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }

    public WeatherBean getWeather() {
        return weather;
    }

    public void setWeather(WeatherBean weather) {
        this.weather = weather;
    }

    public class WindBean {
        private String direct;
        private String power;

        public String getDirect() {
            return direct;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }
    }

    public class WeatherBean {
        private String humidity;
        private int    img;
        private String info;
        private String temperature;

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }
}
