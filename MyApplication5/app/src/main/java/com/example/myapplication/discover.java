package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class discover extends AppCompatActivity {
    TextView textview2;
    Button button1;
    String selected_item ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_detail);
        button1=findViewById(R.id.button10);
        Intent intent = getIntent();
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item, null);


        LinearLayout containerLayout = findViewById(R.id.discover_detail);
        containerLayout.addView(itemView);

        int position = intent.getIntExtra("position", 0);
        textview2 = findViewById(R.id.textView10);

        textview2.setText("这里是"+intent.getStringExtra("selected_item"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(discover.this,MainActivity.class);
                intent.putExtra("FRAGMENT_TO_SHOW", 3);
                discover.this.startActivity(intent);
            }
        });

        Log.d("Discover", "Discover Activity created");
    }
}

