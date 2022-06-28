package com.example.vetilerna22

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(this, R.raw.pista2)
        var posicion = 0
    //El boton 7 al pulsarlo se escucha la cancion
        button7.setOnClickListener {
            mp.start()

        }
    // al pulsar el boton 8 se pausa si esta previamente sonando
        button8.setOnClickListener {
            if (mp.isPlaying()) {
                posicion = mp.getCurrentPosition()
                mp.pause()
            }
        }
    // al pulsar el boton 9 si antes no esta sonando lo que hace es sonar
        button9.setOnClickListener {
            if (mp.isPlaying() == false) {
                mp.seekTo(posicion)
                mp.start()
            }
        }
    // al pulsar el boton 10 se para
        button10.setOnClickListener {
            mp.pause()
            posicion = 0
            mp.seekTo(0)
        }
    // con boton 18 sale un mensaje que dice que accede a bbdd con un toast  y luego se va a la actividad 2 con un
    // intent
        button18.setOnClickListener {

            Toast.makeText( this, "ACCEDIENDO A BASE DE DATOS",Toast.LENGTH_LONG).show()

            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    // con boton 19  entra en activity 3 y lo muestra con un toast
        button19.setOnClickListener {

            Toast.makeText( this, "ENTRANDO EN ACTIVITY 3",Toast.LENGTH_LONG).show()
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }

    // el boton20 cambia a actividad4 con un intent
        button20.setOnClickListener {
            val intent= Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }

    }







    }