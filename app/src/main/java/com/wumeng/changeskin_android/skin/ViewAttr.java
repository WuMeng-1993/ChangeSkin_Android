package com.wumeng.changeskin_android.skin;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author WuMeng
 * @date 2021/4/18
 * desc:
 */
public class ViewAttr extends AbstractSkinAttr {

    @Override
    protected void applySkin(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();

        if (params == null) {
            return;
        }

        switch (attrName) {
            // layout_width
            case RES_TYPE_NAME_LAYOUT_WIDTH:
                params.width = (int) SkinResourcesUtil.getDimen(attrValueRefId);
                break;
            // layout_height
            case RES_TYPE_NAME_LAYOUT_HEIGHT:
                params.height = (int) SkinResourcesUtil.getDimen(attrValueRefId);
                break;
            default:
                break;
        }

    }

}
