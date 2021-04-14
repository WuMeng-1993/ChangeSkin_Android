package com.wumeng.changeskin_android.util;

import android.content.Context;

/**
 * @author WuMeng
 * @date 2021/4/13
 * desc:
 */
public class ContextHolder {

    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        if (mContext == null) {
            throw  new RuntimeException("ContextHolder Not Init Yet!");
        } else {
            return mContext;
        }
    }

}
