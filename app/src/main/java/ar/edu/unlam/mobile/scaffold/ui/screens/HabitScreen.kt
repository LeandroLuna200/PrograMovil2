package ar.edu.unlam.mobile.scaffold.ui.screens

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit
import java.util.Date

@Composable
fun HabitScreen(modifier: Modifier = Modifier, viewModel: PlannerViewModel = hiltViewModel()) {
    val currentDate by remember { mutableStateOf(getCurrentDate()) }
    // TODO pasar lista de Habits por parametro
    val habits = viewModel.habits.value

    val events = habits.filter { it.category == TypeCategory.EVENT }
    val habitsDedicated = habits.filter { it.category == TypeCategory.DEDICATED }
    val habitsSimple = habits.filter { it.category == TypeCategory.SIMPLE }
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
//        DaysRowButtons()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
//                .weight(1f), // Ocupa el espacio restante en la columna
        ) {
            item {
                Text(
                    text = "Eventos",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )
            }

            items(events.size) { item ->
                ItemHabit(events[item].name, events[item].id, Icons.Default.Clear, viewModel)
            }

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
            }
            items(habitsDedicated.size) { item ->
                ItemHabit(habitsDedicated[item].name, habitsDedicated[item].id, Icons.Default.Clear, viewModel)
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
            }
            items(habitsSimple.size) { item ->
                ItemHabit(habitsSimple[item].name, habitsSimple[item].id, Icons.Default.Clear, viewModel)
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(Date())
}

// @Preview(showBackground = true)
// @Composable
// fun PreviewScreen() {
//    val habits: MutableList<Habit> = mutableListOf()
//    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))
//    HabitScreen()
// }
