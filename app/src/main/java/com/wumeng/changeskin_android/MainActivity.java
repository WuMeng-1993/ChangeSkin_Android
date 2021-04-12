package com.wumeng.changeskin_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wumeng.changeskin_android.skin.ISkinUpdateListener;

/**
 * @author WuMeng
 */
public class MainActivity extends AppCompatActivity implements ISkinUpdateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 换肤
     */
    @Override
    public void onThemeUpdate() {

    }

}