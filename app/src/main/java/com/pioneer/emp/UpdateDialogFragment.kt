package com.pioneer.emp

/*
Created by Eng. Osama AlHurani
 */

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_insert_data.*
import kotlinx.android.synthetic.main.fragment_insert_data.view.*
import kotlinx.android.synthetic.main.fragment_update_dialog.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_update_dialog, container, false)
        var helper = DBOpenHelper(activity!!)
        var db = helper.writableDatabase
        v.button_no_update.setOnClickListener {
            dismiss()
        }

        v.button_yes_update.setOnClickListener {
            var act = activity as MainActivity
            act.updateEmpData()
            dismiss()
            Toast.makeText(activity, "تم تحديث بياناته", Toast.LENGTH_LONG).show()

        }

        return v
    }


}
