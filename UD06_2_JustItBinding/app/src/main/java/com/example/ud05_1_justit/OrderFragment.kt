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
import com.example.ud05_1_justit.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {

    var _binding: FragmentOrderBinding? = null
    val binding: FragmentOrderBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentOrderBinding.inflate(inflater, container, false)
            //val view = inflater.inflate(R.layout.fragment_order, container, false)
        val view = binding.root
        val toolbar  =  binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fabSend = binding.fabSend
        fabSend.setOnClickListener {
            val burguerGroup =binding.groupBurguerType
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}