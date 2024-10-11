package com.example.ud03_1_fragmentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EncryptFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        val mensaje = EncryptFragmentArgs.fromBundle(requireArguments()).message
        val textoEncriptado = view.findViewById<TextView>(R.id.txtViewMessageEncrypted)
        textoEncriptado.text = cifra(mensaje)
        return view
    }

    fun cifra(msg : String) =
        msg.map {
            if(it.isLetter())
                it.uppercaseChar().code
                    .minus('A'.code).plus(3)
                    .mod(26).plus('A'.code).toChar()
            else
                it
        }.joinToString("")

}