package com.example.fit_fresh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class tomato extends AppCompatActivity {
    Button b;
    String back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tomato);
        Intent intent = getIntent();
        back = intent.getStringExtra("back");

        /////////////////////////////////////////
        ////////////전화번호 있음///////////////////////
        ////////////////////////////////////



        final String[] itemNames = {"[충주씨샵]충주농협 대추방울토마토 2kg"
        ,"충주 유기농 대추 방울 토마토 2kg",
        "충주농협 새콤달콤 대추방울토마토 2kg [1개]",
        "유기농인증 받은 충주 방울토마토 2kg"};

        final String[] url = {"https://www.11st.co.kr/products/3465344660",
        "https://shinsegaemall.ssg.com/item/itemView.ssg?itemId=0000008606009",
        "https://www.enuri.com/detail.jsp?modelno=92209749",
        "https://shinsegaemall.ssg.com/item/itemView.ssg?itemId=1000323049412"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_tomato);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });
        b=(Button)findViewById(R.id.default_returnbutton);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(back.equals("results_page")){
                    Intent intent1= new Intent(getApplicationContext(), healthdata_symptom_result.class);
                    startActivity(intent1);
                }
                else{
                    Intent intent1= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent1);
                }
            }
        });
    }
}