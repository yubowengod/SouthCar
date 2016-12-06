package com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.example.upload.gap_upload_identity_result;

/**
 * Created by GOD on 2016/11/26.
 */
public class identity_num_result_main_returnfrompc_activity extends AppCompatActivity {
    private TextView identity_num_result_main_returnfrompc_textview_result;
    private Button identity_num_result_main_returnfrompc_btn_right;
    private int i=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main_returnfrompc);
        identity_num_result_main_returnfrompc_textview_result = (TextView) findViewById(R.id.identity_num_result_main_returnfrompc_textview_result);
        identity_num_result_main_returnfrompc_btn_right = (Button) findViewById(R.id.identity_num_result_main_returnfrompc_btn_right);
        identity_num_result_main_returnfrompc_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                i=0;
                gap_upload_identity_result.return_true_flag.clear();
                identity_1_activity.no1 = new String[4];
                identity_2_activity.no2 = new String[4];
                identity_3_activity.no3 = new String[3];

            }
        });
        for (String path : gap_upload_identity_result.return_true_flag) {
            i++;
            identity_num_result_main_returnfrompc_textview_result.append(String.valueOf(i)+": "+path + "\n");
        }
    }
}
