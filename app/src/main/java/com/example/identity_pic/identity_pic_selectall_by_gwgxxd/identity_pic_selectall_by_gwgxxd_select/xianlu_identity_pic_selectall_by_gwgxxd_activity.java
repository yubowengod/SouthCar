package com.example.identity_pic.identity_pic_selectall_by_gwgxxd.identity_pic_selectall_by_gwgxxd_select;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.god.southcar.MainActivity_slider;
import com.example.god.southcar.R;
import com.example.identity_pic.identity_pic_selectall_by_gwgxxd.identity_deal.xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity;
import com.example.identity_pic.identity_selsect_sum.identity_deal.identity_deal_main_activity;
import com.example.oracle.xianlu_oracle;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by GOD on 2016/9/21.
 */
public class xianlu_identity_pic_selectall_by_gwgxxd_activity extends AppCompatActivity{

    private ExecutorService executorService;
    private TextView txt_xianlu_home;
    private TextView txt_xianlu_back;
    private String xianluname_str;
    private String xianlunum_str;
    private String chehao;
    private String chexiang;
    private AlertDialog selfdialog;
    private Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 2018) {
                //只要在主线程就可以处理ui
                ((ImageView) xianlu_identity_pic_selectall_by_gwgxxd_activity.this.findViewById(msg.arg1)).setImageBitmap((Bitmap) msg.obj);
            }
        }
    };
    private int MIN_MARK = 1;
    private int MAX_MARK = 6;
    private ListView listview;
    static ArrayList<xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity> itemEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.xianlu_main);

        listview = (ListView) findViewById(R.id.xianlu_main_xianlu_listview);

        executorService = Executors.newFixedThreadPool(5);

        listview_download();

        txt_xianlu_home = (TextView) findViewById(R.id.txt_xianlu_home);
        txt_xianlu_back = (TextView) findViewById(R.id.txt_xianlu_back);
        txt_xianlu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_xianlu_home.setSelected(false);
                txt_xianlu_home.setSelected(true);
                finish();
            }
        });
        txt_xianlu_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_xianlu_back.setSelected(false);
                txt_xianlu_back.setSelected(true);
                finish();
            }
        });
    }

    private void listview_download() {
        executorService.submit(new Runnable() {

            @Override
            public void run() {
//                xianlu_oracle.getImageromSdk();
                try {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            itemEntities = new ArrayList<xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity>();

                            final xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity[] entity_oracle = new xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity[MainActivity_slider.xianlu_num];

                            int j=0;
                            for (int i=0;i<xianlu_oracle.getList_result().size();i=i+4)
                            {
                                entity_oracle[j] = new xianlu_identity_pic_selectall_by_gwgxxd_ItemEntity(
                                        xianlu_oracle.getList_result().get(i+3),
                                        xianlu_oracle.getList_result().get(i+1),
                                        xianlu_oracle.getList_result().get(i+2),
                                        xianlu_oracle.getList_result().get(i)
                                );
                                itemEntities.add(entity_oracle[j]);
                                j++;
                            }

                            listview.setAdapter(new xianlu_identity_pic_selectall_by_gwgxxd_ListItemAdapter(xianlu_identity_pic_selectall_by_gwgxxd_activity.this, itemEntities));

//                         listview 点击事件
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                                    view = inflater.inflate(R.layout.xianlupopup, null);

                                    final TextView pop_chehao = (EditText) view.findViewById(R.id.pop_chehao);
                                    final TextView pop_chexiang = (EditText) view.findViewById(R.id.pop_chexiang);

                                    AlertDialog.Builder ad = new AlertDialog.Builder(xianlu_identity_pic_selectall_by_gwgxxd_activity.this);
                                    ad.setView(view);

                                    pop_chexiang.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
                                            System.out.println("-1-beforeTextChanged-->"
                                                    + pop_chexiang.getText().toString() + "<--");
                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
                                            System.out.println("-1-onTextChanged-->"
                                                    + pop_chexiang.getText().toString() + "<--");

                                        }

                                        @Override
                                        public void afterTextChanged(Editable s) {
                                            if (s != null && !s.equals("")) {
                                                if (MIN_MARK != -1 && MAX_MARK != -1) {
                                                    int markVal = 0;
                                                    try {
                                                        markVal = Integer.parseInt(s.toString());
                                                    } catch (NumberFormatException e) {
                                                        markVal = 0;
                                                    }
                                                    if (markVal > MAX_MARK) {
                                                        Toast.makeText(getBaseContext(), "最大值为6_test阿斯顿", Toast.LENGTH_SHORT).show();
                                                        //选择界面！！！！！！！！！！！！
                                                        pop_chexiang.setText(String.valueOf(MAX_MARK));
                                                    }
                                                    if (s.length() > 0) {
                                                        if (MIN_MARK != -1 && MAX_MARK != -1) {
                                                            int num = Integer.parseInt(s.toString());
                                                            if (num > MAX_MARK) {

                                                                pop_chexiang.setText(String.valueOf(MAX_MARK));
                                                            } else if (num < MIN_MARK)
                                                                pop_chexiang.setText(String.valueOf(MIN_MARK));
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                    });

                                    xianluname_str = entity_oracle[position].getTitle();
                                    ad.setTitle("待检查线路："+xianluname_str);
                                    selfdialog = ad.create();
                                    selfdialog.setButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            chehao = pop_chehao.getText().toString();
                                            chexiang = pop_chexiang.getText().toString();
                                            if (chehao.equals("") || chexiang.equals("")) {
                                                showDialog();
                                            } else {
                                                Intent intent = new Intent(xianlu_identity_pic_selectall_by_gwgxxd_activity.this, xianlu_identity_pic_selectall_by_gwgxxd_deal_main_activity.class);
                                                Bundle bundle = new Bundle();
                                                bundle.putString("zaizhuangxianlu", xianluname_str);
                                                bundle.putString("zaizhuangxianlu_num", xianlunum_str);
                                                bundle.putString("chehao", chehao + "0" + chexiang);
                                                bundle.putString("chexiang", chexiang);
                                                if (chexiang.equals("1") || chexiang.equals("6")) {
                                                    bundle.putString("chexing", "tc");
                                                } else if (chexiang.equals("2") || chexiang.equals("5")) {
                                                    bundle.putString("chexing", "mp");
                                                } else if (chexiang.equals("3") || chexiang.equals("4")) {
                                                    bundle.putString("chexing", "m");
                                                }
                                                intent.putExtras(bundle);
                                                startActivity(intent);
                                                dialog.cancel();
                                            }
                                        }
                                    });
                                    selfdialog.setButton2("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            selfdialog.cancel();
                                        }
                                    });
                                    selfdialog.show();
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void showDialog() {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(xianlu_identity_pic_selectall_by_gwgxxd_activity.this);
        builder.setTitle("错误").setIcon(android.R.drawable.stat_notify_error);
        builder.setMessage("请输入车号及车厢！！！");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });
        dialog = builder.create();
        dialog.show();
    }

}

