package com.example.testingapp.views

import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones
import kotlin.math.roundToInt

class Dialog {
    private var listener : Operaciones? = null
    private var accion : Int = 0;

    //carga del listener para el botón
    fun setListener(_listener : Operaciones) {
        listener = _listener
    }

    //Lo que muestra el dialogo
    fun show(numberAction : Int){
        listener?.let {
            val posibleName = "No se, solo son pruebas"
            val posibleID = (Math.random() + 99).roundToInt()
            when(numberAction){
                0 -> addClient()
                1 -> onDelete(posibleID)
                2 -> onEdit(posibleID,posibleName)
            }

        }
    }

    private fun addClient(
        id: Int = 100,
        nombre: String = "Ni idea",
        apellido: String = "Obra maestra",
        telefono: String = "cccccccccc"
    ) {
        listener!!.clientAdd(id, nombre, apellido, telefono)
    }

    private fun onDelete(id: Int) {
        listener!!.deleteClient(id)
    }

    private fun onEdit(
        id: Int,
        nombre: String,
        apellido: String = "Obra maestra",
        telefono: String = "cccccccccc"
    ) {
        listener!!.clientEdit(id, nombre, apellido, telefono)
    }


}