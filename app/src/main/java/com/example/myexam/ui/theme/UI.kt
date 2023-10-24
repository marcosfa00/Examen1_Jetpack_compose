package com.example.myexam.ui.theme

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun buttons(miModel :Model){
    Column {
        Row {
            FilledTonalButton(onClick = { miModel.randomLista()}) {
                Text(text = "Tonal_List")
            }
            Spacer(modifier = Modifier.height(50.dp)) // Espacio de 50.dp

            //Trabajamos con este boton
            OutlinedButton(onClick = {miModel.random()}) {
                Modifier.border(3.dp, Color.Black)//Por ue coño no funciona
                Text(text = "outlined_Random")

            }


            Spacer(modifier = Modifier.height(50.dp)) // Espacio de 50.dp
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "Elevated Button")
            }
        }
        Row {
            Spacer(modifier = Modifier.height(50.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Text Button")
            }
            Spacer(modifier = Modifier.height(50.dp))
            //TextField(value = , onValueChange = )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Boton normal")
            }




        }



    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textos(miModel: Model){
    Row {
        Text(
            fontSize = 40.sp,
            text =miModel.getRandom().toString()

        )

        Column {
            OutlinedTextField(
                value = miModel.getNombre(),
                onValueChange ={miModel.nombre.value = it} )

            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "Result:  "+ miModel.getNombre())

            Text(

                text =miModel.getLista().toString(),
                fontSize = 20.sp


            )

        }
    }

}





@Composable
fun Greeting(miModel: Model) {
    Column {
        buttons(miModel = miModel )
        Spacer(modifier = Modifier.height(50.dp))
        Textos(miModel = miModel)
    }





}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(miModel: Model) {
    MyExamTheme {
        Greeting(miModel = miModel)
    }
}