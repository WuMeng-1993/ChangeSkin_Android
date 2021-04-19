package com.wumeng.changeskin_android.skin;

import java.util.List;

/**
 * @author WuMeng
 * @date 2021/4/19
 * desc:
 */
public class SkinListUtil {

    public static <V> boolean isEmpty(List<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }

}
