package com.pioneer.emp

/*
Created by Eng. Osama AlHurani
 */

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context) : SQLiteOpenHelper(context, "emp.db", null , 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table employees(id integer, name text, salary text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}