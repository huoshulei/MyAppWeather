package edu.hsl.myappweather.util;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.hsl.myappweather.bean.JsonBean;

/**
 * Created by Administrator on 2016/5/26.
 * 获取网络数据并解析数据
 * //聚合0fdb111d480794e6a0c6f1bdbfba2188/key
 */
public class WeatherUtil {
    public final static String APPKEY    = "0fdb111d480794e6a0c6f1bdbfba2188";
    public final static String URL       = "http://op.juhe.cn/onebox/weather/query?";
    public final static String CITY_NAME = "cityname";
    public final static String DTYPE     = "dtype";
    public final static String KEY       = "key";

    public WeatherUtil(String city_name) {
        getJson(city_name);
    }

    private static String json;

    private void getJson(String city_name) {
        StringBuffer      sb            = null;
        HttpURLConnection urlConnection = null;
        try {
            sb = new StringBuffer();
            String uri = Uri.parse(URL).buildUpon()
                    .appendQueryParameter(CITY_NAME, city_name)
                    .appendQueryParameter(DTYPE, "json")
                    .appendQueryParameter(KEY, APPKEY)
                    .build().toString();
            java.net.URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();
            InputStream    inputStream = urlConnection.getInputStream();
            BufferedReader reader      = new BufferedReader(new InputStreamReader(inputStream));
            String         strData;
            while ((strData = reader.readLine()) != null) {
                sb.append(strData).append("\n");
            }
            inputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        json = sb.toString();
    }

    public static JsonBean getJsonBean() {
        Gson     gson     = new Gson();
        JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
        return jsonBean;
    }
}
