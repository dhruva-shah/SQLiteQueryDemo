package com.example.indianic1.sqlitedemo;

/**
 * Created by indianic1 on 05/01/16.
 */
public class DBConstants {


    public static final String DATABASE_NAME = "sqlitedemo.db";
    public static final String TABLE_CUSTOMER = "customer";
    public static final String COLUMN_ID = "customer_id";
    public static final String COLUMN_NAME = "customer_name";
    public static final String COLUMN_PHONE = "customer_phone";


    public static final String CREATE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PHONE + " TEXT" + ")";






}
