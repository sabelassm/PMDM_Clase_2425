package com.example.ud01_3_chronos

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ud01_3_chronos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val RUNNING_KEY = "running"
    val OFFSET_KEY = "offset"
    val BASE_KEY = "base"
    lateinit var binding: ActivityMainBinding
    lateinit var chrono: Chronometer
    var running = false
    var offset = 0L

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chrono.base)
        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        chrono = binding.chrTemporizador

        if(savedInstanceState!=null){
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            if(running){
                chrono.base = savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            }else{
                chrono.base = SystemClock.elapsedRealtime()- offset
            }
        }
        //Funcionalidad Botones
        binding.btnStart.setOnClickListener{
            if(!running){
                chrono.base = SystemClock.elapsedRealtime()- offset
                chrono.start()
                running = true
            }
        }
        binding.btnPause.setOnClickListener{
            if(running){
                offset = SystemClock.elapsedRealtime() - chrono.base
                chrono.stop()
                running = false
            }
        }
        binding.btnRestart.setOnClickListener{
            offset=0L
            chrono.base = SystemClock.elapsedRealtime()
        }

    }
 /*
    //Aplicación pasa a segundo plano
    override fun onStop() {
        //Si estaba encendido, lo paro y guardo la variable offset
        if(running){
            offset = SystemClock.elapsedRealtime() - chrono.base
            chrono.stop()
        }
        super.onStop()
    }
    //Aplicación vuelve a primer plano
    override fun onRestart() {
        //Si estaba encendido lo vuelvo a ejecutar
        if(running){
            chrono.base = SystemClock.elapsedRealtime()- offset
            chrono.start()
        }
        super.onRestart()
    }*/

    //Pierde el foco
    override fun onPause() {
        if(running){
            offset = SystemClock.elapsedRealtime() - chrono.base
            chrono.stop()
        }
        super.onPause()
    }
    //Recupera el foco
    override fun onResume() {
        if(running){
            chrono.base = SystemClock.elapsedRealtime()- offset
            chrono.start()
        }
        super.onResume()
    }
}