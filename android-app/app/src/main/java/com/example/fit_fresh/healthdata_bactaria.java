package com.example.fit_fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class healthdata_bactaria extends AppCompatActivity {
    EditText height, weight;
    TextView bmi;
    Button check;

    Button b;
    Button b1;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_bactaria);

        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        b = (Button) findViewById(R.id.button);
        bmi=findViewById(R.id.tv_bmi);
        check=findViewById(R.id.btn_check);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), healthdata_dang.class);
                startActivity(intent);
            }
        });

        b1= (Button) findViewById(R.id.default_returnbutton);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(), healthdata_main.class);
                startActivity(intent);
            }

        });

        check.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String heightStr= height.getText().toString();
                String weightStr=weight.getText().toString();

                if(heightStr.isEmpty() || weightStr.isEmpty())
                {
                    bmi.setText("키와 몸무게를 입력하세요.");
                    return;
                }
                float height=Float.parseFloat(heightStr);
                float weight= Float.parseFloat(weightStr);

                float BMI = calculateBMI(height, weight);
                bmi.setText("BMI 지수 : "+BMI);
            }
        });



    }
    private float calculateBMI(float height, float weight){
        return weight/((height/100)*(height/100));
    }


}


