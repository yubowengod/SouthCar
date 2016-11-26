package com.example.identity_pic.identity_num.identity_num_result_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_1_activity;
import com.example.identity_pic.identity_num.identity_num_listview_main.identity_num_listview_main_activity1;

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

        Button identity_num_result_main_btn_right = (Button) findViewById(R.id.identity_num_result_main_btn_right);
        Button identity_num_result_main_btn_left = (Button) findViewById(R.id.identity_num_result_main_btn_left);

        identity_num_result_main_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(identity_num_result_main_activity.this, "fuck you!", Toast.LENGTH_SHORT).show();
            }
        });
        identity_num_result_main_btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identity_1_activity.no1 = new String[4];
                Intent intent = new Intent(identity_num_result_main_activity.this,identity_num_listview_main_activity1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
