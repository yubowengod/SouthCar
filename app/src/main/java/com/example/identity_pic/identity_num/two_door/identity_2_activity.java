package com.example.identity_pic.identity_num.two_door;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_num_listview_main.identity_num_listview_main_activity1;

/**
 * Created by GOD on 2016/10/20.
 */
public class identity_2_activity extends AppCompatActivity {
    public static String [] no2 = new String[4];
    public static String [] no2_weizhi = {"左上角","右上角","左边","右边"};
    public static String [] no2_weizhi_flag = {"1","2","5","6"};

    private Button identity_2_activity_btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_2);
        identity_2_activity_btn = (Button) findViewById(R.id.btn_identity_2_bottom);
        identity_2_activity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(identity_2_activity.this,identity_num_listview_main_activity1.class);
                startActivity(intent);
            }
        });
    }
}