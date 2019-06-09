package com.pioneer.emp

/*
Created by Eng. Osama AlHurani
 */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    var empid = ""
    var empname = ""
    var empsalary = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tr = supportFragmentManager.beginTransaction()
        var obj = SearchEmpFragment()
        tr.replace(R.id.main_container, obj)
        tr.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.insert_item)
        {
            var tr = supportFragmentManager.beginTransaction()
            var obj = InsertDataFragment()
            tr.replace(R.id.main_container, obj)
            tr.commit()
        }

        if (item?.itemId == R.id.search_item)
        {
            var tr = supportFragmentManager.beginTransaction()
            var obj = SearchEmpFragment()
            tr.replace(R.id.main_container, obj)
            tr.commit()
        }
        return super.onOptionsItemSelected(item)
    }

    fun sendData(id: String, name: String, salary: String) {
        empid = id
        empname = name
        empsalary = salary
    }

    fun updateEmpData(){
        var helper = DBOpenHelper(this)
        var db = helper.writableDatabase
        db.execSQL("update employees set name=?, salary=? where id=?", arrayOf(empname, empsalary, empid))
    }
}
