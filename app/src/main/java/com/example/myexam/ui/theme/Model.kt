package com.example.myexam.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myexam.Contador
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


    /**
     * EXAMEN
     */
    var contador by mutableStateOf(Contador(0))

    /**
    Accedemos a la instancia valor de contador y le sumamos uno
     esto se almacena en contador
     */
    fun setContador(){
        contador = Contador(contador.valor +1)
    }

    fun getContador():Int{
        return contador.valor
    }
    fun reset(){
        contador = Contador(0)
    }

}