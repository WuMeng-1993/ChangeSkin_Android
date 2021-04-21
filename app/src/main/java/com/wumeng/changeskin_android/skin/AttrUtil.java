package com.wumeng.changeskin_android.skin;

import java.util.HashMap;

/**
 * @author WuMeng
 * @date 2021/4/15
 * desc:
 */
public class AttrUtil {

    private static HashMap<String,AbstractSkinAttr> mSupportAttr = new HashMap<>();

    static {

        mSupportAttr.put("layout_width",new ViewAttr());
        mSupportAttr.put("layout_height",new ViewAttr());
        mSupportAttr.put("src",new ImageViewSrcAttr());

    }

    /**
     * 判断是否支持此属性
     * @param attrName
     * @return
     */
    public static boolean isSupportAttr(String attrName) {
        return mSupportAttr.containsKey(attrName);
    }

    public static AbstractSkinAttr get(String attrName, int id, String entryName, String typeName) {
        AbstractSkinAttr mSkinAttr = mSupportAttr.get(attrName).clone();
        mSkinAttr.attrName = attrName;
        mSkinAttr.attrValueRefId = id;
        mSkinAttr.attrValueRefName = entryName;
        mSkinAttr.attrValueTypeName = typeName;
        return mSkinAttr;
    }

}
