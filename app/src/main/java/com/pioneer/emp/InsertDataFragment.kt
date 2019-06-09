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
import kotlinx.android.synthetic.main.fragment_insert_data.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InsertDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_insert_data, container, false)
        var helper = DBOpenHelper(activity!!)
        var db = helper.writableDatabase

        v.button_insert.setOnClickListener {
            var cur = db.rawQuery("select * from employees where id=?", arrayOf(v.editText_empnum.text.toString()))
            if (cur.count != 0)
            {
                var act = activity as MainActivity
                act.sendData(v.editText_empnum.text.toString() ,v.editText_name.text.toString(), v.editText_salary.text.toString())
                var obj = UpdateDialogFragment()
                obj.show(activity!!.supportFragmentManager, "PopUpFragment")

            } else {
                db.execSQL(
                    "insert into employees values(?, ?, ?)", arrayOf(
                        v.editText_empnum.text.toString(), v.editText_name.text.toString(),
                        v.editText_salary.text.toString()
                    )
                )
                Toast.makeText(activity, "تم تسجيل بيانات جديدة", Toast.LENGTH_LONG).show()
            }
        }
        return v
    }


}
