package com.example.calculadorajp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadorajp.ui.theme.CalculadoraJPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VistaGeneral()
        }
    }
}

@Composable
fun Resultado(resultado: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .background(Color.Red, shape = RectangleShape)
            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)) // Aplicar borde
    ) {
        Text(
            text = resultado,
            modifier = Modifier.align(Alignment.Center), // Centrar vertical y horizontalmente
            textAlign = TextAlign.Center, // Centrar el texto
            fontSize = 45.sp, // Tamaño de la fuente
            color = Color.White // Color del texto (opcional)
        )
    }
}

@Composable
fun Boton(name: String, onClick: () -> Unit) {
    TextButton(
        onClick  = onClick,
        modifier = Modifier
            .width(70.dp)  // Ancho del botón
            .height(150.dp)  // Alto del botón
            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)) // Aplicar borde
            .background(Color.Red, shape = RectangleShape)
    ) {
        Text(
            text = name,
            fontSize = 70.sp, // Tamaño de la fuente
            color = Color.White // Color del texto (opcional)
        )
    }
}
@Composable
fun BotonSpecial(name: String) {
    TextButton(
        onClick = {

        },
        modifier = Modifier
            .width(70.dp)  // Ancho del botón
            .height(150.dp)  // Alto del botón
            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)) // Aplicar borde
            .background(Color.Red, shape = RectangleShape)
    ) {
        Text(
            text = name,
            fontSize = 70.sp, // Tamaño de la fuente
            color = Color.White // Color del texto (opcional)
        )
    }
}
@Composable
fun Calculadora() {
    // Estado para el resultado
    val resultado = remember { mutableStateOf("") }

    // Composable para mostrar el resultado
    Resultado(resultado.value)

    // Composables para los botones
    // Ejemplo de botón "1"
    Boton(name = "1") { resultado.value += "1" }
    Boton(name = "2") { resultado.value += "2" }
    Boton(name = "3") { resultado.value += "3" }
    Boton(name = "4") { resultado.value += "4" }
    Boton(name = "5") { resultado.value += "5" }
    Boton(name = "6") { resultado.value += "6" }
    Boton(name = "7") { resultado.value += "7" }
    Boton(name = "8") { resultado.value += "8" }
    Boton(name = "9") { resultado.value += "9" }
    Boton(name = "0") { resultado.value += "0" }
    Boton(name = "+") { resultado.value += "+" }
    Boton(name = "-") { resultado.value += "-" }
    Boton(name = "/") { resultado.value += "/" }
    Boton(name = "*") { resultado.value += "*" }
    Boton(name = "=") { resultado.value += "=" }
    // Puedes agregar más botones según sea necesario
}

@Composable
fun VistaGeneral() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly) {
        Resultado("123")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton("7"){ resultado.value += "1" }
            Boton("4")
            Boton("1")
            Boton("0")
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton("8")
            Boton("5")
            Boton("2")
            Boton("C")
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton("9")
            Boton("6")
            Boton("3")
            Boton("*")
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton("-")
            Boton("+")
            Boton("/")
            Boton("=")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    VistaGeneral()
}

