package com.example.vetilerna22

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //el boton88 lo que hace es cambiar a la actividad principal con un intent
        button88.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//Dentro del boton 13 al hacer click ejecuta el metodo checkPermissions que creo mas abajo
        button13.setOnClickListener {
            checkPermissions()
        }


    }
    //1-COMPRUEBA LO PERMISOS:
    //Creo el metodo checkPermissions que se ejecuta al pulsar el boton13 de la camara, este metodo mira si el usuario
    //ha aceptado alguna vez los permisos , por tanto si no los tiene o nunca los aceptado se los pido con metodo requestCamaraPermissions

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            //si el permiso de la camara del Manifest es distinto del permiso que necesito para aceptar , osea si el permiso de la camara
            // no ha sido aceptado entonces el permiso no es aceptado de momento ya que no lo ha aceptado nunca o es la primera
            //vez que se lo enseñamos

            //creo un metodo mas abajo que se ejecuta aqui llamado requestCameraPermissions para solicitarle el permiso , va a pedirle al usuario que acepte los permisos
            requestCameraPermission()
        }
        // en caso contrario ejecuta seria que ya tiene el permiso y lo que hago es abrir la camara
        else {
            //tiene permiso para abrir la camara
        }
    }

    //2-CREO LA FUNCION PARA PEDIRLE LOS PERMISOS MEDIANTE UNA VENTANA

    private fun requestCameraPermission() {
        //si le mostramos los permisos y el usuario rechaza los permisos no puedo volver otra vez a mostrar el dialogo y tendra que ir a ajustes
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            // el usuario aqui ya le mostre los permisos y los ha rechazado
        } else {
            // en caso contrario el usuario todavia no los ha rechazado , se los pido con ActivityCompat.requestPermissions y el codigo de verificacion que le lanzo es 555
            // el siguiente metodo tiene un listener para comprobar si ese permiso tiene el codigo que le puse 555
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 555)
        }

    }


    //3-CONFIGURO LA ACCION DEL PERMISO , Segun lo que se hizo en la ventana anterior. Para ello
    // sobrescribo el metodo ya creado por el sistema llamado onRequestPermissionsResult y lo uso para lo que yo quiero con sus funcionalidades

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        // si el requestcode es el codigo que le puse
        if (requestCode == 555) {

            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                //si se cumple lo del if , tenemos el permiso de la camara y ha sido aceptado
            } else {
                //en caso contrario el permiso no ha sido aceptado


            }
        }
    }
}
