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

public class meat extends AppCompatActivity {


    Button b;
    private ListView list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat);
        list=findViewById(R.id.lv_meat);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        data.add("장수촌\n충북 충주시 충원대로 56\n전화번호: 043-851-9380");
        data.add("육삼월\n충북 충주시 사천개5길 2\n전화번호: 0507-1396-1230");
        data.add("불구멍\n충북 충주시 사천개로 40 이노스퀘어 1층\n전화번호: 043-846-8778");
        data.add("열혈청춘충북\n충주시 연수상가4길 17-1\n전화번호: 0507-1352-3302");
        data.add("도축장인\n서충주점 충북 충주시 중앙탑면 원앙길 9\n전화번호: 043-851-5131");
        data.add("환연\n충북 충주시 용정8길 6 1층\n전화번호: 0507-1342-3024");

        /*final String[] itemNames = {"[동막골]충주 냉동대학찰옥수수(7개입/14개입)", "23년 첫수확 괴산 대학찰옥수수 / 충주 태양찰옥수수", "청년농부의 신품종 찰옥수수 찐 냉동 충주 태양찰옥수수 9개 15개 [원산지:국산(충청북도 충주시)]"};
        final String[] url = {"https://chungjuc.com/product/detail.html?product_no=25&srsltid=AfmBOopijCoPckmryEwvYYKt5yiVsYNFqdthcACyZjugmzwhSCYuqcQzXXY",
                "https://mfruta.shop/product/detail.html?product_no=14&srsltid=AfmBOoqCcu_80hH0yU1ij4irRjfvOx3Me1FgZWgQwCyil9KLhWAGCXidlfA",
                "https://shopping.naver.com/window-products/directfarm/8789651742?NaPm=ct%3Dlros1rm0%7Cci%3D0fc20623de298e1a3ea6945f5e740545263927b5%7Ctr%3Dsls%7Csn%3D4693082%7Chk%3Dca622b1ecfff5749b91df1f26bf1abca926a8749"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_meat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });*/
        b=(Button)findViewById(R.id.default_returnbutton);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplicationContext(), healthdata_nutresult_3.class);
                startActivity(intent1);
            }
        });
    }
}