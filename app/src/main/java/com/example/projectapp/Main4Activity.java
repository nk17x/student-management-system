package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    DatabaseHelper sqLiteDatabase;

    Button button,button2;

    EditText editText,editText2,editText3,editText4,editText5,editText6;
    int id;
    String firstname,lastname,dob,phoneno,address;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        sqLiteDatabase=new DatabaseHelper(this);
        button= (Button) findViewById(R.id.button41);
        button2=(Button) findViewById(R.id.button42);
        editText=(EditText) findViewById(R.id.editText41);
        editText2=(EditText) findViewById(R.id.editText42);
        editText3=(EditText) findViewById(R.id.editText43);
        editText4=(EditText) findViewById(R.id.editText44);
        editText5=(EditText) findViewById(R.id.editText45);
        editText6=(EditText) findViewById(R.id.editText46);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname=editText2.getText().toString().trim();
                lastname=editText3.getText().toString().trim();
                dob=editText4.getText().toString().trim();
                phoneno=editText5.getText().toString().trim();
                address=editText6.getText().toString().trim();
                    boolean val = sqLiteDatabase.addStudent(firstname, lastname, dob, phoneno, address);
                    if(val) {
                        editText.setText("");
                        editText2.setText("");
                        editText3.setText("");
                        editText4.setText("");
                        editText5.setText("");
                        editText6.setText("");
                    }else {
                        Toast.makeText(Main4Activity.this, "not saved", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        final Intent intent =new Intent(this,Main3Activity.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });

    }
}
