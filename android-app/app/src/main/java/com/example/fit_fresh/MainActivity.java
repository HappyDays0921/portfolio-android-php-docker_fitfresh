package com.example.fit_fresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fit_fresh.R;

public class MainActivity extends AppCompatActivity {

    Button mushroom_b,tomato_b,apple_b, peach_b,watermelon_b,blueberry_b,rice_b;

    Button login_b;
    Button info_b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info_b=(Button) findViewById(R.id.info_image_button);
        info_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent= new Intent(getApplication(), healthdata_main.class);
                startActivity(intent);
            }
        });

        login_b=(Button) findViewById(R.id.button13);
        login_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplication(), login.class);
                startActivity(intent1);
            }
        });

        //
        //순서대로

        //버섯
        //토마토
        //사과
        //복숭아
        //수박
        //블루베리
        //쌀

        //mushroom
        mushroom_b=(Button) findViewById(R.id.mushroom_image_button);
        mushroom_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),mushroom.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //tomato
        tomato_b=(Button) findViewById(R.id.tomato_image_button);
        tomato_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),tomato.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //apple
        apple_b=(Button) findViewById(R.id.apple_image_button);
        apple_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),apple.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //peach
        peach_b=(Button) findViewById(R.id.peach_image_button);
        peach_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),peach.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //watermelon
        watermelon_b=(Button) findViewById(R.id.watermelon_image_button);
        watermelon_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),watermelon.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //blueberry
        blueberry_b=(Button) findViewById(R.id.blueberry_image_button);
        blueberry_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),blueberry.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });

        //rice
        rice_b=(Button) findViewById(R.id.rice_image_button);
        rice_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),rice.class);
                intent3.putExtra("back","mainActivity");
                startActivity(intent3);
            }
        });



    }
}