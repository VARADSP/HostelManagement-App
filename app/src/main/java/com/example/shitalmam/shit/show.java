package com.example.shitalmam.shit;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class show extends AppCompatActivity {
    DataBase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        myDb = new DataBase(this);//create a new instance
    }
    // myDb = new DataBase(this);//create a new instance

    public void view(View view) {
        Cursor res = myDb.getAllData();//res have some property
        if (res.getCount() == 0) {
            //message
            showMessage("Error", "No data to show");
            return;
        } else {
            //create some string buffer
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("\n-----------------------------------------------------\n Name:- " + res.getString(0) + "\n");
                buffer.append("NAME:- " + res.getString(1) + "\n");
                buffer.append("ADDRESS- " + res.getString(2) + "\n");
                buffer.append("PERCENTAGE:- " + res.getString(3) + "\n");
                buffer.append("Mobile:- " + res.getString(4) + "\n");
            }
            //show all data
            showMessage("Todays ADDMISSION", buffer.toString());
        }

    }

    public void showMessage(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);//can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}
