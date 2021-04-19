package com.wumeng.changeskin_android.skin;

import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;

import com.wumeng.changeskin_android.util.ContextHolder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WuMeng
 * @date 2021/4/13
 * desc:
 */
public class ParseAttrUtil {

    /**
     * 解析XML布局
     *
     * @param rootView
     * @param layoutXmlId
     * @return
     */
    public static Map<View, SkinItem> xmlLayoutParser(View rootView, int layoutXmlId) {
        Map<View, SkinItem> mSkinItemMap = new HashMap<>(16);

        // 没有布局ID
        if (layoutXmlId == 0) {
            return mSkinItemMap;
        }

        // 布局解析器
        XmlResourceParser parser = null;

        try {
            parser = ContextHolder.getContext().getResources().getLayout(layoutXmlId);
            // 当解析器移动的时候，会自动获取每个控件的属性值
            AttributeSet attributeSet = Xml.asAttributeSet(parser);

            int type;
            while ((((type = parser.next()) != XmlResourceParser.END_DOCUMENT))) {
                if (type != XmlPullParser.START_TAG) {
                    continue;
                }

                List<AbstractSkinAttr> viewAttr = new ArrayList<>();
                // 检索命名空间下的属性的值
                boolean isEnable = attributeSet.getAttributeBooleanValue(SkinConfig.NAME_SPACE, SkinConfig.ATTR_SKIN_ENABLE, false);
                if (isEnable) {
                    int viewId = 0;

                    for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
                        // eg: Layout_Width
                        String attrName = attributeSet.getAttributeName(i);
                        String attrValue = attributeSet.getAttributeValue(i);

                        if ("id".equals(attrName)) {
                            viewId = Integer.parseInt(attrValue.substring(1));
                        }

                        // 如果属性值是引用类型，比如：@color/red
                        if (AttrUtil.isSupportAttr(attrName) && attrValue.startsWith("@")) {
                            try {
                                int id = Integer.parseInt(attrValue.substring(1));
                                if (id == 0) {
                                    continue;
                                }

                                // common_100dp
                                String entryName = ContextHolder.getContext().getResources().getResourceEntryName(id);
                                // dimen
                                String typeName = ContextHolder.getContext().getResources().getResourceTypeName(id);
                                AbstractSkinAttr mSkinAttr = AttrUtil.get(attrName, id, entryName, typeName);

                                if (mSkinAttr != null) {
                                    viewAttr.add(mSkinAttr);
                                }
                            } catch (NumberFormatException exception) {
                                exception.printStackTrace();
                            }

                        }

                    }

                    if (!SkinListUtil.isEmpty(viewAttr)) {
                        if (viewId != 0) {
                            SkinItem skinItem = new SkinItem();
                            skinItem.view = rootView.findViewById(viewId);
                            skinItem.attrs = viewAttr;
                            mSkinItemMap.put(skinItem.view,skinItem);
                            // 如果不是默认的皮肤，则执行换肤
                            if (!SkinManager.isExternalSkin()) {
                                skinItem.apply();
                            }
                        }
                    }
                }

            }
            return mSkinItemMap;
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
            return mSkinItemMap;
        } finally {
            if (parser != null) {
                parser.close();
            }
        }

    }

}


