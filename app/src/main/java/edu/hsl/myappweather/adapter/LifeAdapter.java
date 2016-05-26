package edu.hsl.myappweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.bean.LifeListBean;

/**
 * Created by Administrator on 2016/5/26.
 */
public class LifeAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<LifeListBean> data = LifeListBean.getLife();

    public LifeAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public LifeListBean getItem(int i) {
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
            haber = new ViewHaber();
            view = inflater.inflate(R.layout.layout_list_item_life, null);
            haber.title = (TextView) view.findViewById(R.id.tv_title);
            haber.exp = (TextView) view.findViewById(R.id.tv_exp);
            haber.miute = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(haber);
        } else {
            haber = (ViewHaber) view.getTag();
        }
        haber.title.setText(getItem(i).getTitle());
        haber.exp.setText(getItem(i).getLevel());
        haber.miute.setText(getItem(i).getDes());
        return view;
    }

    class ViewHaber {
        TextView title;
        TextView exp;
        TextView miute;
    }
}
