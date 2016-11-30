package com.example.identity_pic.identity_num.two_door.identity_num_result_main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;

/**
 * Created by GOD on 2016/10/25.
 */
public class identity_2_result_main_activity_adapter extends BaseAdapter {
    /** 上下文 */
    private Context ctx;
    /** 图片Url集合 */
    private String [] imageUrls;
    private String [] imageName;

    public identity_2_result_main_activity_adapter(Context ctx, String [] imageUrls, String [] imageName) {
        this.ctx = ctx;
        this.imageUrls = imageUrls;
        this.imageName = imageName;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageUrls == null ? 0 : imageUrls.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return imageUrls[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(ctx, R.layout.identity_num_result_main_item, null);
        TextView textView = (TextView) view.findViewById(R.id.identity_num_result_main_item_name);
        textView.setText(imageName[position]);
        ImageView imageView = (ImageView) view.findViewById(R.id.identity_num_result_main_item_avatar);
        Glide.with(ctx).load(imageUrls[position]).skipMemoryCache(true).into(imageView);
        return view;
    }

}
