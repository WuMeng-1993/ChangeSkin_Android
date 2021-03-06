package com.wumeng.changeskin_android.skin;

import android.content.Context;

import com.wumeng.changeskin_android.util.ContextHolder;
import com.wumeng.changeskin_android.util.SkinPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

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
     * 保存实现ISkinUpdateListener的列表类
     */
    private static List<ISkinUpdateListener> mSkinObservers;

    /**
     * 初始化，在Application初始化
     *
     * @param context
     */
    public static void init(Context context) {
        mContext = context;
        String savedSkinName = getSavedSkinName();
        if ("".equals(savedSkinName)) {
            savedSkinName = SkinConfig.SKIN_NAME_DEFAULT;
        }
        CURRENT_SKIN = SkinConfig.SKIN_NAME_NIGHT;
    }

    /**
     * 获取保存的皮肤名字
     *
     * @return
     */
    private static String getSavedSkinName() {
        return SkinPreferencesUtil.getString(mContext, SkinConfig.PREF_SKIN_NAME, SkinConfig.SKIN_NAME_DEFAULT);
    }

    /**
     * 获取Context实例
     *
     * @return
     */
    public static Context getContext() {
        if (mContext == null) {
            mContext = ContextHolder.getContext();
        }
        return mContext;
    }

    /**
     * 将ISkinUpdateListener实现类加入列表
     *
     * @param observer
     */
    public static void attach(ISkinUpdateListener observer) {
        if (mSkinObservers == null) {
            mSkinObservers = new ArrayList<>();
        }

        if (!mSkinObservers.contains(observer)) {
            mSkinObservers.add(observer);
        }
    }

    /**
     * 判断是否是默认皮肤
     *
     * @return
     */
    public static boolean isExternalSkin() {
        return isCurrentDefaultSkin();
    }

    /**
     * 当前皮肤是否是默认皮肤
     *
     * @return
     */
    public static boolean isCurrentDefaultSkin() {
        return CURRENT_SKIN.equals(SkinConfig.SKIN_NAME_DEFAULT);
    }

    /**
     * 凭借资源的名字
     * @param value
     * @return
     */
    public static String wrapper(String value) {
        return isCurrentDefaultSkin() ? value : value + SkinConfig.SKIN_SEPARATOR + CURRENT_SKIN;
    }

    /**
     * 将ISkinUpdateListener实现类移除列表
     *
     * @param observer
     */
    public static void detach(ISkinUpdateListener observer) {
        if (mSkinObservers != null) {
            mSkinObservers.remove(observer);
        }
    }

}
