package com.example.fit_fresh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class healthdata_main extends AppCompatActivity {
    Button b;
    Button b1;

    Button b2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthdata_main);

        b = (Button) findViewById(R.id.btn_nut);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), healthdata_2.class);
                startActivity(intent);
            }
        });

        b1 = (Button) findViewById(R.id.btn_bac);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), healthdata_bactaria.class);
                startActivity(intent);
            }

        });

        b2=(Button) findViewById(R.id.default_returnbutton);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
