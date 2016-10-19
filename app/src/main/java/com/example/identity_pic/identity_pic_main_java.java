package com.example.identity_pic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.crm_main.crm_main_grid_adapter;
import com.example.god.southcar.R;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/10/19.
 */
public class identity_pic_main_java extends AppCompatActivity {
    private  ArrayList<String> leibie = new ArrayList<String>(){{add("str01"); add("str02");add("str03");add("str04");}};

    private ArrayList<String> leibie_pic = new ArrayList<String>(){{add("1"); add("2");add("3");add("4");}};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_pic_main);
        ListView listView = (ListView) findViewById(R.id.identity_pic_main_listview);

        listView.setAdapter(new identity_pic_main_java_adapter(identity_pic_main_java.this,leibie,leibie_pic));
    }
}
