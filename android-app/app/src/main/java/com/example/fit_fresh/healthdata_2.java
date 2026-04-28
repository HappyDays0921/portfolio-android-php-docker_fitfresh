package com.example.fit_fresh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class healthdata_2 extends AppCompatActivity {

    Button b1, next;

    RadioButton bob, fish, noodle, bread, fastfood, soup, egg, boggem, fried, namul, jang, ssam, balhu,
            alchol, snack, guhwang, milk, fruit, coffee, w_1, w_2, w_3;
    RadioButton b,l,d;

    float carbo_f = 0, protein_f = 0, fat_f= 0;


    int age_i;
    float bmi;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_2);

        //나이랑 이름을 받아오기
        SharedPreferences sharedPreferences= getSharedPreferences("INFO",MODE_PRIVATE);
        String name= sharedPreferences.getString("userName","이름이 없어요");
        String age= sharedPreferences.getString("userAge", "나이가 없어요");
        //bmi 받아오기
        Intent intent=getIntent();
        bmi=intent.getFloatExtra("BMI",0.0f);


        b1 = findViewById(R.id.default_returnbutton);
        next=findViewById(R.id.button);
        b=findViewById(R.id.b);
        l=findViewById(R.id.l);
        d=findViewById(R.id.d);

        // 버튼
        bob = findViewById(R.id.bob);
        fish= findViewById(R.id.fish);
        noodle = findViewById(R.id.noodle);
        bread = findViewById(R.id.bread);
        fastfood = findViewById(R.id.fastfood);
        soup = findViewById(R.id.soup);

        egg = findViewById(R.id.egg);
        boggem = findViewById(R.id.boggem);
        fried = findViewById(R.id.fried);
        namul = findViewById(R.id.namul);
        jang = findViewById(R.id.jang);
        ssam = findViewById(R.id.ssam);
        balhu = findViewById(R.id.balhu);

        alchol = findViewById(R.id.alchol);
        snack = findViewById(R.id.snack);
        guhwang = findViewById(R.id.guhwang);
        milk = findViewById(R.id.milk);
        fruit = findViewById(R.id.fruit);
        coffee = findViewById(R.id.coffee);








        //뒤돌아가기 버튼
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplication(),healthdata_main.class);
                startActivity(intent1);
            }
        });

        //다음 버튼 눌렀을 때 동작
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                //시간대 입력 받아 처리 하기
                int meal= getMeal();
                float[] nut = new float[3];
                nut[0] = 0;
                nut[1]= 0;
                nut[2] = 0;
                nut = getSelectedNut(nut);

                //스트링 형으로 모두 바꾸기
                String carbo= Float.toString(nut[0]);
                String protein=Float.toString(nut[1]);
                String fat=Float.toString(nut[2]);
                String time=Integer.toString(meal);


                //과기대 206에서는 로그인 작업이 불가하기때문에 임의로 테스트 key 랑 value값을 정해서 돌리겠습니다
                //여기서 사용되는 key와 value값으로 영양소test와 만성질환 test를 구동시켜보고, 문제가 없다고 판단되거나 혹은
                //어플이 완성되고 정상작동 된다고 판단되면 이 테스트 kev와 value를 수정해주시고 이 주석들도 지워주시길 바라겠습니다
                SharedPreferences sharedPreferences = getSharedPreferences("tstfile",MODE_PRIVATE);
                //test_name
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tst_name","--NAME--");
                //test_age
                editor.putString("tst_age","25");

                editor.commit();

                //JSONObject로 데이터 서버에 전송하기
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try{
                            JSONObject j= new JSONObject(s);

                        }catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                };

                healthdata_2Request hr= new healthdata_2Request(name,time,age, carbo, protein, fat, responseListener);
                RequestQueue queue= Volley.newRequestQueue(healthdata_2.this);
                queue.add(hr);

                Intent intent=new Intent(getApplication(), healthdata_nutresult.class);
                SharedPreferences sharedPreferences1 = getSharedPreferences("meal_user_name",MODE_PRIVATE);
                //test_name
                SharedPreferences.Editor editor2 = sharedPreferences1.edit();
                editor2.putString("name",name);
                editor2.commit();
                intent.putExtra("BMI",bmi);
                intent.putExtra("name",name);
                startActivity(intent);

            }


        });
    }

    //아침, 점심, 저녁 라디오 버튼 선택 시 동작
    protected int getMeal(){
        if(b.isChecked()) return 1;
        else if(l.isChecked()) return 2;
        else return 3;

    }

//각 영양소 계산 리턴값
    public float[] getSelectedNut(float[] nut){
        float[] result = nut;
        if(bob.isChecked()) {
            result[0]+=43.36;
            result[1]+=5.12;
            result[2]+=0.84;
        }
        if(fish.isChecked()){
            result[0]+=0.05;
            result[1]+=11.99;
            result[2]+=5.07;
        }
        if(noodle.isChecked()){
            result[0]+=91.25;
            result[1]+=14.5;
            result[2]+=16.5;
        }
        if(bread.isChecked()){
            result[0]+=19.9;
            result[1]+=3.6;
            result[2]+=7;
        }
        if(fastfood.isChecked()) {
            result[0] += 92.94;
            result[1] += 18.13;
            result[2] += 16.45;
        }
        if(soup.isChecked()) {
            result[0] += 17.55;
            result[1] += 18;
            result[2] += 10.9;
        }

        if(egg.isChecked()) {
            result[0] += 5.84;
            result[1] += 17.59;
            result[2] += 4.8;
        }
        if(boggem.isChecked()){
            result[0]+=4.8;
            result[1]+=14.1;
            result[2]+=15.1;
        }

        if(fried.isChecked()){
            result[0]+=16.51;
            result[1]+=9.34;
            result[2]+=12.81;
        }
        if(namul.isChecked()) {
            result[0]+=3.58;
            result[1]+=4.19;
            result[2]+=2.91;
        }

        if(jang.isChecked()){
            result[0]+=36.62;
            result[1]+=9.09;
            result[2]+=4.48;
        }

        if(ssam.isChecked()){
            result[0]+=3.5;
            result[1]+=2;
            result[2]+=0.5;
        }

        if(balhu.isChecked()) {
            result[0]+=6.5;
            result[1]+=1.42;
            result[2]+=0.2;
        }
        if(alchol.isChecked()){
            result[0]+=1.86;
            result[1]+=0.5;
            result[2]+=0;
        }
        if(snack.isChecked()){
            result[0]+=5.81;
            result[1]+=0.87;
            result[2]+=2.32;
        }
        if(guhwang.isChecked()){
            result[0]+=18.8;
            result[1]+=1.8;
            result[2]+=0.1;
        }
        if(milk.isChecked()){
            result[0]+=4.17;
            result[1]+=4.69;
            result[2]+=5.1;
        }
        if(coffee.isChecked()) {
            result[0]+=40.66;
            result[1]+=4.76;
            result[2]+=20.8;
        }
        if(fruit.isChecked()){
            result[0]+=5;
            result[1]+=0.71;
            result[2]+=20.8;
        }

        return result;
    }



}