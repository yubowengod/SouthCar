package com.example.main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.MyFragment1.MyFragment1_ItemEntity;
import com.example.MyFragment1.MyFragment1_ListItemAdapter;
import com.example.MyFragment1.MyFragment1_broadcast;
import com.example.god.southcar.R;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/21.
 */
public class MyFragment1 extends Fragment {

    private String content;
    public MyFragment1(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content1,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }

    private ListView MyFragment1_listview;

    private ArrayList<MyFragment1_ItemEntity> itemEntities = new ArrayList<MyFragment1_ItemEntity>();

    private Button btn_test_1;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ini();

    }

    public void ini(){
        MyFragment1_listview = (ListView) getActivity().findViewById(R.id.MyFragment1_listview);


        MyFragment1_ItemEntity entity1 = new MyFragment1_ItemEntity(
                "http://192.168.155.1:8011/local_file/a.jpg", "1", "今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错...","2016-9-2");
        itemEntities.add(entity1);

        MyFragment1_ItemEntity entity2 = new MyFragment1_ItemEntity(
                "http://192.168.155.1:8011/local_file/b.jpg", "2", "今天天气不错今天天气不错今天天气不错今天天气不错今 ","2016-4-25");
        itemEntities.add(entity2);

        MyFragment1_ItemEntity entity3 = new MyFragment1_ItemEntity(
                "http://192.168.155.1:8011/local_file/c.png", "3", "今天天气不错今天天气不错今 ///天天气不错今天天气不错今天天气不错...","2016-10-25");
        itemEntities.add(entity3);

        MyFragment1_ItemEntity entity4 = new MyFragment1_ItemEntity(
                "http://192.168.155.1:8011/local_file/d.png", "4", "今天天气不错今天天气不错今天safsafs天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错...","2016-11-25");
        itemEntities.add(entity4);

        MyFragment1_ItemEntity entity5 = new MyFragment1_ItemEntity(
                "http://192.168.155.1:8011/local_file/e.png", "5", "今天天气不错今天天气不错今天天气不错今wwww天天气不错今天天气不错今天天气不错今天天气不错今天天气不错...","2016-12-25");
        itemEntities.add(entity5);



        MyFragment1_listview.setAdapter(new MyFragment1_ListItemAdapter(getActivity(), itemEntities));

        MyFragment1_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(),"点击："+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MyFragment1_broadcast.class);

                Bundle bundle = new Bundle();
                bundle.putString("avatar",itemEntities.get(position).getAvatar());
                bundle.putString("tittle", itemEntities.get(position).getTitle());
                bundle.putString("content", itemEntities.get(position).getContent());
                bundle.putString("date", itemEntities.get(position).getDate());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }
}