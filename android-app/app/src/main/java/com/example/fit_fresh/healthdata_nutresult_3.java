package com.example.fit_fresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class healthdata_nutresult_3 extends AppCompatActivity {

    Button b1,b2,bread, rice, sp, meat, fish, bam, milk, nut, salmon,button;

@SuppressLint("MissingInflatedId")
protected void onCreate(Bundle savedInstance) {
    setContentView(R.layout.healthdata_nutresult_3);
    super.onCreate(savedInstance);

    bread=findViewById(R.id.bread);
    rice=findViewById(R.id.rice);
    sp=findViewById(R.id.sp);
    meat=findViewById(R.id.meat);
    fish=findViewById(R.id.fish);
    bam=findViewById(R.id.bam);
    milk=findViewById(R.id.milk);
    nut=findViewById(R.id.nut);
    salmon=findViewById(R.id.salmon);


    bread.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),bread.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    rice.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),rice.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    sp.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),sweetpotato.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    meat.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),meat.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    fish.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),fish.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    bam.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),bam.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    milk.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),milk.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    nut.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),nut.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });

    salmon.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),salmon.class);
            intent.putExtra("back","nut");
            startActivity(intent);
        }
    });




///////////////////////////////////////


    b1=(Button) findViewById(R.id.button);
    b1.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    });

    b2=(Button) findViewById(R.id.default_returnbutton);
    b2.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            Intent intent= new Intent(getApplicationContext(),healthdata_nutresult.class);
            startActivity(intent);
        }
    });




    }

}
