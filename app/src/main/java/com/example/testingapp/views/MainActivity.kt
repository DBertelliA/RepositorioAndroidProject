package com.example.testingapp.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapp.R
import com.example.testingapp.interfaces.Client
import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones

class MainActivity : AppCompatActivity() {
    public lateinit var myButtonAdd: ImageView
    public lateinit var myButtonUpdate: ImageView
    public lateinit var myButtonDel: ImageView
    public lateinit var  textV : TextView
    lateinit var  cont : Controlador
    companion object{ const val TAG ="---Salida---"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es el mensaje de inicio log")
        cont = Controlador(this)
        cont.start()
    }


    fun showState(): String {
        Log.d(TAG, "Esta es la nueva data" + cont.showData())
        return cont.showData()
    }

    fun updateContent(text1: String){
        textV.text = text1;
    }

}