package com.example.MyFragment1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.god.southcar.R;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/25.
 */
public class MyFragment1_ListItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MyFragment1_ItemEntity> items;

    public MyFragment1_ListItemAdapter(Context ctx, ArrayList<MyFragment1_ItemEntity> items) {
        this.mContext = ctx;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.myfragment1_listview_item, null);
            holder.iv_avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyFragment1_ItemEntity itemEntity = items.get(position);
        holder.tv_title.setText(itemEntity.getTitle());
        holder.tv_content.setText(itemEntity.getContent());
        holder.tv_date.setText(itemEntity.getDate());

        // 使用ImageLoader加载网络图片
        Glide.with(mContext).load(itemEntity.getAvatar()).fitCenter().skipMemoryCache(true).into(holder.iv_avatar);
        return convertView;
    }


    /**
     * listview组件复用，防止“卡顿”
     *
     * @author Administrator
     *
     */
    class ViewHolder {
        private ImageView iv_avatar;
        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_date;
    }
}
