
# EXAMEN 25-10-23

Bien a Continuación vamos a preparar nuestro ejercicio para el **Examen** de hoy
Hemos creado esta nueva rama **Compose** en la que vamso a trabajar

    git branch Compose
    git checkout Compose

Bien Nos pide 4 botones, en este caso ya los tenía hechos :D **que felicidad**, solo queda reestructurarlos un poco

Bien Tras reestructurar estos botones con un par de **modifiers, Spacers, Columns, Row, etc.** 

Hemos ya implementado lo del siguiente ejercicio en este, puesto que al tener ya el ViewModel implementado
Es mucho más Sencillo

## Creamos nueva clase

Hemos creado una nueva clase **DATA** aqui será donde tengamos las variables, en este caso para
el primer ejercicio, solo hizo falta crear un Contador

    data class Contador(val valor:Int)

Este valor podremos referenciarlo desde nuesra clase **Model** y aquí será donde crearemos las nuevas funciones
de Modificar el contador, y obtener el valor del contador.

Obviamente cómo este contador lo modificamso desde la UI, debemos crear un objeto **mutableOfState**
Esto hace que actue como una especie de **Observer** de manera que llama a las funciones directamente 
y se actualiza a tiempo real.

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

Creamos también un **TEXTFIELD** FONDE SE MOSTRARAN LOS CAMBIOS DEL CONTADOR Al pulsar los botones START y PLAY

También hemos cambiado el tamaño del contador de manera que aumente el tamaño de la **fuante** cada vez que suma 10:

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





