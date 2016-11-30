package com.example.identity_pic.identity_num.three_door.identity_num_result_main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc.identity_num_result_main_returnfrompc_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.three_door.identity_num_listview_main.identity_3_listview_main_activity1;
import com.example.upload.gap_upload_identity_result;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/10/25.
 */
public class identity_3_result_main_activity extends AppCompatActivity {
    private ExecutorService executorService;
    private TextView identity_num_result_main_textview;
    private Button identity_num_result_main_btn_view_result;
    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2011) {
                //只要在主线程就可以处理ui
                ((TextView) identity_3_result_main_activity.this.findViewById(msg.arg1)).setText((String) msg.obj);
            }
        }
    };
    ArrayList<String> identity_num_result_main_activity_no1=new ArrayList<>();
    ArrayList<String> no1_weizhi_num=new ArrayList<>();


    private GridView identity_num_result_main_view;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main);

        executorService = Executors.newFixedThreadPool(5);

        identity_num_result_main_view = (GridView) findViewById(R.id.identity_num_result_main_view);
        identity_num_result_main_view.setAdapter(new identity_3_result_main_activity_adapter(
                identity_3_result_main_activity.this,
                identity_3_activity.no3,identity_3_activity.no3_weizhi));

        Button identity_num_result_main_btn_right = (Button) findViewById(R.id.identity_num_result_main_btn_right);
        Button identity_num_result_main_btn_left = (Button) findViewById(R.id.identity_num_result_main_btn_left);
        identity_num_result_main_btn_view_result = (Button) findViewById(R.id.identity_num_result_main_btn_view_result);
        identity_num_result_main_textview = (TextView) findViewById(R.id.identity_num_result_main_textview);

        identity_num_result_main_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(identity_3_result_main_activity.this, "上传图片!", Toast.LENGTH_SHORT).show();
//                上传
//               1、2、3
                final ProgressDialog dialog = ProgressDialog.show(identity_3_result_main_activity.this, "数据上传中", "请稍候...", true);

                for(int i=0;i<3;i++){
                    no1_weizhi_num.add(identity_3_activity.no3_weizhi_flag[i]);
                    identity_num_result_main_activity_no1.add(identity_3_activity.no3[i]);
                }

                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        gap_upload_identity_result.getImageromSdk(no1_weizhi_num,identity_num_result_main_activity_no1);

                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (gap_upload_identity_result.return_true_flag.size() == 3)
                                {
                                    dialog.dismiss();
                                    String result = "";
                                    for (int i=0;i<3;i++)
                                    {
                                        result = result + gap_upload_identity_result.return_true_flag.get(i).toString() + " @ ";
                                    }
                                    identity_num_result_main_textview.setText(result);
                                    identity_num_result_main_btn_view_result.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                });
            }

        });
        identity_num_result_main_btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identity_3_activity.no3 = new String[3];
                Intent intent = new Intent(identity_3_result_main_activity.this,identity_3_listview_main_activity1.class);
                startActivity(intent);
                finish();
            }
        });
        identity_num_result_main_btn_view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(identity_3_result_main_activity.this,identity_num_result_main_returnfrompc_activity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
