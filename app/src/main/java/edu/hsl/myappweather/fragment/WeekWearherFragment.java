package edu.hsl.myappweather.fragment;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.adapter.WeekAdapter;

/**
 * Created by Administrator on 2016/5/26.
 * 一周天气数据
 */
public class WeekWearherFragment extends ListFragment {
    ListView    mListView;
    WeekAdapter mAdapter;
    Context     context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_week_weather, container);
//        ViewGroup parent = (ViewGroup) getView().getParent();
//        mListView = (ListView) view.findViewById(R.id.lv_week_weather);
//        mListView.removeView(view);
//        context = getActivity();
//        mAdapter = new WeekAdapter(context);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
