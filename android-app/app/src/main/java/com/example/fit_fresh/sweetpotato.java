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

public class sweetpotato extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweetpotato);
        final String[] itemNames = {"[구룡농원]100% 유기농 꿀 고구마(5kg)",
        "달콤한 천등산 꿀고구마 10kg 혼합 충주 산척 [원산지:국산(충청북도 충주시)]",
        "충주 고구마한박스 베니하루까 5kg 개당 100~180g 햇고구마"};
        final String[] url = {"https://chungjuc.com/product/%EA%B5%AC%EB%A3%A1%EB%86%8D%EC%9B%90100-%EC%9C%A0%EA%B8%B0%EB%86%8D-%EA%BF%80-%EA%B3%A0%EA%B5%AC%EB%A7%885kg/190/category/53/display/1/",
        "https://smartstore.naver.com/manysa1/products/9882252803?n_media=27758&n_query=%EC%B6%A9%EC%A3%BC%EA%B3%A0%EA%B5%AC%EB%A7%88&n_rank=1&n_ad_group=grp-a001-02-000000036552246&n_ad=nad-a001-02-000000284516641&n_campaign_type=2&n_mall_id=ncp_1og8ka_01&n_mall_pid=9882252803&n_ad_group_type=2&n_match=3",
        "https://item.gmarket.co.kr/Item?goodscode=2693873719&GoodsSale=Y&jaehuid=200001169&NaPm=ct%3Dlt47ie7k%7Cci%3D3bb8b983d735d25e4039179f475f6c1a52e7c843%7Ctr%3Dsls%7Csn%3D24%7Chk%3D20eb18135d132dfc743cacd36cdf650837758bd8"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_sweetpotato);
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
                Intent intent1= new Intent(getApplicationContext(), healthdata_nutresult_3.class);
                startActivity(intent1);
            }
        });
    }
}