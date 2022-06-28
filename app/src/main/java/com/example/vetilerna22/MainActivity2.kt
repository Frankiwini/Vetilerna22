package com.example.vetilerna22

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main_activity5datos.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        /// le doy funcionalidad al boton 77 para que me lleve a la primera actividad con un intent
        button77.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
        /// Con este boton Inserto los datos en la base de datos usando la clase que ya cree AdminSQLiteOpenHelper
            /// Creo la variable admin y uso el metodo writetableDatabase y almaceno en una variable
            ///llamada bd
            /// creo una variable llamada registro donde se almacenan todos los datos que obtengo con put
            /// inserto los datos en la tabla datosclientes , que no pueden ser negativos
            ///cierro la bd con close
            /// vacio los datos
            /// saco un mensaje con un toast

            val admin= AdminSQLiteOpenHelper( this, "datos clientes",null, 1)
            val bd=admin.writableDatabase
            val registro=ContentValues()
            registro.put("nombre",et10.getText().toString())
            registro.put("apellidos",et11.getText().toString())
            registro.put("mail",et12.getText().toString())
            bd.insert("datosclientes",null,registro)
            bd.close()
            et10.setText("")
            et11.setText("")
            et12.setText("")
            Toast.makeText(this,"SE CARGARON LOS DATOS",Toast.LENGTH_LONG).show()
        }


    }

}
