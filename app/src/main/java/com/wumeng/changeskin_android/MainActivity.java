package com.wumeng.changeskin_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.wumeng.changeskin_android.skin.ISkinUpdateListener;
import com.wumeng.changeskin_android.skin.ParseAttrUtil;
import com.wumeng.changeskin_android.skin.SkinItem;
import com.wumeng.changeskin_android.skin.SkinManager;
import com.wumeng.changeskin_android.util.ContextHolder;

import java.util.Map;

/**
 * @author WuMeng
 */
public class MainActivity extends AppCompatActivity implements ISkinUpdateListener {

    /**
     * 保存
     */
    protected Map<View, SkinItem> mSkinItemMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 绑定换肤接口
        SkinManager.attach(this);

        //
        View view = LayoutInflater.from(ContextHolder.getContext()).inflate(R.layout.activity_main,null);
        mSkinItemMap = ParseAttrUtil.xmlLayoutParser(view,R.layout.activity_main);
    }

    /**
     * 换肤的通知
     */
    @Override
    public void onThemeUpdate() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.detach(this);
    }

}