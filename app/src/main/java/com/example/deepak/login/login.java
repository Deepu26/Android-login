package com.example.deepak.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    EditText email,password;
    Button blogin,register;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new sqlite(this);
        db=openHelper.getReadableDatabase();

         email = (EditText) findViewById(R.id.editText);
         password = (EditText) findViewById(R.id.editText5);
         blogin = (Button) findViewById(R.id.button3);
         register = (Button) findViewById(R.id.button4);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent= new Intent(login.this,Register.class);
                login.this.startActivity(registerintent);

            }
        });





        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String mail = email.getText().toString();
                 String pwd = password.getText().toString();
                cursor=db.rawQuery("SELECT * FROM " + sqlite.TABLE_NAME + " WHERE " + sqlite.COL_1 + "=? AND " + sqlite.COL_2 + "=?", new String[]{mail,pwd});
                if (cursor != null)
                {
                    if(cursor.getCount() > 0)
                    {
                        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
                        Intent welcomeintent= new Intent(login.this,welcome.class);
                        login.this.startActivity(welcomeintent);
                    }
                    else
                    {
                      Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
