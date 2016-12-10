package com.example.identity_pic.identity_num.three_door.identity_num_listview_main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.three_door.identity_num_result_main.identity_3_result_main_activity;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.List;

/**
 * Created by GOD on 2016/10/24.
 */
public class identity_3_listview_main_activity3 extends AppCompatActivity{
    private int flag = 3;

    private static final int REQUEST_CODE = 0;
    private Button btn_r;
    private Button btn_m;
    private Button btn_l;
    private ImageView avatar;
    private AlertDialog ad;
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
            textView.setText(identity_3_activity.no3_weizhi[0]);
        }
        else if (flag==2){
            textView.setText(identity_3_activity.no3_weizhi[1]);
        }
        else if (flag==3){
            textView.setText(identity_3_activity.no3_weizhi[2]);
        }
        avatar=(ImageView)findViewById(R.id.identity_num_listview_main_listview_item_avatar);
        Glide.with(identity_3_listview_main_activity3.this).load(identity_3_activity.no3[2]).fitCenter().skipMemoryCache(true).into(avatar);
        btn_m=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_mid);

        btn_r=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_right);
        btn_l=(Button)findViewById(R.id.identity_num_listview_main_listview_item_btn_left);


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
                ImgSelActivity.startActivity(identity_3_listview_main_activity3.this, config, REQUEST_CODE);
            }
        });
        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(identity_3_listview_main_activity3.this,identity_3_listview_main_activity2.class);
                startActivity(intent);
                finish();
            }
        });
        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag==3){
                    Toast.makeText(identity_3_listview_main_activity3.this, "此项为最后一项", Toast.LENGTH_SHORT).show();
                }
                new AlertDialog.Builder(identity_3_listview_main_activity3.this)
                        .setTitle("确认")
                        .setMessage("确定吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(identity_3_listview_main_activity3.this,identity_3_result_main_activity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            Glide.with(identity_3_listview_main_activity3.this).load(pathList.get(0)).fitCenter().skipMemoryCache(true).into(avatar);
            identity_3_activity.no3[2] = pathList.get(0);
        }
    }
}