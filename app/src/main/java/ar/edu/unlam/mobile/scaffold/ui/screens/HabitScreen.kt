package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabito
import ar.edu.unlam.mobile.scaffold.ui.components.ListItemsHabits


@Composable
fun HabitScreen(modifier: Modifier = Modifier) {
    val listaDeElementos = listOf("Elemento 1", "Elemento 2", "Elemento 3")

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Pantalla principal",
            style = TextStyle(color = Color.Black, fontSize = 30.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        DaysRowButtons()

        Text(
            text = "Objetivos",
            style = TextStyle(color = Color.Black, fontSize = 15.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        ListItemsHabits(items = listaDeElementos)

        Text(
            text = "Metas",
            style = TextStyle(color = Color.Black, fontSize = 30.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        ListItemsHabits(items = listaDeElementos)

    }
}