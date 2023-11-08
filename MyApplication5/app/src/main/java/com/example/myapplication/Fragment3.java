package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment3 extends Fragment{   //继承自Fragment类的Fragment3类。在该类中，重写了onCreateView方法用于创建视图
    private RecyclerView recyclerView;
    private List<String> list= new ArrayList<>();
    private Context context;
    private Myadapter myadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.tab3,container,false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.recycleview);

        String[] list1 = {"1", "2", "3"};
        List<String> dataList = Arrays.asList(list1);
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for(int i=0;i<list1.length;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("selected_item",list1[i]);

            items.add(item);
        }




        myadapter = new Myadapter(context, Arrays.asList(list1));
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myadapter);


        return view;

    }


}