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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            .size(200.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color.DarkGray, RoundedCornerShape(12.dp)) // Aplicar borde
    ) {
        Text(
            text = resultado,
            modifier = Modifier.align(Alignment.Center), // Centrar vertical y horizontalmente
            textAlign = TextAlign.Center, // Centrar el texto
            fontSize = 45.sp, // Tamaño de la fuente
            color = Color(0xFF4B4B4B) // Color del texto (opcional)
        )
    }
}

@Composable
fun Boton(name: String, onClick: () -> Unit) {
    TextButton(
        onClick  = onClick,
        modifier = Modifier
            .width(80.dp)  // Ancho del botón
            .height(150.dp)  // Alto del botón
            .border(2.dp, Color.DarkGray, RoundedCornerShape(12.dp)) // Aplicar borde
            .background(Color.Gray, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = name,
            fontSize = 70.sp, // Tamaño de la fuente
            color = Color.White // Color del texto (opcional)
        )
    }
}
@Composable
fun BotonSpecial(name: String, onClick: () -> Unit) {
    TextButton(
        onClick  = onClick,
        modifier = Modifier
            .width(80.dp)  // Ancho del botón
            .height(150.dp)  // Alto del botón
            .border(2.dp, Color.DarkGray, RoundedCornerShape(12.dp)) // Aplicar borde
            .background(Color(0xFF4B4B4B), shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = name,
            fontSize = 70.sp, // Tamaño de la fuente
            color = Color.White // Color del texto (opcional)
        )
    }
}

@Composable
fun VistaGeneral() {var resultado by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)
        .fillMaxSize()
        .padding(10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
        Resultado(resultado = resultado)
        Row(modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton(name = "7", onClick = {resultado+="7"}) //{ resultado.value += "1" }
            Boton(name = "8", onClick = {resultado+="8"})
            Boton(name = "9", onClick = {resultado+="9"})
            Boton(name = "0", onClick = {resultado+="0"})
        }
        Row(modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton(name = "4", onClick = {resultado+="4"})
            Boton(name = "5", onClick = {resultado+="5"})
            Boton(name = "6", onClick = {resultado+="6"})
            BotonSpecial(name = "C", onClick = {
                if (resultado.isNotEmpty()) {
                    resultado = resultado.dropLast(1)
                }
            })
        }
        Row(modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Boton(name = "1", onClick = {resultado+="1"})
            Boton(name = "2", onClick = {resultado+="2"})
            Boton(name = "3", onClick = {resultado+="3"})
            BotonSpecial(name = "*", onClick = {resultado+="*"})
        }
        Row(modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            BotonSpecial(name = "-", onClick = {resultado+="-"})
            BotonSpecial(name = "+", onClick = {resultado+="+"})
            BotonSpecial(name = "/", onClick = {resultado+="/"})
            BotonSpecial(name = "=", onClick = {resultado+="="})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    VistaGeneral()
}

