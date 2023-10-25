
# EXAMEN 25-10-23


## RECAPITULAMOS ESTO  DE LA BRANCH COMPOSE

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

# CONTINUEMOS CON VIEW MODEL

Bien ahora vamos a continuar rehaciendo el ejercicio que ya traiamos de clase de manera que 
al **VIEW MODEL** Le implementemos el dataclass


En el **data class** declaramos lo siguiente

    data class Contador(val valor:Int) // hecho anteriormente

nuevo:

    data class Nombre(var valor:String)
    
    data class Aleatorio(var valor:Int)

    data class Lista(var valor: List<Int>)


Lo siguiete será modificar las funciones anteriores para implementar estas nuevas variables de forma correcta

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


Bueno, finalmente queda lo más importante, implementarlo en el UI

Para hacer esto habrá que hacer una serie de modificaciones , aunque no demasiadas
porque la parte gruesa del código está en el Model:

      OutlinedTextField(
                    value = miModel.nombre.value.valor,
                    onValueChange = { miModel.nombre.value = Nombre(it) }
                )

En el Outlined Text ya no accedemos a la propiedad value de nombre, si noque accedemos a valor, puesto que 
valor es lo que hemos definido en el **data class**

Cuando el valor del OutlinedTextField cambia, esta línea de código actualiza la propiedad nombre en el ViewModel. Se descompone de la siguiente manera:

**miModel:** El ViewModel que administra la lógica y los datos de la interfaz de usuario.
**nombre:** La propiedad del ViewModel que utiliza mutableStateOf para almacenar un objeto Nombre.
**value:** Accede al valor contenido en nombre, que es un objeto Nombre.
**= Nombre(it):** Crea un nuevo objeto **Nombre** utilizando **it**, que representa el valor actual del **OutlinedTextField**. 
it es una referencia al valor actual del campo de texto que ha cambiado. De esta manera, se actualiza la propiedad nombre con el nuevo valor del campo de texto.


y pcoo más hay que cambiar, aquí muestro el código completo


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


