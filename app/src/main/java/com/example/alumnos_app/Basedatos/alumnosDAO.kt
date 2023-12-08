package com.example.alumnos_app.Basedatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.*
@Dao
interface AlumnosDAO {
    @Query("SELECT * FROM alumnos")
    fun getAllAlumnos(): MutableList<Alumnos>

    @Insert
    fun addAlumno(alumno: Alumnos)

    @Query("SELECT * FROM alumnos WHERE nombre like :nombre")
    fun obteneralumnopornombre(nombre:String): Alumnos  //devuelve un alumno (registro) de la tabla

    @Update
    fun actualizarcurso(alumno:Alumnos)

    @Delete
    fun borrarAlumnos(alumno: Alumnos)
}