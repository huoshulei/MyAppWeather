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
    PM25LifeFragment        pm25;
    RealTimeWeatherFragment realTime;
    WeekInfoWeatherFragment weekInfo;
    WeekWearherFragment     week;
    public static int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_real_time);
        asyncTask("济南");
    }


    public void asyncTask(String cityname) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                new WeatherUtil(strings[0]);

                return "";
            }

            @Override
            protected void onPostExecute(String s) {
                setDefaultFragment();
                super.onPostExecute(s);
            }
        }.execute(cityname);
    }

    private void setDefaultFragment() {
        FragmentManager     fm          = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        week = new WeekWearherFragment();
        realTime = new RealTimeWeatherFragment();
        transaction.replace(R.id.fl_real_time_weather, realTime);
        transaction.replace(R.id.fl_week_weather, week);
        transaction.commit();
    }
}
