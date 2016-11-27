package com.example;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.upload.gap_upload_identity_result;
import com.example.upload.gap_upload_identity_result_test;
import com.example.upload.test_mul;
import com.example.upload.test_mul_test;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/10/22.
 */

public class test_activity extends AppCompatActivity {


    private static final int REQUEST_CODE = 0;
    private TextView tvResult;
    private SimpleDraweeView draweeView;
    ArrayList<String> pic_path=new ArrayList<>();
    ArrayList<String> pic_path_flag=new ArrayList<>();
    ArrayList<String> pic_path_test=new ArrayList<>();
//     String  pic_path_flag;
//     String  pic_path_test;
    private ExecutorService executorService;
    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2010) {
                //只要在主线程就可以处理ui
                ((TextView) test_activity.this.findViewById(msg.arg1)).setText((String) msg.obj);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.test);
        executorService = Executors.newFixedThreadPool(5);//开启5个线程，其实根据你的情况，一般不会超过8个

        tvResult = (TextView) findViewById(R.id.tvResult);
        draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
    }
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };

    public void Multiselect(View view) {
        tvResult.setText("");
        ImgSelConfig config = new ImgSelConfig.Builder(loader).multiSelect(true)
                // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#3F51B5")).build();

        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }

    public void upload(View view){
        if (pic_path.size()>0){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    test_mul.getImageromSdk(pic_path);
//                    pic_path.clear();
                    pic_path_flag.add("1");
                    pic_path_test.add("C:\\Users\\GOD\\Pictures\\picture\\6.jpg");
                    gap_upload_identity_result_test.getImageromSdk(pic_path_flag,pic_path_test);

                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tvResult.setText(gap_upload_identity_result_test.getList_result());
                            }
                        });

                }
            });
        }
        else{
            Toast.makeText(test_activity.this, "!!!", Toast.LENGTH_SHORT).show();
        }
    }


    public void Single(View view) {
        tvResult.setText("");
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

        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            pic_path.add(pathList.get(0));
            // 测试Fresco。可不理会
            // draweeView.setImageURI(Uri.parse("file://"+pathList.get(0)));
            for (String path : pathList) {
                tvResult.append(path + "\n");
            }
        }
    }
}





