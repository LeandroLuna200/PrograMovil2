package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffold.ui.components.CustomIconButton
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabito

@Preview
@Composable
fun PlannerScreen() {
    val habitsList = listOf("Habito", "Habito", "Habito", "Habito")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 65.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "<Planner>",
            style = TextStyle(color = Color.Black, fontSize = 30.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(habitsList.size) {
                ItemHabito("habito") {}
            }
        }
        CustomIconButton() {}
    }
}
