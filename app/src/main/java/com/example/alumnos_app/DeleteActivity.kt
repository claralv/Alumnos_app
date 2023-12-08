package com.example.alumnos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alumnos_app.Basedatos.Alumnos
import com.example.alumnos_app.Basedatos.MisAlumnosApp
import com.example.alumnos_app.databinding.ActivityDeleteBinding
import com.example.alumnos_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus(){
    lateinit var binding: ActivityDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDelete.setOnClickListener {
            //llamamos al método para eliminar el registro con el nombre del alumno introducido:
            borrarAlumnos(Alumnos(nombre = binding.deleteNombre.text.toString()))
        }

    }

    fun borrarAlumnos(alumno:Alumnos) {
        CoroutineScope(Dispatchers.IO).launch {
            //La variable n contiene el nombre del alumno que hemos introducido en el formulario
            val n = alumno.nombre

            //Recuperamos el registro con el nombre del alumno que hemos introducido en el formulario:
            val recoveryAlumno = MisAlumnosApp.database.alumnosDAO().obteneralumnopornombre(n)

            //Eliminamos el registro de la BBDD:
            MisAlumnosApp.database.alumnosDAO().borrarAlumnos(recoveryAlumno)
        }

    }
}