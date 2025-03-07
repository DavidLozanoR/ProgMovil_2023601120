package com.example.holatoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIPrincipal()
        }
    }
}
//programacion declarativa
@Composable
fun UIPrincipal() {
    val contexto = LocalContext.current
    var nombre by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()//utiliza todo el tamaño del contenedor padre
            .padding(16.dp)  // Padding general para separar los elementos de los bordes de la pantalla
    ) {
        Text("Nombre:")

        OutlinedTextField( //para ingresar texto
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Introduce tu nombre") },
            modifier = Modifier
                .fillMaxWidth()  // Asegura que el TextField ocupe todo el ancho disponible
                .padding(bottom = 16.dp)  // Padding adicional entre el campo de texto y el botón
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()  // Hace que el Box ocupe todo el ancho disponible
                .padding(top = 16.dp)  // Agrega espacio arriba del botón
        ) {
            Button(
                onClick = {
                    if (nombre.isNotEmpty()) {
                        Toast.makeText(contexto, "Hola $nombre", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(contexto, "Por favor, ingresa tu nombre", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.align(Alignment.Center)  // Centra el botón dentro del Box
            ) {
                Text("Saludar!")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIPrincipal()
}