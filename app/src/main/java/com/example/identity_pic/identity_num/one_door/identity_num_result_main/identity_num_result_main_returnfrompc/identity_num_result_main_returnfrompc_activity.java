package com.example.identity_pic.identity_num.one_door.identity_num_result_main.identity_num_result_main_returnfrompc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.upload.gap_upload_identity_result;

/**
 * Created by GOD on 2016/11/26.
 */
public class identity_num_result_main_returnfrompc_activity extends AppCompatActivity {
    private TextView identity_num_result_main_returnfrompc_textview_result;
    private int i=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main_returnfrompc);
        identity_num_result_main_returnfrompc_textview_result = (TextView) findViewById(R.id.identity_num_result_main_returnfrompc_textview_result);

        for (String path : gap_upload_identity_result.return_true_flag) {
            i++;
            identity_num_result_main_returnfrompc_textview_result.append(String.valueOf(i)+": "+path + "\n");
        }

        i=0;

    }
}
