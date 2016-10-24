package com.example.identity_pic.identity_num.identity_num_result_main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_1_activity;

/**
 * Created by GOD on 2016/10/25.
 */
public class identity_num_result_main_activity extends AppCompatActivity {
    private GridView identity_num_result_main_view;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main);
        identity_num_result_main_view = (GridView) findViewById(R.id.identity_num_result_main_view);
        identity_num_result_main_view.setAdapter(new identity_num_result_main_activity_adapter(
                identity_num_result_main_activity.this,
                identity_1_activity.no1,identity_1_activity.no1_weizhi));
    }
}
