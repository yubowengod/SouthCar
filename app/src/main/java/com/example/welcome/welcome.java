package com.example.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.god.southcar.R;
import com.example.login_register_update_findinfomation.login.Login;

/**
 * Created by GOD on 2016/9/21.
 */
public class welcome extends Activity {
    private final long SPLASH_LENGTH = 2000;
    Handler handler = new Handler();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        handler.postDelayed(new Runnable() {  //使用handler的postDelayed实现延时跳转

            public void run() {
                Intent intent = new Intent(welcome.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_LENGTH);//2秒后跳转至应用主界面MainActivity

    }
}
