package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextField
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.components.ToggleButton

@Composable
fun AddHabit(controller: NavHostController) {
    var isDialogVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
            )
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                //TODO en esta parte la app rompe
                TextButton(
                    onClick = { controller.navigate("planner") },

                    ) {
                    Text(
                        text = "<volver",
                        textAlign = TextAlign.Left,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                Text(
                    text = "Nuevo habito",
                    textAlign = TextAlign.Right,
                )
            }

            DaysRowButtons()
            CustomTextField(titleText = "Nombre", text = "(Nombre habito)")
            ToggleButton(text = "Tarea simple")
            ToggleButton(text = "Meta Diaria")
            CustomTextField(titleText = "Meta diaria", text = "00:00hs")
            ToggleButton(text = "Meta semanal")
            CustomTextField(titleText = "Meta semanal", text = "00:00hs")

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                TextButton(
                    onClick = { isDialogVisible = false },

                    ) {
                    Text(
                        text = "<crear>",
                        textAlign = TextAlign.Right,
                    )
                }
            }
        }
    }
}
