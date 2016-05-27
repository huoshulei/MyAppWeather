package edu.hsl.myappweather.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.activity.WeatherRealTimeActivity;
import edu.hsl.myappweather.adapter.CityAdapter;
import edu.hsl.myappweather.util.CityUtil;

/**
 * Created by Administrator on 2016/5/26.
 * 标题栏
 */
public class TitleFragment extends Fragment {
    ImageView   mImageView;
    PopupWindow window;
    PopupWindow window1;
    private static final String TAG = "TitleFragment";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_title, container, false);
        mImageView = (ImageView) view.findViewById(R.id.im_city);
        mImageView.setOnClickListener(getL());
        return view;
    }

    /**
     * 点击打开省名单弹窗
     */
    @NonNull
    private View.OnClickListener getL() {
        return new View.OnClickListener() {
            CityAdapter adapter;

            @Override
            public void onClick(View view) {
                ListView listView = null;
                final WindowManager manager = (WindowManager) getActivity()
                        .getSystemService(Context.WINDOW_SERVICE);
                final int xPos   = (int) (manager.getDefaultDisplay().getWidth() / 1.35);
                final int height = (int) (manager.getDefaultDisplay().getHeight() / 1.15);
//                if (window == null) {
                View inflater = View.inflate(getActivity(), R.layout.layout_city_name_list, null);
                listView = (ListView) inflater.findViewById(R.id.lv_city_name);
                adapter = new CityAdapter(getActivity(), CityUtil.getData());
                listView.setAdapter(adapter);
                window = new PopupWindow(inflater, 280, height);
//                }
                window.setFocusable(true);
                window.setOutsideTouchable(true);
                window.showAsDropDown(getView(), xPos, 0);
                assert listView != null;
                listView.setOnItemClickListener(getListener(manager, height));
            }
        };
    }

    /**
     * 根据各省打开对应的城市名单
     * 参数为弹窗显示位置和大小布局参数
     */
    @NonNull
    private AdapterView.OnItemClickListener getListener(final WindowManager manager, final int height) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CityAdapter adapter = new CityAdapter(getActivity(), CityUtil.CityName.getData(i));
//                if (window1 == null) {
                View     inflater     = View.inflate(getActivity(), R.layout.layout_city_name_list, null);
                ListView listViewCity = (ListView) inflater.findViewById(R.id.lv_city_name);
                listViewCity.setAdapter(adapter);
                window1 = new PopupWindow(inflater, 300, height);
//                }
                int xPos = (int) (manager.getDefaultDisplay().getWidth() / 1.9);
                window1.setFocusable(true);
                window1.setOutsideTouchable(true);
                window1.showAsDropDown(getView(), xPos, 0);
                assert listViewCity != null;
                listViewCity.setOnItemClickListener(getListenercity(adapter));

            }
        };
    }

    /**
     * 读取选择的城市 并关闭弹窗
     * adapter是城市名称数据
     */
    @NonNull
    private AdapterView.OnItemClickListener getListenercity(final CityAdapter adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WeatherRealTimeActivity activity = (WeatherRealTimeActivity) getActivity();
                activity.asyncTask(adapter.getItem(i));
                Log.d(TAG, "onItemClick: " + adapter.getItem(i));
                window1.dismiss();
                window.dismiss();
            }
        };
    }
}
