package com.example.myexam.ui.theme

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myexam.Nombre


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun buttons(miModel :Model){

    Column(
        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilledTonalButton(onClick = { miModel.randomLista()},
                ) {
                Text(text = "Tonal_List")

            }

            Spacer(modifier = Modifier.width(16.dp)) // Espa
            //Trabajamos con este boton
            OutlinedButton(onClick = {miModel.random()}) {

                Text(text = "outlined_Random")

            }
        }

        Row {
            Spacer(modifier = Modifier.height(50.dp)) // Espacio de 50.dp
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "Elevated Button")
            }
            Spacer(modifier = Modifier.width(16.dp)) // Espa
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Text Button")

            }
        }
        Row {
            FilledTonalButton(onClick = { miModel.reset() }) {
                Text(text = "START")
            }
            Spacer(modifier = Modifier.width(16.dp)) // Espa
            FilledTonalButton(onClick = { miModel.setContador() }) {
                Text(
                    text = "►",
                    fontSize = 25.sp
                )

            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ronda(miModel: Model){
    Column(
        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "RONDA")

        val contador = miModel.getContador()
        val fontSize = 10.sp * ((contador / 10) + 1)
        OutlinedTextField(
            value = contador.toString(),
            onValueChange = { /* Tu código de manejo de cambios aquí */ },
            modifier = Modifier
                .padding(16.dp)
                .width(150.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = fontSize)
        )

        Row {
            buttons(miModel = miModel)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textos(miModel: Model) {
    Column(
        modifier = Modifier.padding(top = 360.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Aquí se muestra el ejercicio Anterior, el boton que atucaliza la lista es el Tonal_list y el que  actualiza solo el Random es el outlined Random")
        Row {
            Text(
                fontSize = 40.sp,
                text = miModel.getRandom().toString()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                OutlinedTextField(
                    value = miModel.nombre.value.valor,
                    onValueChange = { miModel.nombre.value = Nombre(it) }
                )

                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Result: " + miModel.nombre.value.valor)


                Text(
                    text = "Lista: "+ miModel.getLista(),
                    fontSize = 20.sp
                )
            }
        }
    }
}







@Composable
fun Greeting(miModel: Model) {

        ronda(miModel = miModel)
        Spacer(modifier = Modifier.height(50.dp))

        Spacer(modifier = Modifier.height(50.dp))


        Textos(miModel = miModel)

}



