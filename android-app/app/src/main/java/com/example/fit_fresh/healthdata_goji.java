package com.example.fit_fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class healthdata_goji extends AppCompatActivity {
    Button return_b;
    Button next;
    RadioButton b1,b2,b3,b4,b5,b6,b7,b8;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_goji);

        return_b = findViewById(R.id.default_returnbutton);
        next = findViewById(R.id.button);

        return_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), healthdata_dang.class);
                startActivity(intent);
            }

        });


        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculatePercentage();

            }


        });
    }
    public void calculatePercentage() {
        SharedPreferences sharedPreferences= getSharedPreferences("Myprefs",MODE_PRIVATE);
        //int goji_percentage= sharedPreferences.getInt("goji_percentage",0);
        int total=8;
        int check=0;

        if(b1.isChecked()) check++;
        if(b2.isChecked()) check++;
        if(b3.isChecked()) check++;
        if(b4.isChecked()) check++;
        if(b5.isChecked()) check++;
        if(b6.isChecked()) check++;
        if(b7.isChecked()) check++;
        if(b8.isChecked()) check++;


        if(total>0){
            int percentage=(check*100)/total;
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putInt("goji_percentage",percentage);
            editor.apply();

            //다음 페이지 이동
            Intent intent=new Intent(healthdata_goji.this, healthdata_highblood.class);
            startActivity(intent);
        }

    }

}
