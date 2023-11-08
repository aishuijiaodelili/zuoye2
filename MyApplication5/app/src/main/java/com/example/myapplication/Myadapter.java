package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {

    Context context1;
    List<String> list1;

    public Myadapter(Context context, List<String> list) {
        context1 = context;
        list1 = list;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item, parent, false);
        Myholder holder = new Myholder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textView.setText(list1.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动discover Activity并传递数据
                Intent intent = new Intent(context1, discover.class);
                //String item = list1.get(position);
                intent.putExtra("selected_item", list1.get(position));  // 使用正确的键来传递数据
                //intent.putExtra("position", item);

                context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
        }
    }
}
