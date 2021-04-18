package com.wumeng.changeskin_android.skin;

/**
 * @author WuMeng
 * @date 2021/4/13
 * desc:
 */
public abstract class AbstractSkinAttr implements Cloneable {

    public String attrName;

    public int attrValueRefId;

    public String attrValueRefName;

    public String attrValueTypeName;

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
