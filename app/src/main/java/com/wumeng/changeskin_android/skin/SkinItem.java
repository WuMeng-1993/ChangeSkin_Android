package com.wumeng.changeskin_android.skin;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuMeng
 * @date 2021/4/13
 * desc:
 */
public class SkinItem {

    /**
     * 需要换肤的控件View
     */
    public View view;

    /**
     * 换肤控件View对应的属性
     */
    public List<AbstractSkinAttr> attrs;

    public SkinItem() {
        attrs = new ArrayList<>();
    }

    /**
     * 执行换肤操作
     */
    public void apply() {
        if (SkinListUtil.isEmpty(attrs)) {
            return;
        }

        for (AbstractSkinAttr attr : attrs) {
            attr.apply(view);
        }
    }

}
