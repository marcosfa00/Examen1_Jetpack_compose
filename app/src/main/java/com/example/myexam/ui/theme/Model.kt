package com.example.myexam.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Random

//indicamos que esta clase extiende de VIEW Model
class Model():ViewModel() {
    //Aquí estableceremos los datos


    var nombre = mutableStateOf("")

    //declar la variable random
    /*
    Si quiero que sea un numero pongo ej:0, si quiero que sea un String ""
     */
    var aleatorio = mutableStateOf(0)

    var lista = mutableStateListOf<Int>()
    fun random(){
        aleatorio.value = ((0..10).random())
        Log.d("Estado",aleatorio.value.toString())
    }
    fun randomLista(){
        aleatorio.value = ((0..8).random())
        lista.add(aleatorio.value)
        Log.d("Estado","Nuemros Lista: "+aleatorio.value.toString())
    }

    fun getLista():List<Int>{
        return lista.toList() //si no ponemos el toList, devuelve direcciones de memoria
    }

    //así indicamos que esta función retorne algo
    fun getRandom():Int{
        return aleatorio.value
    }

    fun getNombre():String{
        return  nombre.value
    }

}