package com.wumeng.changeskin_android.skin;

import java.util.HashMap;

/**
 * @author WuMeng
 * @date 2021/4/15
 * desc:
 */
public class AttrUtil {

    private static HashMap<String,AbstractSkinAttr> mSupportAttr = new HashMap<>();

    public static boolean isSupportAttr(String attrName) {
        return mSupportAttr.containsKey(attrName);
    }

    public static AbstractSkinAttr get(String attrName, int id, String entryName, String typeName) {
        return null;
    }

}
