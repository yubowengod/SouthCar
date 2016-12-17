package com.example.takepictrue_save_FileUploadImage_sql_from_pc.main_deal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.arlen.photo.ui.MainActivity;
import com.example.crm_main.crm_main_grid_ItemEntity;
import com.example.god.southcar.MainActivity_slider;
import com.example.god.southcar.R;
import com.example.takepictrue_save_FileUploadImage_sql_from_pc.main_sql_result.takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity;
import com.example.xianlu_main.xianlu_main_activity;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/21.
 */
public class takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity extends AppCompatActivity {

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
            if (msg.what == 2016) {
                //只要在主线程就可以处理ui
                ((ImageView) takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };



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


    private TextView txt_crm_home;
    private TextView txt_crm_reset_xianlu;
    private TextView txt_crm_reset_yemian;
    private TextView txt_crm_next;

    private TextView text_chexing;
    private TextView text_chehao;
    private TextView text_zaizhuangxianlu;

    /*
    test
     */
    private TextView test_gwgxxd_deal_main;
    public static String[] xianlu_chehao_gwgxxd = new String[5];




    private void setSelected(){
        txt_crm_home.setSelected(false);
        txt_crm_reset_xianlu.setSelected(false);
        txt_crm_reset_yemian.setSelected(false);
        txt_crm_next.setSelected(false);
    }



    MainActivity_slider mainActivity_login;

    private ArrayList<crm_main_grid_ItemEntity> itemEntities = new ArrayList<crm_main_grid_ItemEntity>();

    private Button btn_crm_main;

    private String xianlu_up_chehao  ;
    private String xianlu_up_chexing  ;
    private String xianlu_up_zaizhuangxianlu ;
    private String xianlu_up_zaizhuangxianlu_num ;
    public static String identity_deal_main_activity_gongwei_gongxu_xiangdian = "";
    public static String identity_deal_main_activity_xianlu_chehao_chexiang = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xianlu_identity_pic_selectall_by_gwgxxd_deal_main);

        btn_crm_main = (Button) findViewById(R.id.btn_crm_main);
        btn_crm_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this, takepictrue_save_FileUploadImage_selectall_by_gwgxxd_uploadpic_activity.class);

                identity_deal_main_activity_gongwei_gongxu_xiangdian = mainActivity_login.gongwei[provincePosition]+","+mainActivity_login.gongxu[provincePosition][cityPosition]+","+mainActivity_login.xiangdian[provincePosition][cityPosition][countryPosition];
                Toast.makeText(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this, "test", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        provinceSpinner = (Spinner)findViewById(R.id.spinner_gongwei);
        citySpinner = (Spinner)findViewById(R.id.spinner_gongxu);
        countySpinner = (Spinner)findViewById(R.id.spinner_xiangdian);
        test_gwgxxd_deal_main = (TextView)findViewById(R.id.test_gwgxxd_deal_main);

        Bundle bundle = this.getIntent().getExtras();

        xianlu_up_chehao = bundle.getString("chehao");
        xianlu_up_chexing = bundle.getString("chexing");
        xianlu_up_zaizhuangxianlu = bundle.getString("zaizhuangxianlu");
        xianlu_up_zaizhuangxianlu_num = bundle.getString("zaizhuangxianlu_num");
        identity_deal_main_activity_xianlu_chehao_chexiang = xianlu_up_zaizhuangxianlu+","+ xianlu_up_chehao+","+xianlu_up_chehao;


        text_chehao = (TextView) findViewById(R.id.text_chehao);
        text_chexing = (TextView) findViewById(R.id.text_chexing);
        text_zaizhuangxianlu = (TextView) findViewById(R.id.crm_main_zaizhuangxianlu);


        text_chehao.setText(xianlu_up_chehao);
        text_chexing.setText(xianlu_up_chexing);
        text_zaizhuangxianlu.setText(xianlu_up_zaizhuangxianlu);

        setSpinner();
        test_gwgxxd_deal_main.setText("请选择相应信息！！！");
        xianlu_chehao_gwgxxd[0] = xianlu_up_zaizhuangxianlu;
        xianlu_chehao_gwgxxd[1] = xianlu_up_chehao;

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
                Intent intent = new Intent(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,MainActivity_slider.class);
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
                Intent intent = new Intent(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,xianlu_main_activity.class);
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
                Intent intent = new Intent(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this, MainActivity.class);
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
        SpinnerAdapter provinceAdapter=new SpinnerAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.gongwei);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setSelection(0,true);  //设置默认选中项，此处为默认选中第4个值
        xianlu_chehao_gwgxxd[2] = mainActivity_login.gongwei[0];

        SpinnerAdapter cityAdapter=new SpinnerAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.gongxu[0]);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);  //默认选中第0个
        xianlu_chehao_gwgxxd[3] = mainActivity_login.gongxu[0][0];

        final SpinnerAdapter countyAdapter=new SpinnerAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,android.R.layout.simple_spinner_item,mainActivity_login.xiangdian[0][0]);
        countySpinner.setAdapter(countyAdapter);
        countySpinner.setSelection(0, true);
        xianlu_chehao_gwgxxd[4] = mainActivity_login.xiangdian[0][0][0];

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前省级选中的值的序号

                //将地级适配器的值改变为city[position]中的值
                SpinnerAdapter cityAdapter=new SpinnerAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,android.R.layout.simple_spinner_item,
                        mainActivity_login.gongxu[position]);

                xianlu_chehao_gwgxxd[2] = mainActivity_login.gongwei[position];

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
                SpinnerAdapter countyAdapter=new SpinnerAdapter(takepictrue_save_FileUploadImage_selectall_by_gwgxxd_deal_main_activity.this,android.R.layout.simple_spinner_item,
                        mainActivity_login.xiangdian[provincePosition][position]);

                xianlu_chehao_gwgxxd[3] = mainActivity_login.gongxu[provincePosition][position];
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
                countryPosition = position;
                xianlu_chehao_gwgxxd[4] = mainActivity_login.xiangdian[provincePosition][cityPosition][position];

//                for (String path : xianlu_chehao_gwgxxd) {
//                    test_gwgxxd_deal_main.append(path + "\n");
//                }

                test_gwgxxd_deal_main.setText(xianlu_chehao_gwgxxd[0]+","+xianlu_chehao_gwgxxd[1]+","+xianlu_chehao_gwgxxd[2]+","+xianlu_chehao_gwgxxd[3]+","+xianlu_chehao_gwgxxd[4]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
