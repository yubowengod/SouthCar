package com.example.identity_pic.identity_num.three_door;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.three_door.identity_num_listview_main.identity_3_listview_main_activity1;
import com.example.identity_pic.identity_num.two_door.identity_num_listview_main.identity_2_listview_main_activity1;
import com.example.upload.gap_upload_identity_result;

/**
 * Created by GOD on 2016/10/20.
 */
public class identity_3_activity extends AppCompatActivity {

    public static String [] no3 = new String[3];
    public static String [] no3_weizhi = {"左","中","右"};
    public static String [] no3_weizhi_flag = {"7","7","7"};

    private Button identity_3_activity_btn;
    private Button btn_identity_3_bottom_left;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_3);
        gap_upload_identity_result.return_true_flag.clear();
        no3 = new String[3];
        identity_3_activity_btn = (Button) findViewById(R.id.btn_identity_3_bottom);
        identity_3_activity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(identity_3_activity.this,identity_3_listview_main_activity1.class);
                startActivity(intent);
                finish();
            }
        });

        btn_identity_3_bottom_left = (Button) findViewById(R.id.btn_identity_3_bottom_left);
        btn_identity_3_bottom_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
