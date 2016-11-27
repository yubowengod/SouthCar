package com.example.login_register_update_findinfomation.register;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaExtractor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapter.Register_SpinnerAdapter;
import com.example.CustomDialog.CustomDialog;
import com.example.god.southcar.MainActivity_slider;
import com.example.god.southcar.R;
import com.example.login_register_update_findinfomation.login.Login;
import com.example.main.crm_main_activity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/9/22.
 */
public class Register extends Activity {

    private TextView username;
    private TextView password;
    private TextView repassword;
    private TextView question;
    private TextView answer;
    private Button register_btn;
    private Spinner register_spinner;

    private AlertDialog regiseter_popup;

    private ExecutorService executorService;

    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2015) {
                //只要在主线程就可以处理ui
                ((TextView) Register.this.findViewById(msg.arg1)).setText((String) msg.obj);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        executorService = Executors.newFixedThreadPool(5);

        username = (EditText) findViewById(R.id.register_input_name);
        password = (EditText) findViewById(R.id.register_input_password);
        repassword = (EditText) findViewById(R.id.register_input_repassword);
//        question = (EditText) findViewById(R.id.register_input_question);
        answer = (EditText) findViewById(R.id.register_input_answer);
        register_btn = (Button) findViewById(R.id.register_btn);

        String [] register_qusetion_str = {"我的电话","我的名字","我的生日"};
        register_spinner = (Spinner) findViewById(R.id.register_spinner);
        Register_SpinnerAdapter register_spinnerAdapter=new Register_SpinnerAdapter(Register.this,android.R.layout.simple_spinner_item,register_qusetion_str);
        register_spinner.setAdapter(register_spinnerAdapter);
        register_spinner.setSelection(0,true);  //设置默认选中项，此处为默认选中第4个值





        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().length()!=0&&
                         password.getText().toString().length()!=0&&
                         answer.getText().toString() .length()!=0
                        )
                {
                    if (password.getText().toString().equals(repassword.getText().toString()))
                    {
                        CustomDialog.Builder builder = new CustomDialog.Builder(Register.this);
                        builder.setquestion(register_spinner.getSelectedItem().toString());
                        builder.setanswer(answer.getText().toString());
                        builder.setTitle("确认密保问题");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                                final ProgressDialog Progress_Dialog = ProgressDialog.show(Register.this, "注册信息中", "请稍候...", true);

                                executorService.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        Register_oracle.getImageromSdk(
                                                username.getText().toString(),
                                                password.getText().toString(),
                                                register_spinner.getSelectedItem().toString(),
                                                answer.getText().toString()
                                        );
                                        try
                                        {
                                            mainHandler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (Register_oracle.getList_result().equals("0"))
                                                    {
                                                        Progress_Dialog.dismiss();
                                                        Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_SHORT).show();
                                                        finish();
                                                    }

                                                    if (Register_oracle.getList_result().equals("1"))
                                                    {
                                                        Progress_Dialog.dismiss();
                                                        Toast.makeText(Register.this, "用户名已经存在！", Toast.LENGTH_SHORT).show();
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
                        });

                        builder.setNegativeButton("取消",
                                new android.content.DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                        builder.create().show();
                    }
                    String w =password.getText().toString();
                    String ww = repassword.getText().toString();
                    if (!(password.getText().toString().equals(repassword.getText().toString())))
                    {
                        showDialog("两次密码输入不一致，请重新输入！");

                    }
                }
                else  if (username.getText().toString().length()==0&&
                        password.getText().toString().length()==0&&
                        answer.getText().toString() .length()==0
                        )  {
                    showDialog("请输入未填写信息！");
                }

            }
        });

    }

    private void showDialog(String string) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
        builder.setTitle("错误").setIcon(android.R.drawable.stat_notify_error);
        builder.setMessage(string);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        dialog = builder.create();
        dialog.show();
    }

}
