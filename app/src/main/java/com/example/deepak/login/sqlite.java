package com.example.deepak.login;

/**
 * Created by DEEPAK on 13-01-2018.
 */
import android.content.Context;
import android.database.*;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.*;
import android.view.*;


public class sqlite extends SQLiteOpenHelper {
public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeration";
    public static final String COL_1="email";
    public static final String COL_2="password";
    public static final String COL_3="cpassword";
    public sqlite(Context context)
    {
        super(context, DATABASE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(email text,password text,cpassword text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);
    }
}
