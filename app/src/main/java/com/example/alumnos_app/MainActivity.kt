package com.example.alumnos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alumnos_app.Basedatos.Alumnos
import com.example.alumnos_app.Basedatos.MisAlumnosApp
import com.example.alumnos_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnanadir.setOnClickListener {
            //Creamos un objeto Alumnos y llamamos al método para insertarlo en la BBDD
            addAlumno(Alumnos(nombre = binding.nombre.text.toString(), apellido = binding.apellido.text.toString(), curso = binding.curso.text.toString()))
        }
    }
    //Método para añadir un nuevo registro en la tabla
    fun addAlumno(alumno: Alumnos) {
        //Accedemos a la BBDD en segundo plano usando corrutinas
        CoroutineScope(Dispatchers.IO).launch {
            MisAlumnosApp.database.alumnosDAO().addAlumno(alumno)

        }
    }
}
