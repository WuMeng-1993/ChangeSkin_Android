package com.wumeng.changeskin_android.skin;

import android.view.View;
import android.widget.ImageView;

/**
 * @author WuMeng
 * @date 2021/4/20
 * desc:
 */
public class ImageViewSrcAttr extends AbstractSkinAttr {

    @Override
    protected void applySkin(View view) {
        if (view == null) {
            return;
        }

        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (isDrawable()) {
                imageView.setImageDrawable(SkinResourcesUtil.getDrawable(attrValueRefId));
            }
        }
    }

}
