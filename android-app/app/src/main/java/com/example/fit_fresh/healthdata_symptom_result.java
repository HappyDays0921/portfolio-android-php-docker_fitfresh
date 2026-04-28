package com.example.fit_fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;
public class healthdata_symptom_result extends AppCompatActivity {
    PieChart pieChart;
    public int copd_percent;
    public int dang_percent;
    public int goji_percent;
    public int highblood_percent;
    public int simhyal_percent;

    TextView tv_1, tv_2, tv_bac, reason_a, reason_b, reason_c, tv_food;
    Button btn,b2,suggest1,suggest2,suggest3;
    Button btn_1,btn_2,btn_3;

    //추천음식 구분하기 위해 변수 지정
    String identify_suggest = null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_symptom_result);

        //각 id findView 이용하여 부여하기
        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_bac=findViewById(R.id.tv_bac);
        reason_a=findViewById(R.id.reason_a);
        reason_b=findViewById(R.id.reason_b);
        reason_c=findViewById(R.id.reason_c);
        tv_food=findViewById(R.id.tv_food);
        //btn=findViewById(R.id.btn);


        //SharePreferences 이용하여 값 전달받기
        SharedPreferences sharedPreferences = getSharedPreferences("Myprefs", MODE_PRIVATE);
        int dang_percentage = sharedPreferences.getInt("dang_percentage", 0);
        int goji_percentage=sharedPreferences.getInt("goji_percentage",0);
        int highblood_percentage= sharedPreferences.getInt("highblood_percentage",0);
        int copd_percentage=sharedPreferences.getInt("copd_percentage",0);
        int simhyal_percentage=sharedPreferences.getInt("simhyal_percentage",0);

        //SharedPreferences로 name 받아오기
        SharedPreferences sharedPreferences1= getSharedPreferences("INFO",MODE_PRIVATE);
        String name= sharedPreferences1.getString("userName","0");



        int max=Math.max(dang_percentage,Math.max(goji_percentage,Math.max(highblood_percentage,Math.max(copd_percentage,simhyal_percentage))));
        //textView 변환하기

        float sum = dang_percentage+goji_percentage+highblood_percentage+copd_percentage+simhyal_percentage;

        if(max==dang_percentage){
            tv_1.setText(name+"님은 당뇨병 점수가 가장 높네요.");
            tv_2.setText(name+"님이 속한 질병은 전체 대비 "+Math.round(((dang_percentage/sum)*100*100)/100.0)+"% 정도에요!");
            tv_bac.setText("당뇨병의 원인입니다.");
            reason_a.setText("-운동량 부족");
            reason_b.setText("-약물(스테로이드제제, 면역억제제, 이뇨제) 복용");
            reason_c.setText("-노화, 스트레스, 과식, 비만, 유전 등");
            tv_food.setText("당뇨병 예방에 좋은 음식은?");
            identify_suggest = "dang";

        }
        else if(max==goji_percentage){
            tv_1.setText(name+"님은 고지혈증 점수가 가장 높네요.");
            tv_2.setText(name+"님이 속한 질병은 전체 대비 "+Math.round(((goji_percentage/sum)*100*100)/100.0)+"% 정도에요!");
            tv_bac.setText("고지혈증의 원인입니다.");
            reason_a.setText("-유전적 요인");
            reason_b.setText("-비만, 잦은 음주,야식/폭식, 과로, 운동 부족");
            reason_c.setText("-당뇨병");
            tv_food.setText("고지혈증 예방에 좋은 음식은?");
            identify_suggest = "goji";

        }
        else if(max==highblood_percentage){
            tv_1.setText(name+"님은 고혈압 점수가 가장 높네요.");
            tv_2.setText(name+"님이 속한 질병은 전체 대비 "+Math.round(((highblood_percentage/sum)*100*100)/100.0)+"% 정도에요!");
            tv_bac.setText("고혈압의 원인입니다.");
            reason_a.setText("-유전, 음주, 흡연, 고령");
            reason_b.setText("-운동 부족, 짜게 먹는 식습관, 스트레스");
            reason_c.setText("-약물 요인(경구 피임약, 제산제, 항염제, 식욕억제제) 복용");
            tv_food.setText("고혈압 예방에 좋은 음식은?");
            identify_suggest = "highblood";
        }
        else if (max==copd_percentage){
            tv_1.setText(name+"님은 만성 폐쇄성 폐질환 점수가 가장 높네요.");
            tv_2.setText(name+"님이 속한 질병은 전체 대비 "+Math.round(((copd_percentage/sum)*100*100)/100.0)+"% 정도에요!");
            tv_bac.setText("만성 폐쇄성 폐질환의 원인입니다.");
            reason_a.setText("-흡연, 유해물질 노출(유기물, 무기물, 화학물질, 가스, 매연 등)");
            reason_b.setText("-환기가 되지 않는 주거지에서 조리완 난방으로 사용하는 유기물 에너지의 연소로 인한 실내 공기 오염");
            reason_c.setText("-비만, 나트륨, 설탕 및 지방이 많은 식단, 약물의 남용, 알코올 남용, 자간전종또는 독소 혈증");
            tv_food.setText("만성 폐쇄성 폐질환 예방에 좋은 음식은?");
            identify_suggest = "copd";
        }
        else if(max==simhyal_percentage){
            tv_1.setText(name+"님은 심혈관질환 점수가 가장 높네요.");
            tv_2.setText(name+"님이 속한 질병은 전체 대비 "+Math.round(((simhyal_percentage/sum)*100*100)/100.0)+"% 정도에요!");
            tv_bac.setText("심혈관질환의 원인입니다.");
            reason_a.setText("-고혈압, 높은 콜레스테롤, 담배사용");
            reason_b.setText("-당뇨병, 가족력, 심장병, 신체 활동 부족");
            reason_c.setText("-노화, 스트레스, 과식, 비만, 유전 등");
            tv_food.setText("심혈관질환 예방에 좋은 음식은?");
            identify_suggest = "simhyal";
        }

        //pieChart 만들기
        pieChart = (PieChart)findViewById(R.id.pie_chart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        //이거 풀면 흰색 작은 원 추가
        //pieChart.setHoleRadius(40);
        pieChart.setTransparentCircleRadius(40);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
        //여기에 값 집어넣으면 됨
        //copd
        copd_percent= copd_percentage;
        //dang
        dang_percent= dang_percentage;
        //goji
        goji_percent=goji_percentage;
        //highblood
        highblood_percent=highblood_percentage;
        //simhyal
        simhyal_percent=simhyal_percentage;
        yValues.add(new PieEntry(copd_percent,"copd"));
        yValues.add(new PieEntry(dang_percent,"dang"));
        yValues.add(new PieEntry(goji_percent,"goji"));
        yValues.add(new PieEntry(highblood_percent,"highblood"));
        yValues.add(new PieEntry(simhyal_percent,"simhyal"));

        //
        Description description = new Description();
        description.setText("");
        description.setTextSize(15);
        pieChart.setCenterText("만성질환");
        pieChart.setCenterTextSize(15);
        pieChart.setEntryLabelColor(Color.BLACK);

        pieChart.setDescription(description);
        pieChart.animateY(3000, Easing.EaseInOutQuad);
        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSelectionShift(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);

    //메인페이지
        b2=(Button) findViewById(R.id.retun_to_main);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //추천음식1
        suggest1 = (Button) findViewById(R.id.suggest1);
        suggest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(identify_suggest == "copd"){
                    Intent intent = new Intent(getApplicationContext(),watermelon.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "dang"){
                    Intent intent = new Intent(getApplicationContext(),watermelon.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest =="simhyal"){
                    Intent intent = new Intent(getApplicationContext(),watermelon.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "goji"){
                    Intent intent = new Intent(getApplicationContext(),nut.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),blueberry.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
            }
        });
        //추천음식2
        suggest2 = (Button) findViewById(R.id.suggest2);
        suggest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(identify_suggest == "copd"){
                    Intent intent = new Intent(getApplicationContext(),peach.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "dang"){
                    Intent intent = new Intent(getApplicationContext(),bam.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest =="simhyal"){
                    Intent intent = new Intent(getApplicationContext(),nut.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "goji"){
                    Intent intent = new Intent(getApplicationContext(),blueberry.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),tomato.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }

            }
        });

        //추천음식3
        suggest3 = (Button) findViewById(R.id.suggest3);
        suggest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(identify_suggest == "copd"){
                    Intent intent = new Intent(getApplicationContext(),blueberry.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "dang"){
                    Intent intent = new Intent(getApplicationContext(),blueberry.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest =="simhyal"){
                    Intent intent = new Intent(getApplicationContext(),bam.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else if(identify_suggest == "goji"){
                    Intent intent = new Intent(getApplicationContext(),apple.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),apple.class);
                    intent.putExtra("back","results_page");
                    startActivity(intent);
                }

            }
        });





    }

}
