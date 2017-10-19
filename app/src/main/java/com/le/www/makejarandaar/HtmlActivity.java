package com.le.www.makejarandaar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.le.www.toollibrary.ToolLibrary;

import java.net.URL;

public class HtmlActivity extends AppCompatActivity {
    final class ServiceJavaScriptInterface {

        ServiceJavaScriptInterface() {
        }
        @JavascriptInterface
        public void startGridViewHttp() {
            Log.i("ToolLibrary", "startGridViewHttp");
            //跳转到界面
//                startActivity(new Intent(WebHtml.this, Gridmview.class));
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        WebView mWebHtml = (WebView)findViewById(R.id.webview);
        //第一步：webview支持script脚本
        WebSettings webSetting = mWebHtml.getSettings();
        webSetting.setJavaScriptEnabled(true);
        //第二步：定义交互类与方法

        //第三步：添加script接口
        mWebHtml.addJavascriptInterface(
                new ServiceJavaScriptInterface(),"musicServiceInterfaceName");

        tv=(TextView)findViewById(R.id.textView1);
        final String html="<html><head><title>TextView使用HTML</title>" +
                "<script>  \n" +
                "function yun(){  \n" +
                "window.musicServiceInterfaceName.startGridViewHttp();  \n" +
                "}  \n" +
                "function yun1(){  \n" +
                "window.musicServiceInterfaceName.playMusicss();  \n" +
                "}  \n" +
                "</script> " +
                "</head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
                +"<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
                +"</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "<p>大于>小于<</p><p>" +
                "下面是网络图片</p><img src=\"http://i1.letvimg.com//lc07_iptv//201707//26//22//01//tmp288e1b61-9356-48dc-9190-449a4d251db1256.png\" onclick=\"yun()\"/></body></html>";

        tv.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动
//        tv.setMovementMethod(LinkMovementMethod.getInstance());// 超链接

        new Thread(new Runnable() {
            @Override
            public void run() {
                spanned = Html.fromHtml(html, imgGetter, null);
                handler.sendEmptyMessage(0);
            }
        }).start();


    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText(spanned);
        }
    };
    Spanned spanned;
    TextView tv;
    Html.ImageGetter imgGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            Log.i("ToolLibrary", "getDrawable source:"+source);
            Drawable drawable = null;
            URL url;
            try {
                url = new URL(source);
                drawable = Drawable.createFromStream(url.openStream(), "");  //获取网路图片
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                    .getIntrinsicHeight());
            Log.i("ToolLibrary", drawable.toString());
            return drawable;
        }
    };
}
