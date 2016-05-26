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
import edu.hsl.myappweather.bean.RealTimeBean;
import edu.hsl.myappweather.util.ImageUtil;
import edu.hsl.myappweather.util.WeatherUtil;
import edu.hsl.myappweather.util.WeekUtil;

/**
 * Created by Administrator on 2016/5/26.
 * 实时天气数据
 */
public class RealTimeWeatherFragment extends Fragment {
    //    ListView       lv_weather;
//    RelativeLayout rl_real;
    TextView  tv_direct;//风向
    TextView  tv_power;//风级
    TextView  tv_time;//更新时间
    TextView  tv_humidity;//湿度
    TextView  tv_weather;//天气
    TextView  tv_temperature;//温度
    TextView  tv_date;//日期
    TextView  tv_city_name;//地区
    TextView  tv_week;//星期
    TextView  tv_moon;//农历日期
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_real_time_weather, container);
        tv_direct = (TextView) view.findViewById(R.id.tv_direct);//风向
        tv_power = (TextView) view.findViewById(R.id.tv_power);//风级
        tv_time = (TextView) view.findViewById(R.id.tv_time);//更新时间
        tv_humidity = (TextView) view.findViewById(R.id.tv_humidity);//湿度
        tv_weather = (TextView) view.findViewById(R.id.tv_weather);//天气
        tv_temperature = (TextView) view.findViewById(R.id.tv_temperature);//温度
        tv_date = (TextView) view.findViewById(R.id.tv_date);//日期
        tv_city_name = (TextView) view.findViewById(R.id.tv_city_name);//地区
        tv_week = (TextView) view.findViewById(R.id.tv_week);//星期
        tv_moon = (TextView) view.findViewById(R.id.tv_moon);//农历日期
        imageView = (ImageView) view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onResume() {
        RealTimeBean realTime = WeatherUtil.getJsonBean().getResult().getData().getRealtime();

        tv_direct.setText(realTime.getWind().getDirect());//风向
        tv_power.setText(realTime.getWind().getPower());//风级
        tv_time.setText("更新时间" + realTime.getTime());//更新时间
        tv_humidity.setText("相对湿度" + realTime.getWeather().getHumidity() + "%");//湿度
        tv_weather.setText(realTime.getWeather().getInfo());//天气
        tv_temperature.setText("温度" + realTime.getWeather().getTemperature() + "℃");//温度
        tv_date.setText(realTime.getDate());//日期
        tv_city_name.setText(realTime.getCity_name());//地区
        tv_week.setText("星期" + WeekUtil.getWeek(realTime.getWeek()));//星期
        tv_moon.setText("农历" + realTime.getMoon());//农历日期
        imageView.setImageResource(ImageUtil.getImageDay(realTime.getWeather().getImg()));
//        PM25Bean bean = mWeatherUtil.getJsonPM25();
//        tv_data_time.setText("更新时间:" + bean.dateTime);
//        tv_curpm.setText("污染指数:" + bean.curPm);
//        tv_pm25.setText("PM2.5: " + bean.pm25);
//        tv_pm10.setText("PM10:  " + bean.pm10);
//        tv_des.setText(bean.des);
//        tv_quality.setText("污染等级:" + bean.quality);
//        data = mWeatherUtil.getJsonLife();
//        adapter = new LifeAdapter(getApplicationContext(), data);
//        lv_life.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        super.onResume();
    }
}
