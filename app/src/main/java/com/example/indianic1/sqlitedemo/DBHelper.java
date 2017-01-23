package com.example.indianic1.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.indianic1.sqlitedemo.model.CustomerModel;

import java.util.ArrayList;

/**
 * Created by indianic1 on 05/01/16.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase mdb;

    public DBHelper(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DATABASE_VERSION);
        mdb = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstants.CREATE_CUSTOMER);
        mdb = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_CUSTOMER);
    }


    public void close() {
        if (mdb != null) {
            mdb.close();
        }
    }

    public long InsertEmployee(CustomerModel customerModeln) {
        long i = 0;
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConstants.COLUMN_NAME, customerModeln.getName());
            contentValues.put(DBConstants.COLUMN_PHONE, customerModeln.getPhone());
            i = mdb.insert(DBConstants.TABLE_CUSTOMER, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return i;

    }


    public long UpdateEmployee(CustomerModel customerModeln) {
        long i = 0;
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConstants.COLUMN_NAME, customerModeln.getName());
            i = mdb.update(DBConstants.TABLE_CUSTOMER, contentValues, DBConstants.COLUMN_ID + "=?", new String[]{customerModeln.getID()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return i;

    }

    public long deletallSAEmployee(CustomerModel customerModeln) {
        int i = 0;
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        try {
            i = mdb.delete(DBConstants.TABLE_CUSTOMER, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return i;

    }

    public int deleteSingleEmployee(int id) {
        int i = 0;
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        try {
            i = mdb.delete(DBConstants.TABLE_CUSTOMER, DBConstants.COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return i;

    }

    public ArrayList<CustomerModel> getcustomerInfo() {
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        ArrayList<CustomerModel> customerList = null;
        Cursor cursor = null;
        try {
            cursor = mdb.query(DBConstants.TABLE_CUSTOMER, new String[]{"*"}, null, null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                customerList = new ArrayList<>();
                for (int j = 0; j < cursor.getCount(); j++) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.setID(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMN_ID))));
                    customerModel.setName(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_NAME)));
                    customerModel.setPhone(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_PHONE)));
                    cursor.moveToNext();
                    customerList.add(customerModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return customerList;

    }

    public CustomerModel getcustomerInfo(int id) {
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        CustomerModel customerModel = null;
        Cursor cursor = null;
        try {
            cursor = mdb.query(DBConstants.TABLE_CUSTOMER, new String[]{"*"}, DBConstants.COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();


                customerModel = new CustomerModel();
                customerModel.setID(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMN_ID))));
                customerModel.setName(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_NAME)));
                customerModel.setPhone(cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_PHONE)));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return customerModel;

    }

    public String getcustomerName(int id) {
        if (!mdb.isOpen()) {
            mdb = getWritableDatabase();
        }
        String name = "";
        Cursor cursor = null;
        try {
            cursor = mdb.rawQuery("select * from " + DBConstants.TABLE_CUSTOMER + " where " + DBConstants.COLUMN_ID + "=" + id, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                name = cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_NAME));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return name;

    }


}
