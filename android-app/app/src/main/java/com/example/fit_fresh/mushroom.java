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

public class mushroom extends AppCompatActivity {
    Button b;
    ListView list;
    String back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mushroom);
        Intent intent = getIntent();
        back = intent.getStringExtra("back");

        list = findViewById(R.id.lv_mushroom);
        List<String> data= new ArrayList<>();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        data.add("이주남 (새송이버섯) : 010-5466-2200");
        data.add("신주호 (새송이버섯) : 010-8872-2824");
        data.add("충주 버섯 영농조합 (새송이버섯) : 043)852-2902, 010-5464-2902");
        data.add("리을농산 (표고버섯) : 043)853-6999, 010-5042-0717");
        data.add("최병진 (표고버섯) : 010-8904-7222");
        data.add("나한나 (표고버섯) : 010-8413-3005");
        //////////////////////////////////
        //////////////url 있음//////////////
        ////////////////////////////////////

        data.add("태평농산 권오현 (느타리버섯) : 010-5042-0717");
        data.add("주안농산 (느타리버섯) : 043)853-8665, 010-3327-8668");


        /*final String[] itemNames = {"[동막골]충주 냉동대학찰옥수수(7개입/14개입)", "23년 첫수확 괴산 대학찰옥수수 / 충주 태양찰옥수수", "청년농부의 신품종 찰옥수수 찐 냉동 충주 태양찰옥수수 9개 15개 [원산지:국산(충청북도 충주시)]"};
        final String[] url = {"https://chungjuc.com/product/detail.html?product_no=25&srsltid=AfmBOopijCoPckmryEwvYYKt5yiVsYNFqdthcACyZjugmzwhSCYuqcQzXXY",
                "https://mfruta.shop/product/detail.html?product_no=14&srsltid=AfmBOoqCcu_80hH0yU1ij4irRjfvOx3Me1FgZWgQwCyil9KLhWAGCXidlfA",
                "https://shopping.naver.com/window-products/directfarm/8789651742?NaPm=ct%3Dlros1rm0%7Cci%3D0fc20623de298e1a3ea6945f5e740545263927b5%7Ctr%3Dsls%7Csn%3D4693082%7Chk%3Dca622b1ecfff5749b91df1f26bf1abca926a8749"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_mushroom);
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