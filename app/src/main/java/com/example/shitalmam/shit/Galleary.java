package com.example.shitalmam.shit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Galleary extends AppCompatActivity {

ImageView i;
ImageButton i1;
ImageButton i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_galleary);

        i=(ImageView)findViewById(R.id.g2);
        i1=(ImageButton)findViewById(R.id.imageButton3);
        i2=(ImageButton)findViewById(R.id.imageButton4);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(Galleary.this,viprom.class);
                startActivity(intent);

            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Galleary.this,general1.class);
                startActivity(intent);
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Galleary.this,studyroom.class);
                startActivity(intent);
                startActivity(intent);
            }
        });
    }


}

