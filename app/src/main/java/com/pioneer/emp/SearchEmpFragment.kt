package com.pioneer.emp

/*
Created by Eng. Osama AlHurani
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_search_emp.*
import kotlinx.android.synthetic.main.fragment_search_emp.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchEmpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_search_emp, container, false)
        v.button_search.setOnClickListener {
            var helper = DBOpenHelper(activity!!)
            var db = helper.readableDatabase
            var cur =
                db.rawQuery("select * from employees where id=?", arrayOf(v.editText_empnum_search.text.toString()))
            if (cur.count > 0) {
                cur.moveToFirst()
                v.textView_name_search.text = cur.getString(1)
                v.textView_salary_search.text = cur.getString(2)
            } else {
                v.textView_name_search.text = ""
                v.textView_salary_search.text = ""
                Toast.makeText(activity, "لا يوجد معلومات عن الموظف", Toast.LENGTH_LONG).show()
            }
        }
        return v
    }


}
