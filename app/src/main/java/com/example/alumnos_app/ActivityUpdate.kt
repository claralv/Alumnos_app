package com.example.alumnos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alumnos_app.Basedatos.Alumnos
import com.example.alumnos_app.Basedatos.MisAlumnosApp
import com.example.alumnos_app.databinding.ActivityMainBinding
import com.example.alumnos_app.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityUpdate : ActivityWithMenus() {
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            actualizarcurso(Alumnos(nombre = binding.updateNombre.text.toString(), curso = binding.curso.text.toString()))
        }
    }
    fun actualizarcurso(alumno:Alumnos) {
        CoroutineScope(Dispatchers.IO).launch {
            //la variable n contiene el nombre del alumno introducido en el formulario
            val n = alumno.nombre

            //recoveryAlumno es el registro de la tabla que contiene el nombre introducido en el formulario:
            val recoveryAlumno = MisAlumnosApp.database.alumnosDAO().obteneralumnopornombre(n)

            //Asignamos el nuevo curso introducido para cambiarlo en el registro del alumno:
            recoveryAlumno.curso= binding.curso.text.toString()

            //Actualizamos el registro en la BBDD:
            MisAlumnosApp.database.alumnosDAO().actualizarcurso(recoveryAlumno)
        }
    }

}
