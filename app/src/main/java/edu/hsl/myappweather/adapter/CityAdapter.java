package edu.hsl.myappweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hsl.myappweather.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CityAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    List<String> data ;

    public CityAdapter(Context context, List<String> data) {
        this.data=data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHaber haber;
        if (view == null) {
            view = mInflater.inflate(R.layout.layout_city_name, null);
            haber = new ViewHaber();
            haber.name = (TextView) view.findViewById(R.id.tv_city_name);
            view.setTag(haber);
        } else {
            haber = (ViewHaber) view.getTag();
        }
        haber.name.setText(getItem(i));
        return view;
    }

    class ViewHaber {
        TextView name;
    }
}
