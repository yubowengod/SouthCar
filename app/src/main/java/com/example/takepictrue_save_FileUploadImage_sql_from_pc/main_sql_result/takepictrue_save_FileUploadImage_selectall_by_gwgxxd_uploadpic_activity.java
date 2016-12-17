package com.example.takepictrue_save_FileUploadImage_sql_from_pc.main_sql_result;

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
import com.example.imagedemo.ItemEntity;
import com.example.imagedemo.ListItemAdapter;
import com.example.picturewall.PhotoWallAdapter;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.main_deal.takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.oracle.takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.oracle.takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/12/17.
 */
public class takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity extends AppCompatActivity {

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
                ((ImageView) takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    public static String updatetime_send;
    public static String [] updatetime = new String[9];

    private void test()
    {
        Toast.makeText(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity.this, "aaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

        executorService.submit(new Runnable() {
            @Override
            public void run() {

                takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.get_takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd(
                        "updatetime",
                        "updatetime",
                        "heihei",
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[0],
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[2],
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[3],
                        takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[4]
                );



                updatetime = new String[takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size()];

                for (int i = 0 ;i < takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size(); i++)
                {
                    updatetime[i] = takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().get(i);
                }

                final String [][] updatetime_picinfo = new String[takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size()][];

                for (int i = 0 ;i < takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size(); i++)
                {
                    takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info.get_takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd(
                            "phonetupianlujing",
                            updatetime[i],
                            "heihei",
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[0],
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[1],
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[2],
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[3],
                            takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.xianlu_chehao_gwgxxd[4]
                    );
                    List<String> picinfo = new ArrayList<String>();

                    updatetime_picinfo[i] = new String[takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info.getList_result().size()];

                    for (int j=0;j<takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info.getList_result().size();j++)
                    {
                        updatetime_picinfo[i][j] = takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info.getList_result().get(j);
                    }
                }

                final int ww = takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size();

                final int www = takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name.getList_result().size();

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
                            listview.setAdapter(new ListItemAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity.this, itemEntities));


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
    }
}
