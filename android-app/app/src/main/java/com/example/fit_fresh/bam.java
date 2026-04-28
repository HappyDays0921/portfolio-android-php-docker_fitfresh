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

public class bam extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bam);
        final String[] itemNames = {"토종 알밤 옥광밤 깐밤 생율 1kg 1.5kg 칼집밤(포르단) 군밤 햇밤 [원산지:국산(충청북도 충주시)]",
        "유기농 충주 햇밤 2kg 이평밤 토종 알밤 단택밤 석추밤 [원산지:국산(충청북도 충주시)]",
        "충주밤굿자두 깐밤 생밤 3kg 5kg [원산지:국산]"};
        final String[] url = {"https://shopping.naver.com/window-products/directfarm/3469106303?NaPm=ct%3Dlt45dn3c%7Cci%3D1bd6b07645b320c6174a2030fc62240307e65e0c%7Ctr%3Dsls%7Csn%3D409664%7Chk%3D119bb4a0ee05ea9e8089c0f7012c8460cfa681f6",
        "https://shopping.naver.com/window-products/directfarm/5958982346?NaPm=ct%3Dlt45mme8%7Cci%3Db07259cddf24ee8b017fd59067f873c81d958f85%7Ctr%3Dsls%7Csn%3D1713787%7Chk%3Dd37b1b6106a6e01a321b1e9cb77e81afda735664"
        ,"https://smartstore.naver.com/goodjadubam/products/7613618704?"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_bam);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });


        ///////////////////////////////
        //////전화번호 있음///////////////
        ///////////////////////////////


        b=(Button)findViewById(R.id.default_returnbutton);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplicationContext(), healthdata_nutresult_3.class);
                startActivity(intent1);
            }
        });
    }
}