package com.example.identity_pic.identity_pic_main;

import android.content.Context;
import android.telecom.TelecomManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/10/19.
 */
public class identity_pic_main_java_adapter extends BaseAdapter {

    /** 上下文 */
    private Context ctx;
    /** 图片Url集合 */
    private ArrayList<String> leibie;
    private ArrayList<Integer> leibie_pic;

    public identity_pic_main_java_adapter(Context ctx, ArrayList<String> leibie,ArrayList<Integer> leibie_pic) {
        this.ctx = ctx;
        this.leibie = leibie;
        this.leibie_pic = leibie_pic;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return leibie_pic == null ? 0 : leibie_pic.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return leibie_pic.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(ctx, R.layout.identity_pic_main_listview_tem, null);

        TextView textView = (TextView) view.findViewById(R.id.identity_name);
        textView.setText(leibie.get(position));

        ImageView imageView = (ImageView) view.findViewById(R.id.identity_avatar);
        Glide.with(ctx).load(leibie_pic.get(position)).fitCenter().skipMemoryCache(true).into(imageView);

        return view;
    }

}
