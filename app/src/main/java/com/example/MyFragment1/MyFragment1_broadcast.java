package com.example.MyFragment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;

/**
 * Created by GOD on 2016/9/25.
 */
public class MyFragment1_broadcast extends AppCompatActivity {

    private TextView broadcast_content;
    private TextView broadcast_date;
    private TextView broadcast_tittle;
    private ImageView broadcast_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfragment1_broadcast);

        Bundle bundle = this.getIntent().getExtras();
        String tittle = bundle.getString("tittle");
        String date = bundle.getString("date");
        String avatar = bundle.getString("avatar");
        String content = bundle.getString("content");

        broadcast_tittle = (TextView) findViewById(R.id.broadcast_tittle);
        broadcast_date = (TextView) findViewById(R.id.broadcast_date);
        broadcast_image = (ImageView) findViewById(R.id.broadcast_image);
        broadcast_content = (TextView) findViewById(R.id.broadcast_content);

        broadcast_tittle.setText(tittle);
        broadcast_date.setText(date);
        Glide.with(MyFragment1_broadcast.this).load(avatar).fitCenter().skipMemoryCache(true).into(broadcast_image);
        broadcast_content.setText(content);
    }
}
