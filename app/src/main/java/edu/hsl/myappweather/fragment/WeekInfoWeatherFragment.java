package edu.hsl.myappweather.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.activity.WeatherRealTimeActivity;
import edu.hsl.myappweather.bean.WeatherBean;
import edu.hsl.myappweather.util.ImageUtil;
import edu.hsl.myappweather.util.WeatherUtil;

/**
 * Created by Administrator on 2016/5/26.
 * 一周详细天气数据
 */
public class WeekInfoWeatherFragment extends Fragment {
    int id = 0;
    TextView  date;//日期
    TextView  weather_day;//天气
    TextView  temperature_day;//温度
    TextView  direct_day;//风向
    TextView  power_day;//风级
    TextView  sun_up;//太阳升起
    TextView  weather_night;//天气
    TextView  temperature_night;//温度
    TextView  direct_night;//风向
    TextView  power_night;//风级
    TextView  sun_down;//降落
    TextView  week;//星期
    TextView  moon;//农历日期
    ImageView id_day;
    ImageView id_night;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_week_info_weather, container, false);
        id = WeatherRealTimeActivity.id;
        date = (TextView) view.findViewById(R.id.tv_date);//日期
        weather_day = (TextView) view.findViewById(R.id.tv_weather_day);//天气
        temperature_day = (TextView) view.findViewById(R.id.tv_temperature_day);
        direct_day = (TextView) view.findViewById(R.id.tv_direct_day);//风向
        power_day = (TextView) view.findViewById(R.id.tv_power_day);//风级
        sun_up = (TextView) view.findViewById(R.id.tv_sun_up);//太阳升起
        weather_night = (TextView) view.findViewById(R.id.tv_weather_night);//
        temperature_night = (TextView) view.findViewById(R.id.tv_temperature_night);
        direct_night = (TextView) view.findViewById(R.id.tv_direct_night);//风
        power_night = (TextView) view.findViewById(R.id.tv_power_night);//风级
        sun_down = (TextView) view.findViewById(R.id.tv_sun_down);//降落
        week = (TextView) view.findViewById(R.id.tv_week);//星期
        moon = (TextView) view.findViewById(R.id.tv_moon);//农历日期
        id_day = (ImageView) view.findViewById(R.id.iv_image_day);
        id_night = (ImageView) view.findViewById(R.id.iv_image_night);
        return view;
    }

    @Override
    public void onResume() {
        WeatherBean data = WeatherUtil.getJsonBean().getResult().getData().getWeather().get(id);
        date.setText(data.getDate());//日期
        weather_day.setText(data.getInfo().getDay().get(1));//天气
        temperature_day.setText(data.getInfo().getDay().get(2) + "℃");//温度
        direct_day.setText(data.getInfo().getDay().get(3));//风向
        power_day.setText(data.getInfo().getDay().get(4));//风级
        sun_up.setText("日出时间:  " + data.getInfo().getDay().get(5));//太阳升起
        weather_night.setText(data.getInfo().getNight().get(1));//天气
        temperature_night.setText(data.getInfo().getNight().get(2) + "℃");//温度
        direct_night.setText(data.getInfo().getNight().get(3));//风向
        power_night.setText(data.getInfo().getNight().get(4));//风级
        sun_down.setText("日落时间:  " + data.getInfo().getNight().get(5));//降落
        week.setText("星期" + data.getWeek());//星期
        moon.setText("农历" + data.getNongli());//农历日期
        id_day.setImageResource(ImageUtil.getImageDay(Integer.parseInt(data.getInfo().getDay().get(0))));
        id_night.setImageResource(ImageUtil.getImageNight(Integer.parseInt(data.getInfo().getNight().get(0))));
        super.onResume();
    }
}
