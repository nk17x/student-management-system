package com.example.projectapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";
    public static final String TABLE_NAME2 ="studentdetails";
    public static final String TABLE_NAME3 ="markdetails";
    public static final String COL_21 ="id";
    public static final String COL_22 ="firstname";
    public static final String COL_23 ="lastname";
    public static final String COL_24 ="dob";
    public static final String COL_25 ="phoneno";
    public static final String COL_26 ="address";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE studentdetails (ID INTEGER PRIMARY  KEY AUTOINCREMENT,firstname TEXT,lastname TEXT,dob TEXT,phoneno TEXT,address TEXT )");
        sqLiteDatabase.execSQL("CREATE TABLE markdetails (ID INTEGER PRIMARY  KEY AUTOINCREMENT,subject1 TEXT,subject2 TEXT,subject3 TEXT,subject4 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME3);

        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = sqLiteDatabase.insert("registeruser",null,contentValues);
        sqLiteDatabase.close();
        return  res;
    }
    public boolean addStudent( String firstname, String lastname,String dob,String phoneno,String address ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("dob",dob);
        contentValues.put("phoneno",phoneno);
        contentValues.put("address",address);
        long res = sqLiteDatabase.insert(TABLE_NAME2,null,contentValues);
        sqLiteDatabase.close();
        if(res==-1)
        {
            return false;
        }
        return true;
    }

    public boolean addMark(String subjecta,String subjectb,String subjectc,String subjectd){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject1",subjecta);
        contentValues.put("subject2",subjectb);
        contentValues.put("subject3",subjectc);
        contentValues.put("subject4",subjectd);
        long res = sqLiteDatabase.insert(TABLE_NAME3,null,contentValues);
        sqLiteDatabase.close();
        if(res==-1)
        {
            return false;
        }
        return true;
    }

    public Cursor showData1()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME2;
        Cursor res = sqLiteDatabase.rawQuery(query,null);
        return res;
    }
    public Cursor showData2()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME3;
        Cursor res = sqLiteDatabase.rawQuery(query,null);
        return res;
    }



    public boolean checkUser(String user, String pass){
        String[] columns = { COL_1 };
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { user, pass };
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();



        if(count>0)
            return  true;
        else
            return  false;
    }}