package com.example.fit_fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class healthdata_nutresult extends AppCompatActivity {
    private BarChart barChart;

    int bmi =0;
    //사용자 영양소 변수 선언
    float user_carbo = 0;
    float user_protein= 0;
    float user_fat= 0;

    //평균 영양소 변수 선언
    float avg_carbo = 287.90f;
    float avg_protein=84.57f;
    float avg_fat=68.50f;

    TextView tv_1,tv_2,txt1,txt2,txt3;
    Button nxt_btn,rtn_btn;


    String userName,carbo , protein, fat;
    float carbo_minus, protein_minus, fat_minus;
    String name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_nutresult);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);

        Intent intent = getIntent();
       // name = intent.getStringExtra("name");

/////////////////////////////////////
        SharedPreferences sharedPreferences = getSharedPreferences("meal_user_name", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","이름을 받는과정에서 에러 발생");
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String responses) {
                try {
                    //서버의 응답을 JSONOBJECT로 변환한다.
                    JSONObject jasonObject = new JSONObject(responses);
                    //원래는 사용자의 아이디를 입력받아서 데이터베이스와 비교한 이후 데이터를 가져와야 하지만
                    //현재 상황은 sharedreference로
                    //SharedPreferences sharedPreferences = getSharedPreferences("INFO", MODE_PRIVATE);

                    //boolean success
                    boolean success=jasonObject.getBoolean("success");
                    if (success)
                    {
                        //userName = jasonObject.getString("userNames");
                        carbo= jasonObject.getString("carbo");
                        protein=jasonObject.getString("protein");
                        fat= jasonObject.getString("fat");
                        user_carbo = Float.parseFloat(carbo);
                        user_protein = Float.parseFloat(protein);
                        user_fat = Float.parseFloat(fat);


                        //chart
                        barChart = (BarChart) findViewById(R.id.chart);
                        BarData barData = new BarData(); // 차트에 담길 데이터

                        ArrayList<BarEntry> entry_chart = new ArrayList<>();   // 데이터를 담을 Arraylist
                        ArrayList<BarEntry> avg_entry_chart = new ArrayList<>();// 이거는 평균 데이터



                        //사용자 영양소
                        entry_chart.add(new BarEntry(1, user_carbo)); //entry_chart1에 좌표 데이터를 담는다.
                        entry_chart.add(new BarEntry(3, user_protein));
                        entry_chart.add(new BarEntry(5, user_fat));

                        BarDataSet user_meal = new BarDataSet(entry_chart, "user_meal"); // 데이터가 담긴 Arraylist 를 BarDataSet 으로 변환한다.
                        user_meal.setColor(Color.BLUE); // 해당 BarDataSet 색 설정 :: 각 막대 과 관련된 세팅은 여기서 설정한다.
                        //barDataSet.setColor(ColorTemplate.JOYFUL_COLORS);

                        // 해당 BarDataSet 을 적용될 차트에 들어갈 DataSet 에 넣는다.

                        //19-29 평균영양소
                        avg_entry_chart.add(new BarEntry(2,avg_carbo)); //entry_chart1에 좌표 데이터를 담는다.
                        avg_entry_chart.add(new BarEntry(4, avg_protein));
                        avg_entry_chart.add(new BarEntry(6, avg_fat));
                        BarDataSet avg_meal = new BarDataSet(avg_entry_chart, "avg_meal");
                        avg_meal.setColor(Color.RED);

                        barData.addDataSet(user_meal);
                        barData.addDataSet(avg_meal);
                        barChart.setData(barData); // 차트에 위의 DataSet 을 넣는다.
                        barChart.invalidate(); // 차트 업데이트
                        barChart.setTouchEnabled(false); // 차트 터치 불가능하게


                        //

                        //carbo 편차 계산
                        if(avg_carbo-user_carbo==0)
                            txt1.setText(name+"님의 탄수화물 수치는 평균 수치입니다.");
                        else if(avg_carbo-user_carbo>0)
                            txt1.setText(name+"님의 탄수화물 수치는 평균 대비 "+((user_carbo)/(user_carbo+avg_carbo)*100)+"% 더 낮습니다.");
                        else if(avg_carbo-user_carbo<0)
                            txt1.setText(name+ "님의 탄수화물 수치는 평균 대비 "+((user_carbo)/(user_carbo+avg_carbo)*100)+"% 더 높습니다. 줄일 필요가 있어보이네요.");

                        //protein 편차 계산
                        if(avg_protein-user_protein==0)
                            txt2.setText(name+"님의 단백질 수치는 평균 수치입니다.");
                        else if(avg_protein-user_protein>0)
                            txt2.setText(name+"님의 단백질 수치는 평균 대비 "+((user_protein)/(avg_protein+user_protein)*100)+"% 더 낮습니다.");
                        else if(avg_protein-user_protein <0)
                            txt2.setText(name+ "님의 단백질의 수치는 평균 대비 "+((user_protein)/(avg_protein+user_protein)*100)+"% 더 높습니다. 줄일 필요가 있어보이네요.");

                        //fat 편차 계산
                        if(avg_fat-user_fat==0)
                            txt3.setText(name+"님의 지방 수치는 평균 수치입니다.");
                        else if(avg_fat-user_fat>0)
                            txt3.setText(name+"님의 지방 수치는 평균 대비 "+((user_fat)/(avg_fat+user_fat)*100)+"% 더 낮습니다.");
                        else if(avg_fat-user_fat<0)
                            txt3.setText(name+ "님의 지방 수치는 평균 대비 "+((user_fat)/(avg_fat+user_fat)*100)+"% 더 높습니다. 줄일 필요가 있어보이네요.");


                    }else {
                        Toast.makeText(getApplicationContext(),"받아오기 실패", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        userName=name;
        data_output_tst_request data= new data_output_tst_request(userName,responseListener);
        RequestQueue queue= Volley.newRequestQueue(healthdata_nutresult.this);
        queue.add(data);






/////////////////////////////////////
        rtn_btn=(Button) findViewById(R.id.default_returnbutton);
        rtn_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent2= new Intent(getApplication(), healthdata_2.class);
                startActivity(intent2);
            }
        });
        //다음버튼
        nxt_btn=(Button) findViewById(R.id.button);
        nxt_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent2= new Intent(getApplication(), healthdata_nutresult_3.class);
                startActivity(intent2);
            }
        });

    }


}