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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue
import kotlin.reflect.KFunction1

@Composable
fun PlannerScreen(modifier: Modifier = Modifier, viewModel: PlannerViewModel = hiltViewModel()) {
    val showDialog = viewModel.showDialog.value

    val openDialogEvent: () -> Unit = {
        viewModel.showOrDismissDialog(true)
    }
    val habits = viewModel.habits.value
    val activities = viewModel.activities.value

    Body(
        viewModel,
        habits = habits,
        activities,
        showDialog,
        openDialogEvent,
        viewModel::showOrDismissDialog,
    )
}

@Composable
fun Body(
    viewModel: PlannerViewModel,
    habits: List<Habit>,
    activities: List<Activity>,
    isDialogVisible: Boolean,
    openDialogEvent: () -> Unit,
    closeSecondDialogEvent: KFunction1<Boolean, Unit>,
) {
//    val habitsDedicated = activities.filter { it.category == TypeCategory.ACTIVITY }
//    val habitsSimple = habits.filter { it.category == TypeCategory.ROUTINE }
    // TODO campo de busqueda y filtros
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // TODO cambiar el icon por uno de filtro
//        FilterByCategory()

//        DaysRowButtons()
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
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    )
                }
            }
            items(activities.size) { item ->
                ItemHabit(
                    activities[item],
                    Icons.Default.Delete,
                    null,
                ) { viewModel.deleteActivity(activities[item].id) }
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
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    )
                }
            }
            items(habits.size) { item ->
                ItemHabit(
                    habits[item],
                    Icons.Default.Delete,
                    null,
                ) { viewModel.deleteHabit(habits[item].id) }
            }
        }
        IconButton(
            modifier = Modifier
                .padding(30.dp)
                .background(
                    color = CustomLightBlue,
                    shape = CircleShape,
                ),
            onClick = openDialogEvent,
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }

        if (isDialogVisible) {
            Dialog(
                onDismissRequest = {
                    viewModel.showOrDismissDialog(false)
                },
            ) {
                AddHabit(
                    closeSecondDialogEvent = viewModel::showOrDismissDialog,
                    viewModel::insertHabit,
                    viewModel::insertActivity,
                )
            }
        }
    }
}
