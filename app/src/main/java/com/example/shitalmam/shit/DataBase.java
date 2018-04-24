package com.example.shitalmam.shit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_Name="Stud.db";
    public static final String TABLE_NAME="StudentDetails";
    public static final String COL_1="Name";
    public static final String COL_2="Docname";
    public static final String COL_3="nox";
    public static final String COL_4="Email";
    public static final String COL_5="mobi";

    public DataBase(Context context) {
        super(context, DATABASE_Name,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (Name TEXT,Docname TEXT,nox TEXT,Email TEXT,mobi TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean inserdata(String Name, String Docname, String nox, String Email, String mobi)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,Name);
        contentValues.put(COL_2,Docname);
        contentValues.put(COL_3,nox);
        contentValues.put(COL_4,Email);
        contentValues.put(COL_5,mobi);

        long result= db.insert(TABLE_NAME,null,contentValues);//this method will return rows affected
        //if no rows affected it will return -1
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData()//cursor class provied random read write
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


}
