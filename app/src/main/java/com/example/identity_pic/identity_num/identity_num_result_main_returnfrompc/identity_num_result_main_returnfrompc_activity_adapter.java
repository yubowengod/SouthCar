package com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_num.one_door.identity_1_activity;
import com.example.identity_pic.identity_num.three_door.identity_3_activity;
import com.example.identity_pic.identity_num.two_door.identity_2_activity;
import com.example.identity_pic.identity_selsect_sum.identity_deal.identity_deal_main_activity;
import com.example.upload.gap_upload_identity_result;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/11/26.
 */
public class identity_num_result_main_returnfrompc_activity_adapter extends BaseAdapter {
    /** 上下文 */
    private Context ctx;
    /** 图片Url集合 */
    private ArrayList<String> picpath;
    private ArrayList<String> biaodingzhi;
    private ArrayList<String> shuipingzuida;
    private ArrayList<String> shuipingzuixiao;
    private ArrayList<String> chuizhizuida;
    private ArrayList<String> chuizhizuixiao;

    public identity_num_result_main_returnfrompc_activity_adapter(Context ctx,ArrayList<String> picpath,ArrayList<String> biaodingzhi,ArrayList<String> shuipingzuida,ArrayList<String> shuipingzuixiao,ArrayList<String> chuizhizuida,ArrayList<String> chuizhizuixiao)
    {
        this.ctx = ctx;
        this.picpath = picpath;
        this.biaodingzhi = biaodingzhi;
        this.shuipingzuida = shuipingzuida;
        this.shuipingzuixiao = shuipingzuixiao;
        this.chuizhizuida = chuizhizuida;
        this.chuizhizuixiao = chuizhizuixiao;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return picpath == null ? 0 : picpath.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return picpath.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(ctx, R.layout.identity_num_result_main_returnfrompc_activity_item, null);

        ImageView identity_num_result_main_returnfrompc_activity_item_imageview = (ImageView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_imageview);
        Glide.with(ctx).load(picpath.get(position)).fitCenter().skipMemoryCache(true).into(identity_num_result_main_returnfrompc_activity_item_imageview);

        TextView identity_num_result_main_returnfrompc_activity_item_biaodingzhi = (TextView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_biaodingzhi);
        identity_num_result_main_returnfrompc_activity_item_biaodingzhi.setText(biaodingzhi.get(position));

        TextView identity_num_result_main_returnfrompc_activity_item_shuipingzuidazhi = (TextView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_shuipingzuidazhi);
        identity_num_result_main_returnfrompc_activity_item_shuipingzuidazhi.setText(shuipingzuida.get(position));

        TextView identity_num_result_main_returnfrompc_activity_item_shuipingzuixiaozhi = (TextView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_shuipingzuixiaozhi);
        identity_num_result_main_returnfrompc_activity_item_shuipingzuixiaozhi.setText(shuipingzuixiao.get(position));

        TextView identity_num_result_main_returnfrompc_activity_item_chuizhizuidazhi = (TextView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_chuizhizuidazhi);
        identity_num_result_main_returnfrompc_activity_item_chuizhizuidazhi.setText(chuizhizuida.get(position));

        TextView identity_num_result_main_returnfrompc_activity_item_chuizhizuixiaozhi = (TextView) view.findViewById(R.id.identity_num_result_main_returnfrompc_activity_item_chuizhizuixiaozhi);
        identity_num_result_main_returnfrompc_activity_item_chuizhizuixiaozhi.setText(chuizhizuixiao.get(position));

        return view;
    }
}
