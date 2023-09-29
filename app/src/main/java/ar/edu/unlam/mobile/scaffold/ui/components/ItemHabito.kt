package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffold.R

@Preview
@Composable
fun ItemHabito() {
    val text by remember { mutableStateOf("Hábito 1") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 5.dp, bottom = 5.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(colorResource(id = R.color.color1), Color(0xFF007ACC)),
                ),
                shape = RoundedCornerShape(
                    topStart = 16.dp, // Radio de la esquina superior izquierda
                    topEnd = 16.dp, // Radio de la esquina superior derecha
                    bottomStart = 16.dp, // Radio de la esquina inferior izquierda (0 para bordes rectos)
                    bottomEnd = 16.dp, // Radio de la esquina inferior derecha (0 para bordes rectos)
                ),
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = text,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                ), // Cambia el color del texto aquí
            )

            Button(
                onClick = { /* Acción del botón */ },
//                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.color1)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_check_24), // Reemplaza con el recurso de tu icono
                    contentDescription = null, // Descripción opcional del icono para accesibilidad
                    tint = Color.White, // Color del icono
                    modifier = Modifier.size(24.dp),
                )
            }
        }
    }
}
