package com.example.crm_main;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/26.
 */
public class crm_main_grid_adapter extends BaseAdapter{
    /** 上下文 */
    private Context ctx;
    /** 图片Url集合 */
    private ArrayList<String> imageUrls;

    public crm_main_grid_adapter(Context ctx, ArrayList<String> urls) {
        this.ctx = ctx;
        this.imageUrls = urls;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageUrls == null ? 0 : imageUrls.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return imageUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(ctx, R.layout.crm_main_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.crm_main_item_imageview);
        Glide.with(ctx).load(imageUrls.get(position)).fitCenter().skipMemoryCache(true).into(imageView);
        return view;
    }

}
