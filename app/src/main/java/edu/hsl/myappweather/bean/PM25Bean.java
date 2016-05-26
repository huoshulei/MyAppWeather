package edu.hsl.myappweather.bean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class PM25Bean {
    private String    dateTime;
    private CurPmbean pm25;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public CurPmbean getPm25() {
        return pm25;
    }

    public void setPm25(CurPmbean pm25) {
        this.pm25 = pm25;
    }

    public class CurPmbean {
        private String curPm;
        private String pm25;
        private String pm10;
        private String quality;
        private String des;

        public String getCurPm() {
            return curPm;
        }

        public void setCurPm(String curPm) {
            this.curPm = curPm;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }
}
