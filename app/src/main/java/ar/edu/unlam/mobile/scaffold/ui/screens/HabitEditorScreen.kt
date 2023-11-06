package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
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
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextField
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue2

@Composable
fun AddHabit(closeSecondDialogEvent: () -> Unit) {
    var nameHabit by remember { mutableStateOf("") }
    var isCheckedSimple by remember { mutableStateOf(false) }
    var isCheckedSemanal by remember { mutableStateOf(false) }
    var horaSimple by remember { mutableStateOf("") }
    var dailyGoal by remember { mutableStateOf("") }
    var selectedDays by remember { mutableStateOf<Set<String>>(emptySet()) }

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
                TextButton(
                    onClick = { closeSecondDialogEvent() },
                ) {
                    Text(
                        text = "<volver",
                        textAlign = TextAlign.Left,
                    )
                }
            }
            DaysRowButtons { day, isSelected ->
                selectedDays = if (isSelected) {
                    selectedDays + day
                } else {
                    selectedDays - day
                }
                Log.i("DIAS", selectedDays.toString())
            }
            Spacer(
                modifier = Modifier
                    .height(12.dp),
            )
            nameHabit = CustomTextField(titleText = "Nombre del habito", text = "")

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(text = "Tarea simple")
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                Switch(
                    checked = isCheckedSimple,
                    onCheckedChange = { isChecked ->
                        isCheckedSimple = isChecked
                        isCheckedSemanal = false
                    }
                )
            }
            horaSimple = CustomTextField(titleText = "Hora", text = "")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(text = "Meta diaria")
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                Switch(
                    checked = isCheckedSemanal,
                    onCheckedChange = { isChecked ->
                        isCheckedSemanal = isChecked
                        isCheckedSimple = false
                    }
                )
            }
            dailyGoal = CustomTextField(titleText = "Hora por dia", text = "")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                TextButton(
                    onClick = { Log.i("BOTON CREAR HABITO", "CLICK") },
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

@Composable
fun AddEvent(closeThirdDialogEvent: () -> Unit) {
    var nameEvent by remember { mutableStateOf("") }
    var dateEvent by remember { mutableStateOf("") }
    var hourEvent by remember { mutableStateOf("") }
    var selectedDays by remember { mutableStateOf<Set<String>>(emptySet()) }
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
                TextButton(
                    onClick = { closeThirdDialogEvent() },
                ) {
                    Text(
                        text = "<volver",
                        textAlign = TextAlign.Left,
                    )
                }
            }

            DaysRowButtons { day, isSelected ->
                selectedDays = if (isSelected) {
                    selectedDays + day
                } else {
                    selectedDays - day
                }
                Log.i("DIAS", selectedDays.toString())
            }
            Spacer(
                modifier = Modifier
                    .height(12.dp),
            )
            nameEvent = CustomTextField(titleText = "Nombre del habito", text = "")
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            dateEvent = CustomTextField(titleText = "Fecha", text = "")
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            hourEvent = CustomTextField(titleText = "Hora(opcional)", text = "")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                TextButton(
                    onClick = {
                        Log.i("BOTON CREAR Evento", "CLICK")
                    },

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

@Composable
fun EventOrHabit(openSecondDialogEvent: () -> Unit, openThirdDialogEvent: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = CircleShape,
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                onClick = {
                    openSecondDialogEvent()
                },
                modifier = Modifier
                    .background(
                        color = CustomLightBlue2,
                        shape = CircleShape,
                    ),
            ) {
                Text(
                    text = "Habito",
                    textAlign = TextAlign.Left,
                )
            }
            Spacer(
                modifier = Modifier
                    .weight(1f),
            )
            TextButton(
                onClick = {
                    openThirdDialogEvent()
                },
                modifier = Modifier
                    .background(
                        color = CustomLightBlue2,
                        shape = CircleShape,
                    ),
            ) {
                Text(
                    text = "Evento",
                    textAlign = TextAlign.Right,
                )
            }
        }
    }
}
