package com.example.main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.god.southcar.R;
import com.example.picturewall.PhotoWallAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by GOD on 2016/9/21.
 */
public class MyFragment extends Fragment {

    //定义图标数组
    private int[] imageRes = {
            R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d,
            R.mipmap.e,
            R.mipmap.f,
            R.mipmap.g,
            R.mipmap.h,
            R.mipmap.i
    };

    //定义图标下方的名称数组
    private String[] name = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9"
    };

    private String content;
    public MyFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
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


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        GridView gridview = (GridView) getActivity().findViewById(R.id.gridview);
        int length = imageRes.length;

        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageRes[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            lstImageItem.add(map);
        }

        //生成适配器的ImageItem 与动态数组的元素相对应
        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(),
                lstImageItem,//数据来源
                R.layout.item,//item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.img_shoukuan, R.id.txt_shoukuan});
        //添加并且显示
        gridview.setAdapter(saImageItems);
        //添加消息处理
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),xianlu_main_activity.class);
                getActivity().startActivity(intent);

//                getActivity().finish();
//                Toast.makeText(getActivity(),name[position],Toast.LENGTH_LONG).show();
            }
        });
        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);
        mPhotoWall = (GridView) getActivity().findViewById(R.id.gridview);
        mAdapter = new PhotoWallAdapter(getActivity(), 0, MainActivity_slider_pic_src.imageThumbUrls,mPhotoWall);
        mPhotoWall.setAdapter(mAdapter);
        mPhotoWall.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        final int numColumns = (int) Math.floor(mPhotoWall
                                .getWidth()
                                / (mImageThumbSize + mImageThumbSpacing));
                        if (numColumns > 0) {
                            int columnWidth = (mPhotoWall.getWidth() / numColumns)
                                    - mImageThumbSpacing;
                            mAdapter.setItemHeight(columnWidth);
                            mPhotoWall.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                        }
                    }
                }
        );
    }

    @Override
    public void onPause() {
        super.onPause();
        mAdapter.fluchCache();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        mAdapter.cancelAllTasks();
    }
}
