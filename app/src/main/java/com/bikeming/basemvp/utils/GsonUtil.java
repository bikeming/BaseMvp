package com.bikeming.basemvp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: com.app.mymvp.utils
 * @Description:
 * @author: 封金明
 * @date: 2018/5/25 11:49
 * @Version:1.0
 */

public class GsonUtil {

    private static volatile Gson mGson;

    public final static Gson getGson() {
        if (mGson == null) {
            synchronized (GsonUtil.class) {
                if (mGson == null)
                    mGson = new GsonBuilder().
                            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                                @Override
                                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                                    if (src == src.longValue())
                                        return new JsonPrimitive(src.longValue());
                                    return new JsonPrimitive(src);
                                }
                            }).create();
            }

        }

        return mGson;
    }

    private GsonUtil() {

    }

    public final static String getJson(Object o) {
        return getGson().toJson(o);
    }

    public final static <T> T getJson(Object o, Class<T> classOfT) {
        if (o == null) return null;
        if (o instanceof String) {
            return getGson().fromJson((String) o, classOfT);
        }
        return getGson().fromJson(getGson().toJson(o), classOfT);
    }

    public final static <T> T fromJson(String json, Class<T> classOfT) {

        return getGson().fromJson(json, classOfT);
    }


    public final static <T> ArrayList<T> getJsonList(Object o, Class<T> classOfT) {
        List list = getGson().fromJson(getGson().toJson(o), List.class);
        ArrayList<T> ts = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ts.add(getJson(list.get(i), classOfT));
        }
        return ts;
    }

    public final static <T> ArrayList<T> getJsonList(ArrayList list, Class<T> classOfT) {
        if (list == null || list.size() == 0) return null;
        ArrayList<T> ts = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ts.add(getJson(list.get(i), classOfT));
        }
        return ts;
    }

}
