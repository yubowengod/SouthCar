package com.example.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.arlen.photo.ui.MainActivity;
import com.bumptech.glide.Glide;
import com.example.MyFragment1.MyFragment1_ItemEntity;
import com.example.crm_main.crm_main_grid_ItemEntity;
import com.example.crm_main.crm_main_grid_adapter;
import com.example.god.southcar.MainActivity_slider;
import com.example.god.southcar.R;
import com.example.imagedemo.NoScrollGridAdapter;
import com.example.picturewall.PhotoWallAdapter;
import com.example.upload.Data_up;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/21.
 */
public class crm_main_activity extends AppCompatActivity {

    private class SpinnerAdapter extends ArrayAdapter<String> {
        Context context;
        String[] items = new String[]{};

        public SpinnerAdapter(final Context context,
                              final int textViewResourceId, final String[] objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
            this.context = context;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            tv.setText(items[position]);
            tv.setGravity(Gravity.CENTER);
//            tv.setTextColor(Color.BLUE);
            tv.setTextSize(20);
            return convertView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            // android.R.id.text1 is default text view in resource of the android.
            // android.R.layout.simple_spinner_item is default layout in resources of android.

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);
            tv.setGravity(Gravity.CENTER);
//            tv.setTextColor(Color.BLUE);
            tv.setTextSize(20);
            return convertView;
        }
    }


    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2114) {
                //只要在主线程就可以处理ui
                ((ImageView) crm_main_activity.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };

    private TextView sp_text;

    private Spinner provinceSpinner = null;  //省级（省、直辖市）
    private Spinner citySpinner = null;     //地级市
    private Spinner countySpinner = null;    //县级（区、县、县级市）
    ArrayAdapter<String> provinceAdapter = null;  //省级适配器
    ArrayAdapter<String> gongweiAdapter = null;  //省级适配器
    ArrayAdapter<String> cityAdapter = null;    //地级适配器
    ArrayAdapter<String> countyAdapter = null;    //县级适配器
    static int provincePosition = 0;
    static int cityPosition = 0;
    static int countryPosition = 0;

    private String province_file;
    private TextView txt_crm_home;
    private TextView txt_crm_reset_xianlu;
    private TextView txt_crm_reset_yemian;
    private TextView txt_crm_next;

    private TextView text_chexing;
    private TextView text_chehao;
    private TextView text_zaizhuangxianlu;
//    private TextView text_zaizhuangxianlu_num;

    private ImageView crm_main_activity_imageview;

    String str;
    String chetileibie;
    private int chetileibie_num;
    String chetileibie1;
    private int chetileibie1_num;

    private void setSelected(){
        txt_crm_home.setSelected(false);
        txt_crm_reset_xianlu.setSelected(false);
        txt_crm_reset_yemian.setSelected(false);
        txt_crm_next.setSelected(false);
    }

    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;
    private ListView mPhotolist;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter mAdapter;

    private int mImageThumbSize;
    private int mImageThumbSpacing;

    MainActivity_slider mainActivity_login;

    private ArrayList<crm_main_grid_ItemEntity> itemEntities = new ArrayList<crm_main_grid_ItemEntity>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crm_main);

        provinceSpinner = (Spinner)findViewById(R.id.spinner_gongwei);
        citySpinner = (Spinner)findViewById(R.id.spinner_gongxu);
        countySpinner = (Spinner)findViewById(R.id.spinner_xiangdian);

        Bundle bundle = this.getIntent().getExtras();

        String xianlu_up_chehao = bundle.getString("chehao");
        String xianlu_up_chexing = bundle.getString("chexing");
        String xianlu_up_zaizhuangxianlu = bundle.getString("zaizhuangxianlu");
        String xianlu_up_zaizhuangxianlu_num = bundle.getString("zaizhuangxianlu_num");

        text_chehao = (TextView) findViewById(R.id.text_chehao);
        text_chexing = (TextView) findViewById(R.id.text_chexing);
        text_zaizhuangxianlu = (TextView) findViewById(R.id.crm_main_zaizhuangxianlu);
//        text_zaizhuangxianlu_num = (TextView) findViewById(R.id.crm_main_zaizhuangxianlu_num);
//        crm_main_activity_imageview = (ImageView) findViewById(R.id.crm_main_activity_imageview);

        text_chehao.setText(xianlu_up_chehao);
        text_chexing.setText(xianlu_up_chexing);
        text_zaizhuangxianlu.setText(xianlu_up_zaizhuangxianlu);
//        text_zaizhuangxianlu_num.setText(xianlu_up_zaizhuangxianlu_num);

//        ini_spinner();

        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);
        mPhotoWall = (GridView) findViewById(R.id.crm_main_gridview);

//        mPhotolist = (ListView) findViewById(R.id.crm_main_listview);
        setSpinner();

        sp_text = (TextView) findViewById(R.id.sp_text);

        txt_crm_home = (TextView) findViewById(R.id.txt_crm_home);
        txt_crm_reset_xianlu = (TextView) findViewById(R.id.txt_crm_reset_xianlu);
        txt_crm_reset_yemian = (TextView) findViewById(R.id.txt_crm_reset_yemian);
        txt_crm_next = (TextView) findViewById(R.id.txt_crm_next);

        setSelected();

        txt_crm_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected();
                txt_crm_home.setSelected(false);
                txt_crm_home.setSelected(true);
                Intent intent = new Intent(crm_main_activity.this,MainActivity_slider.class);
                startActivity(intent);
                finish();
            }
        });

        txt_crm_reset_xianlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected();
                txt_crm_reset_xianlu.setSelected(false);
                txt_crm_reset_xianlu.setSelected(true);
                Intent intent = new Intent(crm_main_activity.this,xianlu_main_activity.class);
                startActivity(intent);
                finish();
            }
        });

        txt_crm_reset_yemian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected();
                txt_crm_reset_yemian.setSelected(false);
                txt_crm_reset_yemian.setSelected(true);
                setSpinner();
            }
        });
        txt_crm_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected();
                txt_crm_next.setSelected(false);
                txt_crm_next.setSelected(true);
                Intent intent = new Intent(crm_main_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    * 设置下拉框
    */
    private void setSpinner()
    {

        //绑定适配器和值
        SpinnerAdapter provinceAdapter=new SpinnerAdapter(crm_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.gongwei);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setSelection(0,true);  //设置默认选中项，此处为默认选中第4个值

        SpinnerAdapter cityAdapter=new SpinnerAdapter(crm_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.gongxu[0]);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);  //默认选中第0个

        final SpinnerAdapter countyAdapter=new SpinnerAdapter(crm_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.xiangdian[0][0]);
        countySpinner.setAdapter(countyAdapter);
        countySpinner.setSelection(0, true);

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前省级选中的值的序号

                //将地级适配器的值改变为city[position]中的值
                SpinnerAdapter cityAdapter=new SpinnerAdapter(crm_main_activity.this,android.R.layout.simple_spinner_item,
                        mainActivity_login.gongxu[position]);
                // 设置二级下拉列表的选项内容适配器
                citySpinner.setAdapter(cityAdapter);
                provincePosition = position;    //记录当前省级序号，留给下面修改县级适配器时用

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });


        //地级下拉监听
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                SpinnerAdapter countyAdapter=new SpinnerAdapter(crm_main_activity.this,android.R.layout.simple_spinner_item,
                        mainActivity_login.xiangdian[provincePosition][position]);
                cityPosition = position;
                countySpinner.setAdapter(countyAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });

        countySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sp_text.setText(MainActivity_slider.jianceshuoming[provincePosition][cityPosition][position]);

                final ArrayList<String> imageUrls = new ArrayList<String>();

                String [] split_result = MainActivity_slider.picinfo[provincePosition][cityPosition][position].split(";");

                for (int i = 0; i<split_result.length;i++){
                    split_result[i] = Data_up.getSERVICE_URL_IP_PORT_local_file()+"example_picture/"+mainActivity_login.gongwei[provincePosition]+"/"+split_result[i]+".jpg";

                    imageUrls.add(split_result[i]);
                }

                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                       mPhotoWall.setAdapter(new crm_main_grid_adapter(crm_main_activity.this,imageUrls));
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
