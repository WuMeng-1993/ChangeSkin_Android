package com.wumeng.changeskin_android.skin;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

/**
 * @author WuMeng
 * @date 2021/4/19
 * desc:
 */
public class SkinResourcesUtil {

    public static float getDimen(int redId) {
        return 100.0f;
    }

    /**
     * 通过资源的ID获取图片资源
     * @param attrValueRefId
     * @return
     */
    public static Drawable getDrawable(int attrValueRefId) {
        Context context = SkinManager.getContext();

        // 获取默认的Drawable
        Drawable originDrawable = ContextCompat.getDrawable(context,attrValueRefId);

        if (SkinManager.isCurrentDefaultSkin()) {
            return originDrawable;
        }

        String resName = getResourceEntryNameById(attrValueRefId);
        int trueResId = context.getResources().getIdentifier(resName,"drawable",context.getPackageName());
        Drawable trueDrawable;
        if (trueResId == 0) {
            trueResId = context.getResources().getIdentifier(resName,"mipmap",context.getPackageName());
        }

        trueDrawable = ContextCompat.getDrawable(context,trueResId);

        return trueDrawable;

    }

    /**
     * 获取拼接后的资源名
     * @param attrValueRefId
     * @return
     */
    public static String getResourceEntryNameById(int attrValueRefId) {
        String resourceEntryName = SkinManager.getContext().getResources().getResourceEntryName(attrValueRefId);
        return SkinManager.wrapper(resourceEntryName);
    }

}
