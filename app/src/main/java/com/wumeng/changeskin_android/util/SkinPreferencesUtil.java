package com.wumeng.changeskin_android.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.wumeng.changeskin_android.skin.SkinConfig;

/**
 * @author WuMeng
 * @date 2021/4/12
 * desc:
 */
public class SkinPreferencesUtil {

    /**
     * 存储字符串
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putString(Context context,String key,String value) {
        SharedPreferences preferences = context.getSharedPreferences(SkinConfig.PREF_SKIN_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 获取存储的字符串值
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Context context,String key,String defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(SkinConfig.PREF_SKIN_NAME,Context.MODE_PRIVATE);
        return preferences.getString(key,defaultValue);
    }

}
