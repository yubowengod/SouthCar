package com.example.login_register_update_findinfomation.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.god.southcar.MainActivity_slider;
import com.example.god.southcar.R;
import com.example.login_register_update_findinfomation.findinformation.findpassword;
import com.example.login_register_update_findinfomation.register.Register;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GOD on 2016/9/21.
 */
public class Login extends Activity {
    private TextView login_input_name;
    private TextView login_input_password;
    private CheckBox login_switchBtn;

    private TextView find_password_repassword_login;
    private TextView register_login;


    public static String Login_username = "";

    private ExecutorService executorService;

    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2014) {
                //只要在主线程就可以处理ui
                ((TextView) Login.this.findViewById(msg.arg1)).setText((String) msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //初始化
        executorService = Executors.newFixedThreadPool(5);

        login_input_name = (TextView) findViewById(R.id.login_input_name);
        login_input_password = (TextView) findViewById(R.id.login_input_password);
        login_switchBtn = (CheckBox) findViewById(R.id.login_switchBtn);

        find_password_repassword_login = (TextView)findViewById(R.id.find_password_repassword_login);
        find_password_repassword_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Login.this,findpassword.class);
                startActivity(intent);
            }
        });
        register_login = (TextView) findViewById(R.id.register_login);
        register_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        onChangePassLook listener = new onChangePassLook();
        login_switchBtn.setOnCheckedChangeListener(listener);
    }


    public void checkLogin(View v) {

        final ProgressDialog dialog = ProgressDialog.show(Login.this, "验证信息中", "请稍候...", true);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                login_un_pw.getImageromSdk(login_input_name.getText().toString(),login_input_password.getText().toString());
                try
                {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (login_un_pw.getList_result().get(0).equals("1"))
                            {
                                dialog.dismiss();
                                Intent intent =new Intent(Login.this, MainActivity_slider.class);
                                startActivity(intent);
                                Login_username = login_input_name.getText().toString();
                                finish();
                            }
                            else
                            {
                                dialog.dismiss();
                                Toast.makeText(Login.this, "错误！请再次输入", Toast.LENGTH_SHORT).show();
                                login_input_name.setText("");
                                login_input_password.setText("");
                            }
                        }
                    });
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });



//        checkLoginName(login_input_name.getText().toString());
//        checkLoginPass(login_input_password.getText().toString());
//        if (checkLoginName(login_input_name.getText().toString())
//                && checkLoginPass(login_input_password.getText().toString()))
//        {
//        }
    }




    //	密码切换监听器
    class onChangePassLook implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // TODO Auto-generated method stub

            if(isChecked){
                //如果选中，显示密码
                login_input_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                //否则隐藏密码
                login_input_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }

        }

    }

    private boolean checkLoginPass(String s) {
        //正则
        String regularExpression = "[0-9]*";
        Pattern p = Pattern.compile(regularExpression);
        Matcher m =p.matcher(s);

        if (s.length() == 0) {
            //Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            login_input_password.setError(getResources().getString(R.string.please_password));
            login_input_password.requestFocus();
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                login_input_password.setError(getResources().getString(R.string.wrong_password));
                login_input_password.requestFocus();
                return false;
            }
        }

    }

    // 判断用户名是否正确
    private boolean checkLoginName(String s) {
        // 邮箱正则
        String regularExpression = "[0-9]*";
        Pattern p = Pattern.compile(regularExpression);
        Matcher m = p.matcher(s);

        if (s.length() == 0) {
            login_input_name.setError(getResources().getString(R.string.please_name));
            login_input_name.requestFocus();
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                login_input_name.setError(getResources().getString(R.string.wrong_name));
                login_input_name.requestFocus();
                return false;
            }
        }
    }


}

