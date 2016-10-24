package com.example.identity_pic.identity_num;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_num_listview_main.identity_num_listview_main_activity1;
import com.example.imagedemo.ImagePagerActivity;
import java.util.ArrayList;

/**
 * Created by GOD on 2016/10/20.
 */
public class identity_1_activity extends AppCompatActivity {

    public static String [] no1 = new String[4];
    public static String [] no1_weizhi = {"左上角","右上角","左边","右边"};
    private int pic_num = 4;
    private Button btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_1);

        btn = (Button) findViewById(R.id.btn_identity_1_bottom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(identity_1_activity.this,identity_num_listview_main_activity1.class);
                startActivity(intent);
            }
        });
    }

}
