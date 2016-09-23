package com.example.login_register_update_findinfomation.findinformation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.god.southcar.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/9/23.
 */
public class findpassword extends Activity {

    private EditText findpassword_input_name;
    private TextView findpassword_question;
    private EditText findpassword_input_answer;
    private TextView findpassword_password;
    private Button findpassword_btn;

    private static String result;

    private String flag = "0";//get_question 0 get_password 1

    private ExecutorService executorService;

    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 1111) {
                //只要在主线程就可以处理ui
                ((ImageView) findpassword.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    private Handler mainHandler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 1112) {
                //只要在主线程就可以处理ui
                ((ImageView) findpassword.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findpassword);
        //初始化
        executorService = Executors.newFixedThreadPool(5);

        findpassword_input_name = (EditText) findViewById(R.id.findpassword_input_name);
        findpassword_question = (TextView) findViewById(R.id.findpassword_question);
        findpassword_input_answer = (EditText) findViewById(R.id.findpassword_input_answer);
        findpassword_password = (TextView) findViewById(R.id.findpassword_password);
        findpassword_btn = (Button) findViewById(R.id.findpassword_btn);

        findpassword_input_answer.getText().toString();

        findpassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_question(flag);
            }
        });

    }
    public void get_question(String flag_1){
        final String get_password_by_question_flag = flag_1;
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                findpassword_oracle.getImageromSdk(
                        get_password_by_question_flag,
                        findpassword_input_name.getText().toString(),
                        findpassword_question.getText().toString(),
                        findpassword_input_answer.getText().toString(),
                        findpassword_password.getText().toString()
                );

                try {
                    mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        findpassword_question.setText(findpassword_oracle.getList_result());
                        findpassword_btn.setText("获取密码");
                        flag = "1";
                    }
                });
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void get_password(String flag_1){

    }
}
