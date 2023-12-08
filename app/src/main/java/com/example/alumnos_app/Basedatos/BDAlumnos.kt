package com.example.alumnos_app.Basedatos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(Alumnos::class),
    version = 1)
    abstract class DBAlumnoas: RoomDatabase()  {
        abstract fun alumnosDAO(): AlumnosDAO
}

