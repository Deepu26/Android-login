package com.example.deepak.login;
import java.util.regex.Pattern;
import java.util.regex.*;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import android.widget.*;
import android.database.*;
import android.database.*;





public class Register extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText email,password,cpassword;
    Button bRegister,blogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new sqlite(this);
         email = (EditText) findViewById(R.id.editText2);
         password = (EditText) findViewById(R.id.editText3);
         cpassword = (EditText) findViewById(R.id.editText4);
        bRegister = (Button) findViewById(R.id.button);
         blogin =(Button)findViewById(R.id.button2);






        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String mail = email.getText().toString();
                String pwd = password.getText().toString();
                String cpwd = cpassword.getText().toString();

                if(!isCorrectEmail(mail))
                {
                    email.setError("Invalid email address");

                }

                if(isCorrectEmail(mail) && pwd.equals(cpwd))
                {
                    //db=openHelper.getWritableDatabase();
                    insertdata(mail,pwd,cpwd);
                    Intent logintent= new Intent(Register.this,login.class);
                    Register.this.startActivity(logintent);
                    Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_LONG).show();


                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Password didn't match...",Toast.LENGTH_SHORT).show();
                }

            }

            private void insertdata(String mail, String pwd, String cpwd) {

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(sqlite.COL_1,mail);
                    contentValues.put(sqlite.COL_2,pwd);
                    contentValues.put(sqlite.COL_3,cpwd);
                    long id = db.insert(sqlite.TABLE_NAME,null,contentValues);


            }


            private boolean isCorrectEmail(String mail) {

                    // TODO Auto-generated method stub
                    //return false;
                    Pattern pat= Patterns.EMAIL_ADDRESS;
                    Matcher match=pat.matcher(mail);
                    return match.matches();
                }



        });
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent= new Intent(Register.this,login.class);
                Register.this.startActivity(loginintent);
            }
        });

    }
}
