package com.example.identity_pic.identity_pic_selectall_by_gwgxxd.identity_pic_selectall_by_gwgxxd_select;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.upload.Data_up;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/27.
 */

public class xianlu_identity_pic_selectall_by_gwgxxd_ListItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity> items;

    public xianlu_identity_pic_selectall_by_gwgxxd_ListItemAdapter(Context ctx, ArrayList<xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity> items) {
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
            convertView = View.inflate(mContext, R.layout.xianlu_main_listview_item, null);
            holder.iv_avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_chejian = (TextView) convertView.findViewById(R.id.tv_chejian);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity itemEntity = items.get(position);
        // 使用ImageLoader加载网络图片
        Glide.with(mContext).load(Data_up.getSERVICE_URL_IP_PORT_local_file_xianlu_pic()+itemEntity.getAvatar()+".jpg").fitCenter().skipMemoryCache(true).into(holder.iv_avatar);

        holder.tv_name.setText("线路："+itemEntity.getTitle());
        holder.tv_num.setText("数量："+itemEntity.getContent());
        holder.tv_chejian.setText("所在车间："+itemEntity.getChejian());

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
        private TextView tv_name;
        private TextView tv_num;
        private TextView tv_chejian;
    }
}
