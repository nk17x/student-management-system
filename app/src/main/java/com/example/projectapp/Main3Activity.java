package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button button31,button32,button33,button34,button35;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button31=(Button) findViewById(R.id.button31);
        button32=(Button) findViewById(R.id.button32);
        button33=(Button) findViewById(R.id.button33);
        button34=(Button) findViewById(R.id.button34);
        button35=(Button) findViewById(R.id.button35);
        final Intent intent5=new Intent(this,MainActivity.class);
        final Intent intent1=new Intent(this,Main4Activity.class);
        final Intent intent2=new Intent(this,Main5Activity.class);
        final Intent intent3=new Intent(this,Main6Activity.class);
        final Intent intent4=new Intent(this,Main7Activity.class);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(intent5);
            }
        });

    }
}
