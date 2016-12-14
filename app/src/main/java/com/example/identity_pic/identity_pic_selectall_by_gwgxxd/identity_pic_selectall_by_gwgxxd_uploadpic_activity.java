package com.example.identity_pic.identity_pic_selectall_by_gwgxxd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_pic_selectall_by_gwgxxd.identity_deal.xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity;
import com.example.imagedemo.ItemEntity;
import com.example.imagedemo.ListItemAdapter;
import com.example.oracle.identity_selectall_from_pc_by_user_gw_gx_xd_info_name;
import com.example.oracle.identity_selectall_from_pc_by_user_gw_gx_xd_info;
import com.example.picturewall.PhotoWallAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 照片墙主活动，使用GridView展示照片墙。
 *
 * @author guolin
 */
public class identity_pic_selectall_by_gwgxxd_uploadpic_activity extends AppCompatActivity {

    private ExecutorService executorService;
    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter mAdapter;

    private int mImageThumbSize;
    private int mImageThumbSpacing;


    /** Item数据实体集合 */
    private ArrayList<ItemEntity> itemEntities;
    private ArrayList<ItemEntity> pic_itemEntities;
    /** ListView对象 */
    private ListView listview;


    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2017) {
                //只要在主线程就可以处理ui
                ((ImageView) identity_pic_selectall_by_gwgxxd_uploadpic_activity.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    public static String updatetime_send;
    public static String [] updatetime = new String[9];
    private void test()
    {

        executorService.submit(new Runnable() {
            @Override
            public void run() {

                identity_selectall_from_pc_by_user_gw_gx_xd_info_name.get_identity_selectall_from_pc_by_user_gw_gx_xd(
                        "updatetime",
                        "updatetime",
                        "heihei",
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[0],
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[2],
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[3],
                        xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[4]
                );



                updatetime = new String[identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size()];

                for (int i = 0 ;i < identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size(); i++)
                {
                    updatetime[i] = identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().get(i);
                }

                final String [][] updatetime_picinfo = new String[identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size()][];

                for (int i = 0 ;i < identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size(); i++)
                {
                    identity_selectall_from_pc_by_user_gw_gx_xd_info.get_identity_selectall_from_pc_by_user_gw_gx_xd(
                            "phonetupianlujing",
                            updatetime[i],
                            "heihei",
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[0],
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[2],
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[3],
                            xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[4]
                    );
                    List<String> picinfo = new ArrayList<String>();

                    updatetime_picinfo[i] = new String[identity_selectall_from_pc_by_user_gw_gx_xd_info.getList_result().size()];

                    for (int j=0;j<identity_selectall_from_pc_by_user_gw_gx_xd_info.getList_result().size();j++)
                    {
                        updatetime_picinfo[i][j] = identity_selectall_from_pc_by_user_gw_gx_xd_info.getList_result().get(j);
                    }
                }

                final int ww = identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size();

                final int www = identity_selectall_from_pc_by_user_gw_gx_xd_info_name.getList_result().size();

                try {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {


                            itemEntities = new ArrayList<ItemEntity>();

                            ItemEntity [] entity_oracle = new ItemEntity[ww];

                            for (int i =0;i<ww;i++)
                            {
                                ArrayList<String> urls_oracle = new ArrayList<String>();
                                for (int j=0;j<updatetime_picinfo[i].length;j++)
                                {
                                    urls_oracle.add(updatetime_picinfo[i][j]);
                                }
                                entity_oracle[i] = new ItemEntity(updatetime_picinfo[i][0],updatetime[i],null,urls_oracle);

                                itemEntities.add(entity_oracle[i]);

                            }
                            listview.setAdapter(new ListItemAdapter(identity_pic_selectall_by_gwgxxd_uploadpic_activity.this, itemEntities));


                        }
                    });

                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_uploadpic);

        executorService = Executors.newFixedThreadPool(5);
        listview = (ListView) findViewById(R.id.listview);
        test();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(identity_pic_selectall_by_gwgxxd_uploadpic_activity.this, updatetime[i], Toast.LENGTH_SHORT).show();
                updatetime_send = updatetime[i];
                Intent intent = new Intent(identity_pic_selectall_by_gwgxxd_uploadpic_activity.this,identity_num_result_main_returnfrompc_by_gwgxxd_activity.class);
                startActivity(intent);
            }
        });

    }
}