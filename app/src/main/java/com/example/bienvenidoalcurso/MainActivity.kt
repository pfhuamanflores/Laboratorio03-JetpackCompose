
package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaComponentes()
            }
        }
    }
}

@Composable
fun PantallaComponentes() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Exploración de Componentes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        EjemploText()
        EjemploTextField()
        EjemploButton()
        EjemploImage()
        EjemploColumn()
        EjemploRow()
        EjemploBox()
        EjemploCard()
    }
}

@Composable
fun EjemploText() {
    Text(
        text = "1. Ejemplo de Text",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}

@Composable
fun EjemploTextField() {
    var nombre by remember { mutableStateOf("") }

    TextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Ingresa tu nombre") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EjemploButton() {
    var contador by remember { mutableIntStateOf(0) }

    Button(
        onClick = { contador++ }
    ) {
        Text("Presionado: $contador")
    }
}

@Composable
fun EjemploImage() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_foreground
        ),
        contentDescription = "Imagen de Android",
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun EjemploColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text("Elemento vertical 1")
        Text("Elemento vertical 2")
        Text("Elemento vertical 3")
    }
}

@Composable
fun EjemploRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Uno")
        Text("Dos")
        Text("Tres")
    }
}

@Composable
fun EjemploBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text("Contenido centrado")
    }
}

@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Tarjeta de presentación",
                fontWeight = FontWeight.Bold
            )
            Text("Ejemplo de componente Card")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComponentes() {
    MaterialTheme {
        PantallaComponentes()
    }
}
