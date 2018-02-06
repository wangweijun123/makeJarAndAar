package com.le.www.makejarandaar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.MyClass;
import com.udacity.gradle.jokes.Joker;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 使用module中的类
//        ToolLibrary.test();
        // 使用module中资源
        String s = getString(R.string.test);
        String flavor = BuildConfig.FLAVOR;

        Log.i("ToolLibrary", "BuildConfig.DEBUG:" + BuildConfig.DEBUG+
                ", testss:"+s+", flavor:"+flavor+
        ", channel:"+BuildConfig.CHANNEL);


        tv=(TextView)findViewById(R.id.textView1);
        tv.setText("跳转html activity");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HtmlActivity.class));
            }
        });
        new Joker().getJoke();
        new MyClass();
        com.le.www.makejarandaar.BuildConfig bb;

        Application application = getApplication();
       Context context = getApplicationContext();
        Log.i("ToolLibrary", "application:"+application+", context:"+context
        +", " + (application == context));

    }



}
