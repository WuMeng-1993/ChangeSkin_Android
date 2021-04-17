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

    public static Map<View, SkinItem> xmlLayoutParser(View view, int layoutXmlId) {
        Map<View, SkinItem> mSkinItemMap = new HashMap<>(16);

        // 没有布局ID
        if (layoutXmlId == 0) {
            return mSkinItemMap;
        }

        try {
            XmlResourceParser parser = null;
            parser = ContextHolder.getContext().getResources().getLayout(layoutXmlId);
            // 当解析器移动的时候，获取每个标记的属性值
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
                        String attrName = attributeSet.getAttributeName(i);
                        String attrValue = attributeSet.getAttributeValue(i);

                        if ("id".equals(attrName)) {
                            viewId = Integer.parseInt(attrValue.substring(1));
                        }

                        // 如果属性值是引用类型，比如：@color/red
                        if (AttrUtil.isSupportAttr(attrName) && attrValue.startsWith("@")){
                            try {
                                int id = Integer.parseInt(attrValue.substring(1));
                                if (id == 0) {
                                    continue;
                                }

                                String entryName = ContextHolder.getContext().getResources().getResourceEntryName(id);
                                String typeName = ContextHolder.getContext().getResources().getResourceTypeName(id);
                                AbstractSkinAttr mSkinAttr = AttrUtil.get(attrName,id,entryName,typeName);

                                if (mSkinAttr != null) {
                                    viewAttr.add(mSkinAttr);
                                }
                            } catch (NumberFormatException exception) {
                                exception.printStackTrace();
                            }

                        }

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return mSkinItemMap;

    }

}


