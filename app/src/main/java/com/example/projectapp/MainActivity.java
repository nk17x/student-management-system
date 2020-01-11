package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button11,button12;
    EditText editText11,editText12;
    DatabaseHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteDatabase=new DatabaseHelper(this);
        button11=(Button) findViewById(R.id.button11);
        button12=(Button) findViewById(R.id.button12);
        editText11=(EditText) findViewById(R.id.editText11);
        editText12=(EditText) findViewById(R.id.editText12);
        final Intent intent2 =new Intent(this,Main3Activity.class);
        String user=editText11.getText().toString().toLowerCase().trim();
        String pass=editText11.getText().toString().toLowerCase().trim();
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=editText11.getText().toString().toLowerCase().trim();
                String pass=editText11.getText().toString().toLowerCase().trim();
                Boolean res = sqLiteDatabase.checkUser(user, pass);
                if(res == true)
                {

                    startActivity(intent2);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }




            }
        });
        final Intent intent =new Intent(this,Main2Activity.class);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
