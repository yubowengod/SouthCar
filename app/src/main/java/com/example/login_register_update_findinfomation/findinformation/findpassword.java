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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.Register_SpinnerAdapter;
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
    private Spinner findpassword_Spinner;

    private static String result;

    private String flag = "1";//get_question 0 get_password 1

    private ExecutorService executorService;

    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2012) {
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
            if (msg.what == 2013) {
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
//        findpassword_question = (TextView) findViewById(R.id.findpassword_question);
        findpassword_input_answer = (EditText) findViewById(R.id.findpassword_input_answer);
        findpassword_password = (TextView) findViewById(R.id.findpassword_password);
        findpassword_btn = (Button) findViewById(R.id.findpassword_btn);

        findpassword_Spinner=(Spinner)findViewById(R.id.findpassword_Spinner);
        String [] findpassword_qusetion_str = {"我的电话","我的名字","我的生日"};
        Register_SpinnerAdapter findpassword_spinnerAdapter=new Register_SpinnerAdapter(findpassword.this,android.R.layout.simple_spinner_item,findpassword_qusetion_str);
        findpassword_Spinner.setAdapter(findpassword_spinnerAdapter);
        findpassword_Spinner.setSelection(0,true);  //设置默认选中项，此处为默认选中第4个值

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
                        findpassword_password.getText().toString(),
                        findpassword_Spinner.getSelectedItem().toString(),
                        findpassword_input_answer.getText().toString()
                );

                try {
                    mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (findpassword_oracle.getList_result().equals("anyType{}"))
                        {
                            Toast.makeText(findpassword.this, "您输入的信息有误，请重新输入！", Toast.LENGTH_SHORT).show();
                            findpassword_password.setText("");
                        }
                        else
                        {
                            findpassword_password.setText(findpassword_oracle.getList_result());
                            Toast.makeText(findpassword.this, "您已经成功找回密码，请牢记！", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
