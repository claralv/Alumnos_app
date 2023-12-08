package com.example.alumnos_app.Basedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnos")
data class Alumnos(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombre: String = "",
    var apellido: String="",
    var curso: String=""
)