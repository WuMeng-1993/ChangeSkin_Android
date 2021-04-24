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

    /**
     * 通过资源ID值来获取Dimen长度
     * @param redId
     * @return
     */
    public static float getDimen(int redId) {
        Context context = SkinManager.getContext();
        if (context == null) {
            return 0F;
        }

        boolean isDefaultSkin = false;
        if (SkinManager.isCurrentDefaultSkin()) {
            isDefaultSkin = true;
        }

        if (!isDefaultSkin) {
            String skinName = getResourceEntryNameById(redId);
            int trueResId = context.getResources().getIdentifier(skinName,"dimen",context.getPackageName());
            // 0: 代表找不到该资源
            if (trueResId > 0) {
                return context.getResources().getDimensionPixelSize(trueResId);
            }
        }


        return context.getResources().getDimensionPixelSize(redId);
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
