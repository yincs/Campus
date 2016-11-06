package org.changs.campus.mobile.app;

import android.content.Context;
import android.content.SharedPreferences;

import org.changs.campus.mobile.utils.JsonUtils;

/**
 * Created by yincs on 2016/11/6.
 */

public class AppPreferencesUtils {
    private static SharedPreferences app;


    public static SharedPreferences getAppPreference() {
        if (app == null) {
            app = MyApplication.getContext()
                    .getSharedPreferences("app", Context.MODE_PRIVATE);
        }
        return app;
    }


    public static <T> T readObject(String key, Class<T> tClass) {
        String json = getAppPreference().getString(key, null);
        return JsonUtils.parseObject(json, tClass);
    }

    public static boolean wirteObject(String key, Object object) {
        String json = JsonUtils.getJsonStr(object);
        return getAppPreference().edit().putString(key, json)
                .commit();
    }
}
