package com.wumeng.changeskin_android;

import android.app.Application;

import com.wumeng.changeskin_android.skin.SkinManager;
import com.wumeng.changeskin_android.util.ContextHolder;

/**
 * @author WuMeng
 * @date 2021/4/11
 * desc:
 */
public class ChangeSkinApplication extends Application {

    /**
     * Application对象
     */
    private static ChangeSkinApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ContextHolder.setContext(this);
        SkinManager.init(this);
    }
    
}
