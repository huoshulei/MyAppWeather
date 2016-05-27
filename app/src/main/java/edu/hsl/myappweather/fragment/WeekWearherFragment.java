package edu.hsl.myappweather.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.activity.WeatherRealTimeActivity;
import edu.hsl.myappweather.adapter.WeekAdapter;

/**
 * Created by Administrator on 2016/5/26.
 * 一周天气数据
 */
public class WeekWearherFragment extends Fragment {
    ListView    mListView;
    WeekAdapter mAdapter;
    Context     context;
    public static WeekInfoWeatherFragment week;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_week_weather, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_week_weather);

        return view;
    }

    @Override
    public void onResume() {
        context = getActivity();
        mAdapter = new WeekAdapter(context);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(getListener());
        super.onResume();
    }

    /**
     * 根据选择的日期跳转fragment 显示对应日期的详细天气
     * 通过全局参数进行传递
     */
    @NonNull
    private AdapterView.OnItemClickListener getListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WeatherRealTimeActivity.id = i;
                FragmentManager     fm          = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                week = new WeekInfoWeatherFragment();
                transaction.replace(R.id.fl_week_info_weather, week, "");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        };
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
