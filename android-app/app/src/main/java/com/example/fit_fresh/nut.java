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

import java.util.ArrayList;
import java.util.List;

public class nut extends AppCompatActivity {
    Button b;
    ListView list;
    String back =null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nut);
        Intent intent = getIntent();
        back = intent.getStringExtra("back");

        final String[] itemNames = {"국산 유기농 볶은땅콩 200g","생땅콩 1kg [원산지: 국산 (충청북도 충주시)]"};
        final String[] url = {"https://m.62sem.com/product/%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD-%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD-%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD-200g/470/category/168/display/1/",
                "https://shopping.naver.com/window-products/directfarm/6643491732?NaPm=ct%3Dlt462kgw%7Cci%3D7552d91f827003452856e9407d7b3ed8d1895011%7Ctr%3Dslsl%7Csn%3D5701744%7Chk%3Deceecfe828771a905f3bb8706eba1a5d1d1b374e"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_nut);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });
        ////////////////////////////////////////
        //전화번호도 있음 /////////////////////
        ////////////////////////////////////////
        b=(Button)findViewById(R.id.default_returnbutton);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(back.equals("results_page")){
                    Intent intent1= new Intent(getApplicationContext(), healthdata_symptom_result.class);
                    startActivity(intent1);
                }
                else if(back.equals("nut")){
                    Intent intent1= new Intent(getApplicationContext(), healthdata_nutresult_3.class);
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