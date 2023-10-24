package com.example.myexam

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myexam.ui.theme.Greeting
import com.example.myexam.ui.theme.Model
import com.example.myexam.ui.theme.MyExamTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val miModel : Model = Model()
        setContent {
            MyExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(miModel = miModel)
                }
            }
        }
    }

    //funciones On que deben ir dentro de la main activity
    val TAG: String = "Estado"
    var tiempoInicio: Long = 0
    var tiempoFin : Long = 0

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Funcion on start")
        tiempoInicio = System.currentTimeMillis()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Funcion on Pause")
        tiempoFin = System.currentTimeMillis()
        tiempoFin -= tiempoInicio
        tiempoFin = tiempoFin /1000
        Log.d(TAG,"El tiempo transcurrido entre el Start y la pausa de la aplicacion es de: " + tiempoFin + " Segundos")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"Funcion on resume")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Funcion on STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Funcion on Destroy")
    }





}
