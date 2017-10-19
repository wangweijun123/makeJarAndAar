package com.le.www.makejarandaar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.le.www.toollibrary.ToolLibrary;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 使用module中的类
        ToolLibrary.test();
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

    }

    TextView tv;

}
