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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import kotlin.reflect.KFunction1

@Composable
fun AddHabit(
    closeSecondDialogEvent: KFunction1<Boolean, Unit>,
    actionHabit: KFunction1<Habit, Unit>,
    actionActivity: KFunction1<Activity, Unit>,
) {
    var habitName by remember { mutableStateOf("") }
    var isCheckedSimple by remember { mutableStateOf(false) }
    var isCheckedSemanal by remember { mutableStateOf(false) }
    var horaSimple by remember { mutableStateOf("") }
    var dailyGoal by remember { mutableStateOf("") }
    var selectedDays by remember { mutableStateOf<Set<Long>>(emptySet()) }
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
                    onClick = { closeSecondDialogEvent(false) },
                ) {
                    Text(
                        text = "<volver",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            color = Color.Black
                        )
                    )
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f),
                )
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
            TextField(
                value = habitName,
                label = { Text("Nombre") },
                onValueChange = {
                    habitName = it
                },
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(12.dp),
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
                    },
                )
            }
            TextField(
                value = horaSimple,
                label = { Text("Hora") },
                onValueChange = {
                    horaSimple = it
                },
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(12.dp),
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
                    },
                )
            }

            TextField(
                value = dailyGoal,
                label = { Text("Horas por dia") },
                onValueChange = {
                    dailyGoal = it
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
                        val category = if (isCheckedSimple) {
                            TypeCategory.ROUTINE
                        } else {
                            TypeCategory.ACTIVITY
                        }
                        val horas: Long = if (horaSimple.isEmpty()) {
                            0
                        } else {
                            horaSimple.toLong()
                        }
                        val hourDaily: Int = if (dailyGoal.isEmpty()) {
                            0
                        } else {
                            dailyGoal.toInt()
                        }

                        if (category == TypeCategory.ROUTINE) {
                            actionHabit(
                                Habit(
                                    0,
                                    habitName,
                                    category,
                                    selectedDays.toList(),
                                    horas,
                                    state = 1,
                                ),
                            )
                        } else {
                            actionActivity(
                                Activity(
                                    0,
                                    habitName,
                                    category,
                                    selectedDays.toList(),
                                    hourDaily.toString(),
                                    state = 1,
                                ),
                            )
                        }
                        closeSecondDialogEvent(false)
                    },
                ) {
                    Text(
                        text = "<crear>",
                        textAlign = TextAlign.Right,
                        style = TextStyle(
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}
