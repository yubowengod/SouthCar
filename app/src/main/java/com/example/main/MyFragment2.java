package com.example.main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.identity_pic.identity_pic_selectall_by_gwgxxd.identity_pic_selectall_by_gwgxxd_select.xianlu_identity_pic_selectall_by_gwgxxd_activity;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.main.takepictrue_save_FileUploadImage_selectall_by_gwgxxd_activity;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.main_deal.takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity;
import com.example.updated_pic_info.MainActivity_uploadpic;
import com.example.picturewall.PhotoWallAdapter;

/**
 * Created by GOD on 2016/9/21.
 */
public class MyFragment2 extends Fragment {
    private String content;

    public MyFragment2(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content2,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }

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

    private Button btn_uploadpic_info;
    private Button btn_uploadpic_info_fengxi;

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        btn_uploadpic_info=(Button)getActivity().findViewById(R.id.btn_uploadpic_info);
        btn_uploadpic_info_fengxi=(Button)getActivity().findViewById(R.id.btn_uploadpic_info_fengxi);

        btn_uploadpic_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),takepictrue_save_FileUploadImage_selectall_by_gwgxxd_activity.class);
                getActivity().startActivity(intent);
            }
        });
        btn_uploadpic_info_fengxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),xianlu_identity_pic_selectall_by_gwgxxd_activity.class);
                getActivity().startActivity(intent);
            }
        });
        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);

//        mPhotoWall = (GridView) getActivity().findViewById(R.id.gridview_fg_my);
//        mAdapter = new PhotoWallAdapter(getActivity(), 0, Images.imageThumbUrls,mPhotoWall);
//        mPhotoWall.setAdapter(mAdapter);
//        mPhotoWall.getViewTreeObserver().addOnGlobalLayoutListener(
//                new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        final int numColumns = (int) Math.floor(mPhotoWall
//                                .getWidth()
//                                / (mImageThumbSize + mImageThumbSpacing));
//                        if (numColumns > 0) {
//                            int columnWidth = (mPhotoWall.getWidth() / numColumns)
//                                    - mImageThumbSpacing;
//                            mAdapter.setItemHeight(columnWidth);
//                            mPhotoWall.getViewTreeObserver()
//                                    .removeGlobalOnLayoutListener(this);
//                        }
//                    }
//                }
//        );

    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        mAdapter.fluchCache();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        // 退出程序时结束所有的下载任务
//        mAdapter.cancelAllTasks();
//    }
}



