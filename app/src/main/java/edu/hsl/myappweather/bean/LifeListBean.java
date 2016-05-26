package edu.hsl.myappweather.bean;

import java.util.ArrayList;
import java.util.List;

import edu.hsl.myappweather.util.WeatherUtil;

/**
 * Created by Administrator on 2016/5/26.
 */
public class LifeListBean {
    String title;
    String level;
    String des;

    public String getTitle() {
        return title;
    }

    public String getLevel() {
        return level;
    }

    public String getDes() {
        return des;
    }

    public LifeListBean(String title, String level, String des) {
        this.title = title;
        this.level = level;
        this.des = des;
    }

    public static List<LifeListBean> getLife() {
        LifeBean           lifeBean = WeatherUtil.getJsonBean().getResult().getData().getLife();
        List<LifeListBean> list     = new ArrayList<>();
        list.add(new LifeListBean("空调指数", lifeBean.getInfo().getKongtiao().get(0), lifeBean.getInfo().getKongtiao().get(1)));
        list.add(new LifeListBean("运动指数", lifeBean.getInfo().getYundong().get(0), lifeBean.getInfo().getYundong().get(1)));
        list.add(new LifeListBean("紫外线", lifeBean.getInfo().getZiwaixian().get(0), lifeBean.getInfo().getZiwaixian().get(1)));
        list.add(new LifeListBean("感冒指数", lifeBean.getInfo().getGanmao().get(0), lifeBean.getInfo().getGanmao().get(1)));
        list.add(new LifeListBean("洗车指数", lifeBean.getInfo().getXiche().get(0), lifeBean.getInfo().getXiche().get(1)));
        list.add(new LifeListBean("污染指数", lifeBean.getInfo().getWuran().get(0), lifeBean.getInfo().getWuran().get(1)));
        list.add(new LifeListBean("穿衣指数", lifeBean.getInfo().getChuanyi().get(0), lifeBean.getInfo().getChuanyi().get(1)));
        return list;
    }
}
