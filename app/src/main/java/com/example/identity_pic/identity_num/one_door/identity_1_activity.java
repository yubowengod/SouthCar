package com.example.identity_pic.identity_num.one_door;

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
public class identity_1_activity extends AppCompatActivity {

    public static String [] no1 = new String[4];
    public static String [] no1_weizhi = {"左上角","右上角","右下角","左下角"};
    public static String [] no1_weizhi_flag = {"1","2","3","4"};

    private Button identity_1_activity_btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_1);
//        no1 = new String[4];
        identity_1_activity_btn = (Button) findViewById(R.id.btn_identity_1_bottom);
        identity_1_activity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(identity_1_activity.this,identity_num_listview_main_activity1.class);
                startActivity(intent);
            }
        });
    }
}
