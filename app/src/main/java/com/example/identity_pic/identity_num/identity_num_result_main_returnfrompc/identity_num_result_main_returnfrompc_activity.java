package com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.example.identity_pic.identity_selsect_sum.identity_deal.identity_deal_main_activity;
import com.example.upload.gap_upload_identity_result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOD on 2016/11/26.
 */
public class identity_num_result_main_returnfrompc_activity extends AppCompatActivity {
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_num_result_main_returnfrompc);
        identity_num_result_main_returnfrompc_listview = (ListView) findViewById(R.id.identity_num_result_main_returnfrompc_listview);
        identity_num_result_main_returnfrompc_textview_result = (TextView) findViewById(R.id.identity_num_result_main_returnfrompc_textview_result);
        identity_num_result_main_returnfrompc_btn_right = (Button) findViewById(R.id.identity_num_result_main_returnfrompc_btn_right);

        for (int i = 0; i<gap_upload_identity_result.return_true_flag.size(); i++)
        {
            String[] return_result = gap_upload_identity_result.return_true_flag.get(i).split("@");
//            1路径
//                    2返回值
//                            3
            picpath.add(return_result[0]);

            String[] return_result_num = return_result[1].split(",");

            if (return_result_num.length==5)
            {
                biaodingzhi.add(return_result_num[0]);
                shuipingzuida.add(return_result_num[1]);
                shuipingzuixiao.add(return_result_num[2]);
                chuizhizuida.add(return_result_num[3]);
                chuizhizuixiao.add(return_result_num[4]);
            }
            if (return_result_num.length==1)
            {
                biaodingzhi.add(return_result_num[0]);
                shuipingzuida.add(return_result_num[0]);
                shuipingzuixiao.add(return_result_num[0]);
                chuizhizuida.add(return_result_num[0]);
                chuizhizuixiao.add(return_result_num[0]);
            }

        }
        for (String path : gap_upload_identity_result.return_true_flag) {
            i++;
//            identity_num_result_main_returnfrompc_textview_result.append(String.valueOf(i)+": "+path + "\n");
        }
//        listview赋值
        identity_num_result_main_returnfrompc_listview.setAdapter(new identity_num_result_main_returnfrompc_activity_adapter(
                identity_num_result_main_returnfrompc_activity.this,
                picpath,
                biaodingzhi,
                shuipingzuida,
                shuipingzuixiao,
                chuizhizuida,
                chuizhizuixiao));

        identity_num_result_main_returnfrompc_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=0;
                gap_upload_identity_result.return_true_flag.clear();
                identity_1_activity.no1 = new String[4];
                identity_2_activity.no2 = new String[4];
                identity_3_activity.no3 = new String[3];
                identity_deal_main_activity.nowadays = "";
                finish();
            }
        });
    }

    @Override
    public void finish()
    {
        i=0;
        gap_upload_identity_result.return_true_flag.clear();
        identity_1_activity.no1 = new String[4];
        identity_2_activity.no2 = new String[4];
        identity_3_activity.no3 = new String[3];
        identity_deal_main_activity.nowadays = "";
        super.finish();
    }
}
