package edu.hsl.myappweather.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.adapter.LifeAdapter;
import edu.hsl.myappweather.bean.PM25Bean;
import edu.hsl.myappweather.util.WeatherUtil;

/**
 * Created by Administrator on 2016/5/26.
 * pm2.5以及生活指数数据
 */
public class PM25LifeFragment extends Fragment {
    TextView    tv_data_time;
    TextView    tv_curpm;
    TextView    tv_pm25;
    TextView    tv_pm10;
    TextView    tv_des;
    TextView    tv_quality;
    ListView    mListView;
    LifeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_pm25_life, container, false);
        tv_data_time = (TextView) view.findViewById(R.id.tv_data_time);
        tv_curpm = (TextView) view.findViewById(R.id.tv_cur_pm);
        tv_pm25 = (TextView) view.findViewById(R.id.tv_pm25);
        tv_pm10 = (TextView) view.findViewById(R.id.tv_pm10);
        tv_des = (TextView) view.findViewById(R.id.tv_des);
        tv_quality = (TextView) view.findViewById(R.id.tv_quality);
        mListView = (ListView) view.findViewById(R.id.lv_life);
        return view;
    }

    @Override
    public void onResume() {
        PM25Bean bean = WeatherUtil.getJsonBean().getResult().getData().getPm25();
        tv_data_time.setText("更新时间:" + bean.getDateTime());
        tv_curpm.setText("污染指数:" + bean.getPm25().getCurPm());
        tv_pm25.setText("PM2.5: " + bean.getPm25().getPm25());
        tv_pm10.setText("PM10:  " + bean.getPm25().getPm10());
        tv_des.setText(bean.getPm25().getDes());
        tv_quality.setText("污染等级:" + bean.getPm25().getQuality());
        adapter = new LifeAdapter(getActivity());
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        super.onResume();
    }
}
