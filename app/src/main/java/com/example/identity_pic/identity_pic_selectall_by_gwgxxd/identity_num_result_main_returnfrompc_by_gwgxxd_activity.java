package com.example.identity_pic.identity_pic_selectall_by_gwgxxd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc.identity_num_result_main_returnfrompc_activity_adapter;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.example.identity_pic.identity_selsect_sum.identity_deal.identity_deal_main_activity;
import com.example.oracle.identity_num_result_main_returnfrompc_by_gwgxxd_oracle;
import com.example.upload.gap_upload_identity_result;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/11/26.
 */
public class identity_num_result_main_returnfrompc_by_gwgxxd_activity extends AppCompatActivity {
    private TextView identity_num_result_main_returnfrompc_textview_result;
    private Button identity_num_result_main_returnfrompc_btn_right;
    private ListView identity_num_result_main_returnfrompc_listview;
    private int i=0;

    private ArrayList<String> picpath = new ArrayList<String>();
    private ArrayList<String> biaodingzhi = new ArrayList<String>();
    private ArrayList<String> shuipingzuida = new ArrayList<String>();
    private ArrayList<String> shuipingzuixiao = new ArrayList<String>();
    private ArrayList<String> chuizhizuida = new ArrayList<String>();
    private ArrayList<String> chuizhizuixiao = new ArrayList<String>();

    private ExecutorService executorService;
    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2111) {
                //只要在主线程就可以处理ui
                ((TextView) identity_num_result_main_returnfrompc_by_gwgxxd_activity.this.findViewById(msg.arg1)).setText((String) msg.obj);
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main_returnfrompc);

        executorService = Executors.newFixedThreadPool(5);

        identity_num_result_main_returnfrompc_listview = (ListView) findViewById(R.id.identity_num_result_main_returnfrompc_listview);
        identity_num_result_main_returnfrompc_textview_result = (TextView) findViewById(R.id.identity_num_result_main_returnfrompc_textview_result);
        identity_num_result_main_returnfrompc_btn_right = (Button) findViewById(R.id.identity_num_result_main_returnfrompc_btn_right);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                identity_num_result_main_returnfrompc_by_gwgxxd_oracle.get_identity_num_result_main_returnfrompc_by_gwgxxd_oracle(
                        "only_updatetime",
                        identity_pic_selectall_by_gwgxxd_uploadpic_activity.updatetime_send,
                        "user",
                        "xianlu",
                        "chehao",
                        "chexiang",
                        "gw",
                        "gx",
                        "xd"
                );

                for (int i = 0; i<identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().size();i=i+6)
                {
                    biaodingzhi.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i));
                    shuipingzuida.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i+1));
                    shuipingzuixiao.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i+2));
                    chuizhizuida.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i+3));
                    chuizhizuixiao.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i+4));
                    picpath.add(identity_num_result_main_returnfrompc_by_gwgxxd_oracle.getList_result().get(i+5));
                }

                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        identity_num_result_main_returnfrompc_listview.setAdapter(new identity_num_result_main_returnfrompc_activity_adapter(
                                identity_num_result_main_returnfrompc_by_gwgxxd_activity.this,
                                picpath,
                                biaodingzhi,
                                shuipingzuida,
                                shuipingzuixiao,
                                chuizhizuida,
                                chuizhizuixiao));
                    }
                });
            }
        });

        identity_num_result_main_returnfrompc_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
