package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons
import ar.edu.unlam.mobile.scaffold.ui.components.FilterByCategory
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue

@Preview(showBackground = true)
@Composable
fun PlannerScreen() {
    val habits: MutableList<Habit> = mutableListOf()
    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))
    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))
    habits.add(Habit("estudiar 2hrs", TypeCategory.DEDICATED, isSimple = false, 2, 8))
    habits.add(Habit("ir al medico a las 10am", TypeCategory.EVENT, isSimple = false, 0, 0))

    Body(habits = habits)
}

@Composable
fun Body(habits: MutableList<Habit>) {
    val events = habits.filter { it.category == TypeCategory.EVENT }
    val habitsDedicated = habits.filter { it.category == TypeCategory.DEDICATED }
    val habitsSimple = habits.filter { it.category == TypeCategory.SIMPLE }
    var isDialogVisible by remember { mutableStateOf(false) }
    // TODO pasar lista de habitos por parametro
    // val habitsList = listOf("Habito", "Habito", "Habito", "Habito")
    // TODO campo de busqueda y filtros
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 65.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // TODO cambiar el icon por uno de filtro
        FilterByCategory()

        DaysRowButtons()
        Text(
            text = "<Planner>",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
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

            items(events.size) {
                    item-> ItemHabit(events[item].name, Icons.Default.Clear)
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
            items(habitsDedicated.size) {
                    item-> ItemHabit(habitsDedicated[item].name, Icons.Default.Clear)
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
            items(habitsSimple.size) {
                    item-> ItemHabit(habitsSimple[item].name, Icons.Default.Clear)
            }
        }
        IconButton(
            modifier = Modifier
                .padding(6.dp)
                .background(
                    color = CustomLightBlue,
                    shape = CircleShape,
                ),
            onClick = { isDialogVisible = true },
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }

        if (isDialogVisible) {
            Dialog(
                onDismissRequest = {
                    isDialogVisible = false
                },
                content = {
                    EventOrHabit()
                })
        }
    }
}
