package edu.hsl.myappweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.bean.WeatherBean;
import edu.hsl.myappweather.util.WeatherUtil;

/**
 * Created by Administrator on 2016/5/26.
 * 一周天气
 */
public class WeekAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<WeatherBean> data = WeatherUtil.getJsonBean().getResult().getData().getWeather();

    public WeekAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public WeatherBean getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewGroup parent = (ViewGroup) view.getParent();
//        if (parent != null) {
//            viewGroup.removeAllViewsInLayout();
//            parent.removeAllViewsInLayout();
//        }
        ViewHaber haber;
        if (view == null) {
            haber = new ViewHaber();
            view = inflater.inflate(R.layout.layout_list_item_week, null);
            haber.date = (TextView) view.findViewById(R.id.tv_date);
            haber.weather = (TextView) view.findViewById(R.id.tv_weather);
            haber.temperature = (TextView) view.findViewById(R.id.tv_temperature);
            haber.direct = (TextView) view.findViewById(R.id.tv_direct);
            haber.power = (TextView) view.findViewById(R.id.tv_power);
            haber.week = (TextView) view.findViewById(R.id.tv_week);
            view.setTag(haber);
        } else {
            haber = (ViewHaber) view.getTag();
        }
        haber.date.setText(getItem(i).getDate());
        haber.weather.setText(getItem(i).getInfo().getDay().get(1));
        haber.temperature.setText("温度" + getItem(i)
                .getInfo().getNight().get(2) + "~" + getItem(i).getInfo().getDay().get(2) + "℃");
        haber.direct.setText(getItem(i).getInfo().getDay().get(3));
        haber.power.setText(getItem(i).getInfo().getDay().get(4));
        haber.week.setText("星期" + getItem(i).getWeek());
        return view;
    }

    class ViewHaber {
        TextView date;//日期
        TextView weather;//天气
        TextView temperature;//温度
        TextView direct;//风向
        TextView power;//风级
        TextView week;//星期
    }
}
