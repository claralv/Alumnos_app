package com.example.alumnos_app.Basedatos

import android.app.Application
import androidx.room.Room

class MisAlumnosApp: Application()  {
    companion object {
        lateinit var database: DBAlumnoas
    }

    override fun onCreate() {
        super.onCreate()
        MisAlumnosApp.database = Room.databaseBuilder(this,DBAlumnoas::class.java, "DBAlumnos").build()
    }
}
