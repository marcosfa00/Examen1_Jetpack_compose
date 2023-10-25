package com.example.myexam.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myexam.Aleatorio
import com.example.myexam.Contador
import com.example.myexam.Lista
import com.example.myexam.Nombre
import java.util.Random

//indicamos que esta clase extiende de VIEW Model
class Model():ViewModel() {
    //Aquí estableceremos los datos

    /**
     * Declaramos las nuevas variables llamando a la dataclass
     */
    var nombre = mutableStateOf(Nombre(""))
    var aleatorio = mutableStateOf(Aleatorio(0))
    var lista = mutableStateOf(Lista(emptyList()))
    fun random(){
        aleatorio.value = Aleatorio((0..10).random())
        Log.d("Estado", aleatorio.value.valor.toString())
    }

    fun randomLista() {
        val nuevoAleatorio = (0..8).random()
        val nuevaLista = Lista(lista.value.valor + nuevoAleatorio)
        lista.value = nuevaLista
        Log.d("Estado", "Números Lista: " + nuevoAleatorio.toString())
    }

    fun getLista(): List<Int> {
        return lista.value.valor
    }

    fun getRandom(): Int {
        return aleatorio.value.valor
    }

    fun getNombre(): String {
        return nombre.value.valor
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




