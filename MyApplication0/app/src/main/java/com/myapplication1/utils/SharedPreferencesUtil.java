package com.myapplication1.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/10 22:12
 */
public class SharedPreferencesUtil {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesUtil(Context context, String name) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public <T> void setDataList(String key, List<T> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;

        //转换成json数据，再保存
        Gson gson = new Gson();
        String strJson = gson.toJson(datalist);
        editor.clear();
        editor.putString(key, strJson);
        editor.commit();
    }

    public <T> List<T> getDataList(String key, Class<T> cls) {
        List<T> datalist = new ArrayList<T>();
        String strJson = preferences.getString(key, null);
        if (null == strJson) {
            return datalist;
        }
        Gson gson = new Gson();
        JsonArray array = new JsonParser().parse(strJson).getAsJsonArray();
        for (JsonElement element : array) {
            datalist.add(gson.fromJson(element, cls));
        }
        return datalist;
    }
}
