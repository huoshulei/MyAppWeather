package edu.hsl.myappweather.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.hsl.myappweather.R;
import edu.hsl.myappweather.fragment.PM25LifeFragment;
import edu.hsl.myappweather.fragment.RealTimeWeatherFragment;
import edu.hsl.myappweather.fragment.WeekInfoWeatherFragment;
import edu.hsl.myappweather.fragment.WeekWearherFragment;
import edu.hsl.myappweather.util.WeatherUtil;

public class WeatherRealTimeActivity extends AppCompatActivity {
    WeatherUtil             util;
    PM25LifeFragment        pm25;
    RealTimeWeatherFragment realTime;
    WeekInfoWeatherFragment weekInfo;
    WeekWearherFragment     week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                WeatherUtil util = new WeatherUtil(strings[0]);

                return "";
            }

            @Override
            protected void onPostExecute(String s) {
                setContentView(R.layout.activity_weather_real_time);
                setDefaultFragment();

//                WeekAdapter adapter =new WeekAdapter(getApplicationContext());
                super.onPostExecute(s);
            }
        }.execute("济南");

    }

    private void setDefaultFragment() {
        FragmentManager     fm          = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        week = new WeekWearherFragment();
        transaction.replace(R.id.fl_week_weather, week);
        transaction.commit();

    }
}
