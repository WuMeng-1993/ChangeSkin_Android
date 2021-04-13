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

    public View view;

    public List<AbstractSkinAttr> attrs;

    public SkinItem() {
        attrs = new ArrayList<>();
    }

}
