package com.example.ud03_1_fragmentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val btnStart = view.findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener{
            view.findNavController().navigate(R.id.action_welcomeFragment_to_messageFragment)
        }
        return view
    }

}