package com.example;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.example.identity_pic.identity_selsect_sum.identity_deal.identity_deal_main_activity;
import com.example.upload.gap_upload_identity_result;
import com.example.upload.test_mul;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/10/22.
 */

public class test_activity extends AppCompatActivity {


    private static final int REQUEST_CODE = 0;
    private TextView tvResult;
    private TextView tvResult1;
    private TextView tvResult2;
    private TextView tvResult3;
    private TextView tvResult4;
    private TextView tvResult5;
    private TextView tvResult6;
    private EditText editText;

    private SimpleDraweeView draweeView;
    ArrayList<String> pic_path=new ArrayList<>();
    ArrayList<String> pic_flag=new ArrayList<>();
    ArrayList<String> pic_path_test=new ArrayList<>();

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
        tvResult1 = (TextView) findViewById(R.id.tvResult1);
        tvResult2 = (TextView) findViewById(R.id.tvResult2);
        tvResult3 = (TextView) findViewById(R.id.tvResult3);
        tvResult4 = (TextView) findViewById(R.id.tvResult4);
        tvResult5 = (TextView) findViewById(R.id.tvResult5);
        tvResult6 = (TextView) findViewById(R.id.tvResult6);

        editText = (EditText) findViewById(R.id.test_edittext);
        draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
    }
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };
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
    public void Multiselect(View view) {
        tvResult.setText("");
        ImgSelConfig config = new ImgSelConfig.Builder(loader).multiSelect(true)
                // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#3F51B5")).build();

        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }

    public void upload(View view){

        editText.setText("1@2@3@4@5@6@7");

        final ProgressDialog dialog = ProgressDialog.show(test_activity.this, "数据上传中", "请稍候...", true);

        Calendar cld = Calendar.getInstance();
        int YY = cld.get(Calendar.YEAR);
        int MM = cld.get(Calendar.MONTH)+1;
        int DD = cld.get(Calendar.DATE);
        int HH = cld.get(Calendar.HOUR_OF_DAY);
        int mm = cld.get(Calendar.MINUTE);
        int ss = cld.get(Calendar.SECOND);
        int MI = cld.get(Calendar.MILLISECOND);
//                2011-12-15 10:40:10.345
        identity_deal_main_activity.nowadays = YY+"-"+MM+"-"+DD+" "+HH+":"+mm+":"+ss;

        if (pic_path_test.size()>0){
            executorService.execute(new Runnable() {
                @Override
                public void run() {

//                    String ww = editText.getText().toString();

                    String[] www =editText.getText().toString().split("@");
                    for (int i =0;i<www.length;i++)
                    {
                        pic_flag.add(www[i]);
                    }
//                    pic_flag.add(www[0]);
//                    pic_flag.add(www[1]);
//                    pic_flag.add(www[2]);
//                    pic_flag.add(www[3]);
//                    pic_path_test.add("D:\\web\\WebApplication1\\webnnn\\6.jpg");
                    gap_upload_identity_result.getImageromSdk(pic_flag,pic_path_test);

                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                if (gap_upload_identity_result.return_true_flag.size()==7)
                                {
                                    dialog.dismiss();
                                    String[] a = gap_upload_identity_result.return_true_flag.get(0).split("@");
                                    tvResult.setText(a[1]);
                                    String[] aa = gap_upload_identity_result.return_true_flag.get(1).split("@");
                                    tvResult1.setText(aa[1]);
                                    String[] aaa = gap_upload_identity_result.return_true_flag.get(2).split("@");
                                    tvResult2.setText(aaa[1]);
                                    String[] aaaa = gap_upload_identity_result.return_true_flag.get(3).split("@");
                                    tvResult3.setText(aaaa[1]);
                                    String[] aaaaa = gap_upload_identity_result.return_true_flag.get(4).split("@");
                                    tvResult4.setText(aaaaa[1]);
                                    String[] aaaaaa = gap_upload_identity_result.return_true_flag.get(5).split("@");
                                    tvResult5.setText(aaaaaa[1]);
                                    String[] aaaaaaa = gap_upload_identity_result.return_true_flag.get(6).split("@");
                                    tvResult6.setText(aaaaaaa[1]);
                                    gap_upload_identity_result.return_true_flag.clear();
                                    pic_flag.clear();
                                    pic_path_test.clear();
                                }

                            }
                        });

                }
            });
        }
        else{
            Toast.makeText(test_activity.this, "!!!", Toast.LENGTH_SHORT).show();
        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
//            pic_path.add(pathList.get(0));
//            // 测试Fresco。可不理会
//            // draweeView.setImageURI(Uri.parse("file://"+pathList.get(0)));
//            for (String path : pathList) {
//                tvResult.append(path + "\n");
//            }

            pic_path_test = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            for (String path : pic_path_test) {
                tvResult.append(path + "\n");
            }
        }
    }


    @Override
    public void finish()
    {

        gap_upload_identity_result.return_true_flag.clear();
        identity_1_activity.no1 = new String[4];
        identity_2_activity.no2 = new String[4];
        identity_3_activity.no3 = new String[3];
        identity_deal_main_activity.nowadays = "";
        super.finish();
    }
}





