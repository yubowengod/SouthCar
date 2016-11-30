package com.example.identity_pic.identity_num.two_door.identity_num_listview_main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.one_door.identity_num_listview_main.identity_num_listview_main_activity2;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.List;

/**
 * Created by GOD on 2016/10/24.
 */
public class identity_2_listview_main_activity1 extends AppCompatActivity{
    private int flag = 1;
    private static final int REQUEST_CODE = 0;
    private Button btn_r;
    private Button btn_m;
    private Button btn_l;
    private ImageView avatar;
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };
    private TextView textView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_listview_main);
        textView=(TextView)findViewById(R.id.identity_num_listview_main_listview_item_name);
        if (flag==1){
            textView.setText(identity_2_activity.no2_weizhi[0]);
        }
        else if (flag==2){
            textView.setText(identity_2_activity.no2_weizhi[1]);
        }
        else if (flag==3){
            textView.setText(identity_2_activity.no2_weizhi[2]);
        }
        else if (flag==4){
            textView.setText(identity_2_activity.no2_weizhi[3]);
        }

        avatar=(ImageView)findViewById(R.id.identity_num_listview_main_listview_item_avatar);
        Glide.with(identity_2_listview_main_activity1.this).load(identity_2_activity.no2[0]).fitCenter().skipMemoryCache(true).into(avatar);
        btn_m=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_mid);

        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImgSelConfig config = new ImgSelConfig.Builder(loader)
                        // 是否多选
                        .multiSelect(false)
                        // 确定按钮背景色
                        .btnBgColor(Color.GRAY)
                        // 确定按钮文字颜色
                        .btnTextColor(Color.BLUE)
                        // 使用沉浸式状态栏
                        .statusBarColor(Color.parseColor("#3F51B5"))
                        // 返回图标ResId
                        .backResId(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)
                        .title("图片")
                        .titleColor(Color.WHITE)
                        .titleBgColor(Color.parseColor("#3F51B5"))
                        .cropSize(1, 1, 200, 200)
                        .needCrop(false)
                        // 第一个是否显示相机
                        .needCamera(true)
                        // 最大选择图片数量
                        .maxNum(9)
                        .build();
                ImgSelActivity.startActivity(identity_2_listview_main_activity1.this, config, REQUEST_CODE);
            }
        });

        btn_r=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_right);
        btn_l=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_left);

        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag==1){
                    Toast.makeText(identity_2_listview_main_activity1.this, "此项为第一项", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(identity_2_listview_main_activity1.this,identity_2_listview_main_activity2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            Glide.with(identity_2_listview_main_activity1.this).load(pathList.get(0)).fitCenter().skipMemoryCache(true).into(avatar);
            identity_2_activity.no2[0] = pathList.get(0);
        }
    }
}