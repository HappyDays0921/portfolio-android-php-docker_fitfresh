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

public class apple extends AppCompatActivity {
    Button b;
    String back = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apple);

        //////////////////////////////////
        /////////////전화번호 있음//////////
        //////////////////////////////////
        Intent intent = getIntent();
        back = intent.getStringExtra("back");


        final String[] itemNames = {"충주사과 맛있는 햇 꿀 부사사과 황금 유명한곳 선물용 판매 농원 고당도 껍질째먹는 흠집 4kg 5kg [원산지:국산(충청북도 충주시)]\n",
        "농가살리기 충북 충주 김진원 실속 알뜰사과 2kg (6~11과 내외) [원산지:국산]",
        "못난이사과 10kg 사과10키로 5키로 4키로 사과유명한곳 제철 빨간 과일 [원산지:국산(충청북도 충주시)]",
        "충주사과 꿀부사 5kg10kg15kg선물, 가정용 [원산지:국산(충청북도 충주시)]",
        "충주 사과 햇 부사 유명한곳 선물용 정품 못난이 흠과 5kg 10kg 흠집 [원산지:국산(충청북도 충주시)]",
        "충주 사과 5kg ( 저탄소인증사과 ) [원산지:국산(충청북도 충주시)]",
        "충주사과 호낭골사과 가정용사과 부사 흠과 못난이사과 꿀사과 [원산지:국산(충청북도 충주시)]",
        };
        final String[] url = {"https://smartstore.naver.com/applecj/products/5104458478?n_media=27758&n_query=%EC%B6%A9%EC%A3%BC%EC%82%AC%EA%B3%BC&n_rank=1&n_ad_group=grp-a001-02-000000026819274&n_ad=nad-a001-02-000000180576092&n_campaign_type=2&n_mall_id=ncp_1ntxxf_01&n_mall_pid=5104458478&n_ad_group_type=2&n_match=3",
        "https://smartstore.naver.com/furttown/products/9782889937?n_media=27758&n_query=%EC%B6%A9%EC%A3%BC%EC%82%AC%EA%B3%BC&n_rank=2&n_ad_group=grp-a001-02-000000030158004&n_ad=nad-a001-02-000000285893505&n_campaign_type=2&n_mall_id=ncp_1nyoqu_01&n_mall_pid=9782889937&n_ad_group_type=2&n_match=3",
        "https://smartstore.naver.com/bonghwa3116/products/9155654419?",
        "https://smartstore.naver.com/_daddy/products/9545481069?"
        ,"https://smartstore.naver.com/cjsamgol/products/556937161?",
        "https://smartstore.naver.com/sunappleland/products/4788694503?",
        "https://smartstore.naver.com/nsk0625/products/7258116719?",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_apple);
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