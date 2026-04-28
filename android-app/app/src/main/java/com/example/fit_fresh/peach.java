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

public class peach extends AppCompatActivity {
    Button b;
    String back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peach);
        Intent intent = getIntent();
        back = intent.getStringExtra("back");



        final String[] itemNames = {"충주 복숭아 천도 백도 복숭아 풍부한 맛과향 식감 좋은 신선 달콤한 복숭아 3kg [원산지:국산(충청북도 충주시)]", "충주 황금알 복숭아 엘바트 양홍장 황도 3kg 2.5kg"};
        final String[] url = {"https://smartstore.naver.com/applecj/products/5008620955?","https://www.coupang.com/vp/products/7603097291?itemId=20117613635&vendorItemId=85953040881&src=1032001&spec=10305199&addtag=400&ctag=7603097291&lptag=I20117613635&itime=20240227184520&pageType=PRODUCT&pageValue=7603097291&wPcid=16846776019806753660430&wRef=cr.shopping.naver.com&wTime=20240227184520&redirect=landing&mcid=50efb88f820545b8b2474456d56f77f7&isAddedCart=",

                };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_peach);
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