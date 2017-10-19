package com.le.www.makejarandaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.le.www.toollibrary.ToolLibrary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 使用module中的类
        ToolLibrary.test();
        // 使用module中资源
        String s = getString(R.string.test);


        Log.i("ToolLibrary", "BuildConfig.DEBUG:" + BuildConfig.DEBUG);
    }
}
