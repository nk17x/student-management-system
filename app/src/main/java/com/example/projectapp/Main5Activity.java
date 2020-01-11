package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    DatabaseHelper sqLiteDatabase;
    Button button,button2;
    String subjecta,subjectb,subjectc,subjectd;
    EditText editText,editText2,editText3,editText4,editText5;
    int id;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        sqLiteDatabase=new DatabaseHelper(this);
        button=(Button) findViewById(R.id.button51);
        button2=(Button) findViewById(R.id.button52);
        editText=(EditText) findViewById(R.id.editText51);
        editText2=(EditText) findViewById(R.id.editText52);
        editText3=(EditText) findViewById(R.id.editText53);
        editText4=(EditText) findViewById(R.id.editText54);
        editText5=(EditText) findViewById(R.id.editText55);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subjecta=editText2.getText().toString().trim();
                subjectb=editText3.getText().toString().trim();
                subjectc=editText4.getText().toString().trim();
                subjectd=editText5.getText().toString().trim();
                boolean val=sqLiteDatabase.addMark(subjecta,subjectb,subjectc,subjectd);
                if(val) {
                    editText.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");

                }else {
                    Toast.makeText(Main5Activity.this, "not saved", Toast.LENGTH_SHORT).show();
                }

                }
        });
        final Intent intent=new Intent(this,Main3Activity.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });

    }
}
