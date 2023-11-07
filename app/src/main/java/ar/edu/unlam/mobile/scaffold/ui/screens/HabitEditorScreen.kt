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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.components.ToggleButton
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue2

@Composable
fun AddHabit(closeSecondDialogEvent: () -> Unit, viewModel: PlannerViewModel) {
    var nombreHabito by remember { mutableStateOf("") }
    var isCheckedSimple by remember { mutableStateOf(false) }
    var isCheckedSemanal by remember { mutableStateOf(false) }
    var horaSimple by remember { mutableStateOf("") }
    var metaSemanal by remember { mutableStateOf("") }
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
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
            }

            DaysRowButtons() { day, isSelected ->
                selectedDays = if (isSelected) {
                    selectedDays + day
                } else {
                    selectedDays - day
                }
                Log.i("DIAS", selectedDays.toString())
            }

            TextField(
                value = nombreHabito,
                label = { Text("Nombre") },
                onValueChange = {
                    nombreHabito = it
                },
            )

            isCheckedSimple = ToggleButton(text = "Tarea Simple")

            TextField(
                value = horaSimple,
                label = { Text("Hora") },
                onValueChange = {
                    horaSimple = it
                },
            )

            isCheckedSemanal = ToggleButton(text = "Meta Diaria")

            TextField(
                value = metaSemanal,
                label = { Text("Horas x dia") },
                onValueChange = {
                    metaSemanal = it
                },
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
                TextButton(
                    onClick = {
                        Log.i("BOTON CREAR HABITO", "CLICK")
                        val categoria = if (isCheckedSimple) {
                            TypeCategory.SIMPLE
                        } else {
                            TypeCategory.DEDICATED
                        }
                        val horas = if (horaSimple.isNotEmpty()) {
                            horaSimple
                        } else {
                            metaSemanal
                        }
                        viewModel.insertHabit(
                            Habit(
                                1,
                                nombreHabito,
                                categoria,
                                selectedDays.toList(),
                                horas.toLong(),
                            ),
                        )
                        closeSecondDialogEvent()
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
fun AddEvent(closeThirdDialogEvent: () -> Unit) {
    var nombreHabito by remember { mutableStateOf("") }
    var fechaHabito by remember { mutableStateOf("") }
    var horaHabito by remember { mutableStateOf("") }
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
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
            }

//            DaysRowButtons { day, isSelected ->
//                selectedDays = if (isSelected) {
//                    selectedDays + day
//                } else {
//                    selectedDays - day
//                }
//                Log.i("DIAS", selectedDays.toString())
//            }
            TextField(
                value = nombreHabito,
                label = { Text("Nombre del hábito") },
                onValueChange = {
                    nombreHabito = it
                },
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            TextField(
                value = fechaHabito,
                label = { Text("Fecha") },
                onValueChange = {
                    fechaHabito = it
                },
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            TextField(
                value = horaHabito,
                label = { Text("Hora") },
                onValueChange = {
                    horaHabito = it
                },
            )
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
