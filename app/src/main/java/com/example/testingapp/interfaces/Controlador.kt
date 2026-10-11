package com.example.testingapp.interfaces

import android.util.Log
import com.example.testingapp.Data.ClientsRepo
import com.example.testingapp.R
import com.example.testingapp.interfaces.Inter.Operaciones
import com.example.testingapp.views.Dialog
import com.example.testingapp.views.MainActivity
import com.example.testingapp.views.MainActivity.Companion.TAG

class Controlador (val actividad: MainActivity) : Operaciones {


    private var mutableListOfPeople : MutableList<Client> =  ClientsRepo.listaCLientes.toMutableList()
    var dialogo = Dialog()
    fun start(){
        actividad.myButtonAdd = actividad.findViewById(R.id.myButtonAdd)
        actividad.myButtonDel = actividad.findViewById(R.id.myButtonDel)
        actividad.myButtonUpdate = actividad.findViewById(R.id.myButtonUpdate)

        actividad.textV = actividad.findViewById(R.id.myText)
        dialogo.setListener(this)
        actividad.myButtonAdd.setOnClickListener {
            dialogo.show(0)
            actividad.updateContent(actividad.showState())
        }
        actividad.myButtonDel.setOnClickListener {
            dialogo.show(1)
            actividad.updateContent(actividad.showState())
        }
        actividad.myButtonUpdate.setOnClickListener {
            dialogo.show(2)
            actividad.updateContent(actividad.showState())
        }
        actividad.textV.setText(showData())
    }

    fun insertClientController(cli : Client){
        mutableListOfPeople.add(cli)
        actividad.textV.setText(showData())
        showData()
    }

    fun deleteClientController(idC : Int) : Boolean{
        if(mutableListOfPeople.removeIf{it.id == idC}){
            actividad.textV.setText(showData())
            print(showData())
            return true
        }
        return false
    }

    fun editClientController(idC : Int, nombreC : String, apellidos: String, telefono: String) : Boolean{
        val findClient : Client? = mutableListOfPeople.find {it.id == idC}
        return findClient?.let {
            it.nombre = nombreC
            actividad.textV.setText(showData())
            showData()
            return true
        }?: false
    }


    fun showData() = mutableListOfPeople.toString()

    override fun clientAdd(id: Int, nombre: String, apellidos : String, telefono : String) {
        insertClientController(Client(id,nombre,apellidos, telefono))

        Log.d(TAG, "El cliente $id y nombre $nombre ${showData()}")
    }

    override fun clientEdit(id: Int, nombre: String, apellidos: String, telefono: String){
        editClientController(id, nombre, apellidos, telefono)
        Log.d(TAG, "El cliente $id tiene nombre $nombre editado ${showData()}")

    }

    override fun deleteClient(id: Int) {
        deleteClientController(id)
        Log.d(TAG, "El cliente de id $id, ha sido eliminado ${showData()}")
    }

}