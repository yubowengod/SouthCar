package com.example.god.southcar;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_register_update_findinfomation.login.Login;
import com.example.main.Data;
import com.example.main.MyFragment;
import com.example.main.MyFragment1;
import com.example.main.MyFragment2;
import com.example.main.MyFragment3;
import com.example.main.NewContentFragment;
import com.example.oracle.select_spinner_jianceshuoming;
import com.example.oracle.select_spinner_jiancexiangdian_picinfo;
import com.example.oracle.select_spinner_xiangdian;
import com.example.oracle.spinner_gongwei_oracle;
import com.example.oracle.spinner_gongxu_oracle;
import com.example.oracle.xianlu_oracle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity_slider extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //UI Object
    private TextView txt_topbar;
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    //Fragment Object
    private MyFragment fg1;
    private MyFragment1 fg2;
    private MyFragment2 fg3;
    private MyFragment3 fg4;
    private NewContentFragment fg5;


    private FragmentManager fManager;


    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<Data> datas = null;
    private FragmentManager fManager1 = null;
    private long exitTime = 0;

    private TextView nav_header_main_activity_slider_textview_name1;
    private TextView nav_header_main_activity_slider_textview_name2;
    private ExecutorService executorService;
    private List<String> urlList = new ArrayList<String>();
    public static String [] gongwei = null;
    public static String [] [] gongxu = null;
    public static String [] [] [] xiangdian = null;
    public static String [] [] [] jianceshuoming = null;
    public static String [] [] [] picinfo = null;

    public static int xianlu_num;

    private long mExitTime;

    private void ini_spinner(){

        executorService.submit(new Runnable() {
            @Override
            public void run() {

                xianlu_oracle.getImageromSdk();

                xianlu_num = xianlu_oracle.getList_result().size()/4;

                spinner_gongwei_oracle.getImageromSdk();

                gongwei = new String[spinner_gongwei_oracle.getList_result().size()];

                gongxu = new String[spinner_gongwei_oracle.getList_result().size()][];

                xiangdian = new String[spinner_gongwei_oracle.getList_result().size()][][];

                jianceshuoming = new String[spinner_gongwei_oracle.getList_result().size()][][];

                picinfo = new String[spinner_gongwei_oracle.getList_result().size()][][];

                for(int i=0;i<spinner_gongwei_oracle.getList_result().size();i++)
                {
                    gongwei[i]=spinner_gongwei_oracle.getList_result().get(i);

                    spinner_gongxu_oracle.getImageromSdk(gongwei[i]);

                    gongxu[i] = new String[spinner_gongxu_oracle.getList_result().size()];

                    xiangdian[i] = new String[spinner_gongxu_oracle.getList_result().size()][];

                    jianceshuoming[i] = new String[spinner_gongxu_oracle.getList_result().size()][];

                    picinfo[i] = new String[spinner_gongxu_oracle.getList_result().size()][];

                    for (int j = 0;j<spinner_gongxu_oracle.getList_result().size();j++)
                    {
                        gongxu[i][j]=spinner_gongxu_oracle.getList_result().get(j);

                        select_spinner_xiangdian.getImageromSdk(gongwei[i],gongxu[i][j]);

                        select_spinner_jianceshuoming.getImageromSdk(gongwei[i],gongxu[i][j]);

                        select_spinner_jiancexiangdian_picinfo.getImageromSdk(gongwei[i],gongxu[i][j]);

                        xiangdian[i][j] = new String[select_spinner_xiangdian.getList_result().size()];

                        jianceshuoming[i][j] = new String[select_spinner_jianceshuoming.getList_result().size()];

                        picinfo[i][j] = new String[select_spinner_jiancexiangdian_picinfo.getList_result().size()];

                        for (int k = 0;k<select_spinner_xiangdian.getList_result().size();k++)
                        {
                            xiangdian[i][j][k] = select_spinner_xiangdian.getList_result().get(k);

                            jianceshuoming[i][j][k] = select_spinner_jianceshuoming.getList_result().get(k);

                            picinfo[i][j][k] = select_spinner_jiancexiangdian_picinfo.getList_result().get(k);
                        }
                        select_spinner_xiangdian.getList_result().clear();

                        select_spinner_jianceshuoming.getList_result().clear();

                        select_spinner_jiancexiangdian_picinfo.getList_result().clear();
                    }
                    spinner_gongxu_oracle.getList_result().clear();
                }

                int ww = 0;
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_slider);



        executorService = Executors.newFixedThreadPool(5);
        ini_spinner();

        fManager = getFragmentManager();
        bindViews();

        txt_channel.performClick();   //模拟一次点击，既进去后选择第一项

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_slider, menu);

        if (menu != null) {
            try {
                Class clazz = menu.getClass();
                if (clazz.getSimpleName().equals("MenuBuilder")) {
                    Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);

                    //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
                    m.invoke(menu, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
//        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);

                setSelected();
                txt_channel.setSelected(true);
                if(fg1 == null){
                    fg1 = new MyFragment("功能列表");
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }

                fTransaction.commit();
            }
        });
        txt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);

                setSelected();
                txt_message.setSelected(true);
                if(fg2 == null){
                    fg2 = new MyFragment1("通知信息");
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }

                fTransaction.commit();
            }
        });
        txt_better.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);

                setSelected();
                txt_better.setSelected(true);
                if(fg3 == null){
                    fg3 = new MyFragment2("历史列表");
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }

                fTransaction.commit();
            }
        });
        txt_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);

                setSelected();
                txt_setting.setSelected(true);
                if(fg4 == null){
                    fg4 = new MyFragment3("设置");
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }

                fTransaction.commit();
            }
        });
    }

    //重置所有文本的选中状态
    private void setSelected(){
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
        if(fg5 != null)fragmentTransaction.hide(fg5);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
