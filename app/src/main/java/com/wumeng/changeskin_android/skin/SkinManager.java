package com.wumeng.changeskin_android.skin;

import android.content.Context;

import com.wumeng.changeskin_android.util.SkinPreferencesUtil;

/**
 * @author WuMeng
 * @date 2021/4/12
 * desc:
 */
public class SkinManager {

    private static Context mContext;

    /**
     * 当前皮肤的名字
     */
    private static String CURRENT_SKIN = SkinConfig.SKIN_NAME_DEFAULT;

    /**
     * 初始化，在Application初始化
     * @param context
     */
    public static void init(Context context) {
        mContext = context;
        String savedSkinName = getSavedSkinName();
        if ("".equals(savedSkinName)) {
            savedSkinName = SkinConfig.SKIN_NAME_DEFAULT;
        }
        CURRENT_SKIN = savedSkinName;
    }

    /**
     * 获取保存的皮肤名字
     * @return
     */
    private static String getSavedSkinName() {
        return SkinPreferencesUtil.getString(mContext,SkinConfig.PREF_SKIN_NAME,SkinConfig.SKIN_NAME_DEFAULT);
    }

}
