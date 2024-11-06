package com.example.ud05_1_justit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar  = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fabSend = view.findViewById<FloatingActionButton>(R.id.fabSend)
        fabSend.setOnClickListener {
            val burguerGroup = view.findViewById<RadioGroup>(R.id.group_burguer_type)
            val burguerType = burguerGroup.checkedRadioButtonId
            if (burguerType == -1){
                Toast.makeText(activity, R.string.alert_select_type, Toast.LENGTH_SHORT).show()
            }else{
                var msn = getString(R.string.burguer_selected).plus(view.findViewById<RadioButton>(burguerType).text)
              /*  msn += when(burguerType){
                    R.id.radio_american -> getString(R.string.american)
                    R.id.radio_vegan -> getString(R.string.vegan)
                    R.id.radio_chicken -> getString(R.string.chicken)
                    else -> "Error"
                }*/
                val snackbar = Snackbar.make(fabSend, msn, Snackbar.LENGTH_SHORT)
                    .setAction("Undo"){

                }.show()
            }
        }
        return view
    }

}