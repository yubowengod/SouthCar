package com.example.identity_pic.identity_num.identity_num_result_main_returnfrompc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
public class identity_num_result_main_returnfrompc_activity_ItemEntity {

    private ArrayList<String> picpath;
    private ArrayList<String> biaodingzhi;
    private ArrayList<String> shuipingzuida;
    private ArrayList<String> shuipingzuixiao;
    private ArrayList<String> chuizhizuida;
    private ArrayList<String> chuizhizuixiao;

    public identity_num_result_main_returnfrompc_activity_ItemEntity(ArrayList<String> picpath,ArrayList<String> biaodingzhi,ArrayList<String> shuipingzuida,ArrayList<String> shuipingzuixiao,ArrayList<String> chuizhizuida,ArrayList<String> chuizhizuixiao)
    {
        super();
        this.picpath = picpath;
        this.biaodingzhi = biaodingzhi;
        this.shuipingzuida = shuipingzuida;
        this.shuipingzuixiao = shuipingzuixiao;
        this.chuizhizuida = chuizhizuida;
        this.chuizhizuixiao = chuizhizuixiao;
    }


    public ArrayList<String> getPicpath() { return picpath; }
    public void setPicpath(ArrayList<String> picpath) {
        this.picpath = picpath;
    }

    public ArrayList<String> getBiaodingzhi() { return biaodingzhi; }
    public void setBiaodingzhi(ArrayList<String> biaodingzhi) {
        this.biaodingzhi = biaodingzhi;
    }

    public ArrayList<String> getShuipingzuida() { return shuipingzuida; }
    public void setShuipingzuida(ArrayList<String> shuipingzuida) {
        this.shuipingzuida = shuipingzuida;
    }

    public ArrayList<String> getShuipingzuixiao() { return shuipingzuixiao; }
    public void setShuipingzuixiao(ArrayList<String> shuipingzuixiao) {
        this.shuipingzuixiao = shuipingzuixiao;
    }

    public ArrayList<String> getChuizhizuida() { return chuizhizuida; }
    public void setChuizhizuida(ArrayList<String> chuizhizuida) {
        this.chuizhizuida = chuizhizuida;
    }

    public ArrayList<String> getChuizhizuixiao() { return chuizhizuixiao; }
    public void setChuizhizuixiao(ArrayList<String> chuizhizuixiao) {
        this.chuizhizuixiao = chuizhizuixiao;
    }


    @Override
    public String toString() {
        return "ItemEntity ["
                + "picpath=" + picpath +","
                +"biaodingzhi=" + biaodingzhi +","
                +"shuipingzuida=" + shuipingzuida +","
                +"shuipingzuixiao=" + shuipingzuixiao +","
                +"chuizhizuida=" + chuizhizuida +","
                +"chuizhizuixiao=" + chuizhizuixiao
                + "]";
    }
}
