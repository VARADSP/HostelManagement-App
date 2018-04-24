package com.example.shitalmam.shit;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registor extends AppCompatActivity {


    DatabaseHelper db;
    EditText e1,e2,e3,e4;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        e4=(EditText)findViewById(R.id.etname);
        b1=(Button)findViewById(R.id.rgister);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3 =e3.getText().toString();
                String s4 =e4.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext()," fields are empty",Toast.LENGTH_LONG).show();




                }
                else {
                    if(s2.equals(s3)){
                        Boolean chkemail =db.chkemail(s1);
                        if(chkemail==true){
                            Boolean insert=db.insert(s1,s2,s4);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Successfully Registered Login Now",Toast.LENGTH_LONG).show();

                                Intent i=new Intent(Registor.this,Login.class);
                                startActivity(i);

                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"Email already exist",Toast.LENGTH_LONG).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Both Password Must be Same",Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
