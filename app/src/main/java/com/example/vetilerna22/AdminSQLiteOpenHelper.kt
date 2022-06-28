package com.example.vetilerna22

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


///creo la clase AdminSQLiteOpenHelper que usare para mi base de datos en SQLite
class AdminSQLiteOpenHelper(context:Context,name:String,factory:SQLiteDatabase.CursorFactory?,version: Int): SQLiteOpenHelper(context,name,factory,version)

{
    /// sobrescribo el método onCreate y creo la estructura de mi base de datos . Con una tabla que se va a llamar
    ///datosclientes con una primary key nombre
    override fun onCreate( db:SQLiteDatabase){
    db.execSQL("create table datosclientes (nombre int primary key, apellidos text ,mail real )")
    }
    /// sobrescribo el metodo OnUpgrade que sirve para actualizar los datos pero no voy a usarlo solo quiero
    /// que se actualice la versión
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,newVersion:Int) {

    }
}