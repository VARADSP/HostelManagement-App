package com.example.shitalmam.shit;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

        DataBase myDb;//create an instance
        EditText Name,Docname,nox,Email,mobi;
        Button Insert;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            myDb = new DataBase(this);//create a new instance
            Name = (EditText) findViewById(R.id.Name);
            Docname = (EditText) findViewById(R.id.Docname);
            nox = (EditText) findViewById(R.id.nox);
            Email = (EditText) findViewById(R.id.Email);
            mobi = (EditText) findViewById(R.id.mobi);
            Insert = (Button) findViewById(R.id.Submit);
            Insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean result= myDb.inserdata(Name.getText().toString(),Docname.getText().toString(),nox.getText().toString(),Email.getText().toString(),mobi.getText().toString());
                    if(result)
                        Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_LONG).show();

                    else
                        Toast.makeText(getApplicationContext(),"data not inserted",Toast.LENGTH_LONG).show();


                }
            });}



       public void view(View view)
        {
            Cursor res=myDb.getAllData();//res have some property
            if(res.getCount()==0)
            {
                //message
                showMessage("Error","No data to show");
                return;
            }
            else
            {
                //create some string buffer
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("\n-----------------------------------------------------\n Name:- "+res.getString(0)+"\n");
                    buffer.append("Document Name:- "+res.getString(1)+"\n");
                    buffer.append("No Of Xerox:- "+res.getString(2)+"\n");
                    buffer.append("Email:- "+res.getString(3)+"\n");
                    buffer.append("Mobile:- "+res.getString(4)+"\n");
                }
                //show all data
                showMessage("Todays Order",buffer.toString());
            }

        }
    public void showMessage(String title, String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);//can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }



}
