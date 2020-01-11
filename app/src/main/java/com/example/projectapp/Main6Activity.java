package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    Button button1,button2;
    TextView textView;
    DatabaseHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        sqLiteDatabase=new DatabaseHelper(this);
        button1=(Button) findViewById(R.id.button61);
        button2=(Button) findViewById(R.id.button62);
        textView=(TextView) findViewById(R.id.textView62);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = sqLiteDatabase.showData1();
                String data = c.getColumnName(0) + "\t\t" + c.getColumnName(1)+ "\t\t" + c.getColumnName(2)+  "\t\t" + c.getColumnName(4)+ "\t\t" + c.getColumnName(5) + "\n";
                while (c.moveToNext()) {
                    data = data + c.getString(0) + "\t\t" + c.getString(1)+ "\t\t" + c.getString(3)+ "\t\t" + c.getString(4)+ "\t\t" + c.getString(5) + "\n";
                }
                textView.setText(data);
            }
        });
        final Intent intent = new Intent(this,Main3Activity.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }
}
