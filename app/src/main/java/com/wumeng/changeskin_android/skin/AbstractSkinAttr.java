package com.wumeng.changeskin_android.skin;

import android.view.View;

/**
 * @author WuMeng
 * @date 2021/4/13
 * desc:
 */
public abstract class AbstractSkinAttr implements Cloneable {

    public static final String RES_TYPE_NAME_LAYOUT_WIDTH = "layout_width";
    public static final String RES_TYPE_NAME_LAYOUT_HEIGHT = "layout_height";
    private static final String RES_TYPE_NAME_DRAWABLE = "drawable";
    private static final String RES_TYPE_NAME_MIPMAP = "mipmap";

    /**
     * 属性的名字
     * eg: layout_width
     */
    public String attrName;

    /**
     * 上面属性的id
     * eg:482048
     */
    public int attrValueRefId;

    /**
     * 当前属性值的引用名称
     * eg: common_100dp
     */
    public String attrValueRefName;

    /**
     * 当前属性值所属的类型
     * eg: dimen
     */
    public String attrValueTypeName;

    public void apply(View view) {
        applySkin(view);
    }

    /**
     * 执行换肤
     * @param view
     */
    protected abstract void applySkin(View view);

    /**
     * 判断是否是drawable或者mipmap
     * @return
     */
    protected boolean isDrawable() {
        return attrValueTypeName.equals(RES_TYPE_NAME_DRAWABLE) || attrValueTypeName.equals(RES_TYPE_NAME_MIPMAP);
    }

    @Override
    public AbstractSkinAttr clone() {
        AbstractSkinAttr o = null;
        try {
            o = (AbstractSkinAttr) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
