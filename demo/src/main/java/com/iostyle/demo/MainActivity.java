package com.iostyle.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import iostyle.com.demo.R;
import iostyle.com.skytabview.SkyTabView;


/**
 * Created by Administrator on 2017/6/29 0029.
 */

public class MainActivity extends AppCompatActivity {

    private SkyTabView mSkyTabView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSkyTabView = findViewById(R.id.skyTabView);
        mSkyTabView.setText("Tab1", "Tab2");
        mSkyTabView.setListener(new SkyTabView.OnClickListener() {
            @Override
            public void onLeftClick() {
                Log.d("SKY", "leftBtn is click!");
            }

            @Override
            public void onRightClick() {
                Log.d("SKY", "rightBtn is click!");
            }
        });
    }
}
