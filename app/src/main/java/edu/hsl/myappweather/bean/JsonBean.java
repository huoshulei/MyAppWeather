package edu.hsl.myappweather.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class JsonBean {
    private String     reason;
    private int        error_code;
    private ResultBean result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public class ResultBean {
        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public class DataBean {
            private RealTimeBean      realtime;
            private LifeBean          life;
            private List<WeatherBean> weather;
            private PM25Bean          pm25;

            public RealTimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealTimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public PM25Bean getPm25() {
                return pm25;
            }

            public void setPm25(PM25Bean pm25) {
                this.pm25 = pm25;
            }
        }
    }

}
