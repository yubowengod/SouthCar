package com.example.identity_pic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_1_activity;
import com.example.identity_pic.identity_num.identity_2_activity;
import com.example.identity_pic.identity_num.identity_3_activity;
import com.example.identity_pic.identity_num.identity_4_activity;
import com.example.test_activity;
import com.example.upload.test;
import com.example.xianlu_main.xianlu_main_activity;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/10/19.
 */
public class identity_pic_main_java extends AppCompatActivity {
    private  ArrayList<String> leibie = new ArrayList<String>(){{add("str01"); add("str02");add("str03");add("str04");add("str05");}};

    private ArrayList<String> leibie_pic = new ArrayList<String>(){{add("1"); add("2");add("3");add("4");add("5");}};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_pic_main);

        ListView listView = (ListView) findViewById(R.id.identity_pic_main_listview);

        listView.setAdapter(new identity_pic_main_java_adapter(identity_pic_main_java.this,leibie,leibie_pic));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                {
                    Intent intent = new Intent(identity_pic_main_java.this,identity_1_activity.class);
                    startActivity(intent);
                }
                if (i==1)
                {
                    Intent intent = new Intent(identity_pic_main_java.this,identity_2_activity.class);
                    startActivity(intent);
                }
                if (i==2)
                {
                    Intent intent = new Intent(identity_pic_main_java.this,identity_3_activity.class);
                    startActivity(intent);
                }
                if (i==3)
                {
                    Intent intent = new Intent(identity_pic_main_java.this,identity_4_activity.class);
                    startActivity(intent);
                }
                if (i==4)
                {
                    Intent intent = new Intent(identity_pic_main_java.this,test_activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
