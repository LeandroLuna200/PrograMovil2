package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit

@Composable
fun HabitScreen(
    modifier: Modifier? = Modifier,
    navController: NavController,
    viewModel: HabitViewModel = hiltViewModel(),
) {
    val currentDate by remember { mutableStateOf(viewModel.getCurrentDate()) }
    val habits = viewModel.filterHabitByDay()
    val activities = viewModel.filterActivityByDay()
    var selectedDays = viewModel.selectedDays.value

//    var showDialog by remember { mutableStateOf(viewModel.hayIncompletas) }

//    Log.i("BOOLEAN2", showDialog.toString())
    val hayIncompletas by viewModel.hayIncompletas.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 75.dp),
    ) {
        Text(
            text = currentDate,
            style = TextStyle(color = Color.Black, fontSize = 30.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
        Log.i("DIA", selectedDays.toString())
        DaysRowButtons { day, isSelected ->
            selectedDays = if (isSelected) {
                selectedDays + day
            } else {
                selectedDays - day
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
//                .weight(1f), // Ocupa el espacio restante en la columna
        ) {
            item {
                Text(
                    text = "Tareas Dedicadas",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )
                if (activities.isEmpty()) {
                    Text(
                        text = "no hay tareas dedicadas por el momento",
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
            items(activities.size) { item ->
                ItemHabit(
                    activities[item],
                    Icons.Default.ArrowForward,
                    navController,
                ) { }
            }
            item {
                Text(
                    text = "Tareas simples",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )
                if (habits.isEmpty()) {
                    Text(
                        text = "no hay tareas simples por el momento",
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
            items(habits.size) { item ->
                ItemHabit(
                    habits[item],
                    Icons.Default.Clear,
                    null,
                ) { viewModel.updateHabit(habits[item]) }
            }
        }
    }
//    Log.i("BOOLEAN2", showDialog.toString())
    if (hayIncompletas) {
//        Log.i("BOOLEAN2", showDialog.toString())
        AlertDialog(
            onDismissRequest = {
                // Aquí puedes realizar acciones cuando se cierra el cuadro de diálogo
            },
            title = {
                Text("Tareas Incompletas")
            },
            text = {
                Text("hay tareas incompletas")
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.dismissIncompletasDialog()
                        // Puedes realizar acciones adicionales aquí
                    },
                ) {
                    Text("Aceptar")
                }
            },
        )
    }
}
