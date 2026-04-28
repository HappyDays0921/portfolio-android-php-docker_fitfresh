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

public class rice extends AppCompatActivity {
    Button b;
    String back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice);

        Intent intent = getIntent();
        back = intent.getStringExtra("back");
        final String[] itemNames = {"[서충주농협]달래강청정 귀리(1kg)"
        ,"[서충주농협]달래강청정 찰보리(1kg)",
        "[서충주농협]달래강청정 찹쌀(1kg)",
        "[서충주농협]달래강청정 찰현미(1kg)",
        "[서충주농협]달래강청정 서리태(1kg)"};
        final String[] url = {"https://chungjuc.com/product/%EC%84%9C%EC%B6%A9%EC%A3%BC%EB%86%8D%ED%98%91%EB%8B%AC%EB%9E%98%EA%B0%95%EC%B2%AD%EC%A0%95-%EA%B7%80%EB%A6%AC1kg/115/category/213/display/1/",
        "https://chungjuc.com/product/%EC%84%9C%EC%B6%A9%EC%A3%BC%EB%86%8D%ED%98%91%EB%8B%AC%EB%9E%98%EA%B0%95%EC%B2%AD%EC%A0%95-%EC%B0%B0%EB%B3%B4%EB%A6%AC1kg/114/category/213/display/1/",
        "https://chungjuc.com/product/%EC%84%9C%EC%B6%A9%EC%A3%BC%EB%86%8D%ED%98%91%EB%8B%AC%EB%9E%98%EA%B0%95%EC%B2%AD%EC%A0%95-%EC%B0%B9%EC%8C%801kg/111/category/213/display/1/",
        "https://m.chungjuc.com/product/%EB%8B%AC%EB%9E%98%EA%B0%95%EC%B2%AD%EC%A0%95-%EC%B0%B0%ED%98%84%EB%AF%B81kg/112/category/45/display/1/",
        "https://m.chungjuc.com/product/%EC%84%9C%EC%B6%A9%EC%A3%BC%EB%86%8D%ED%98%91%EB%8B%AC%EB%9E%98%EA%B0%95%EC%B2%AD%EC%A0%95-%EC%84%9C%EB%A6%AC%ED%83%9C1kg/116/category/45/display/1/"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_rice);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });


        ///////////////////////////////////////
        //////////전화 번호 있음///////////////////////
        ////////////////////////////////////////////


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