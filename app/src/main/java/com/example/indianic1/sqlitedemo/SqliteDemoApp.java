package com.example.indianic1.sqlitedemo;

import android.app.Application;

/**
 * Created by indianic1 on 05/01/16.
 */
public class SqliteDemoApp extends Application {


    private DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DBHelper(this);
    }



    public DBHelper getDbHelper(){
        return dbHelper;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        if(dbHelper!=null){
            dbHelper.close();
        }
    }
}
