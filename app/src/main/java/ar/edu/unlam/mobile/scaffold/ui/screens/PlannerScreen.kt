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
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue

@Composable
fun PlannerScreen(modifier: Modifier = Modifier, viewModel: PlannerViewModel = hiltViewModel()) {
    val showDialog = viewModel.showDialog.value
    val showSecondDialog = viewModel.showSecondDialog.value
    val showThirdDialog = viewModel.showThirdDialog.value

    val openDialogEvent: () -> Unit = {
        viewModel.showOrDismissDialog(true)
    }

    val closeDialogEvent: () -> Unit = {
        viewModel.showOrDismissDialog(false)
    }

    val openSecondDialogEvent: () -> Unit = {
        viewModel.showOrDismissSecondDialog(true)
    }

    val closeSecondDialogEvent: () -> Unit = {
        viewModel.showOrDismissSecondDialog(false)
    }

    val openThirdDialogEvent: () -> Unit = {
        viewModel.showOrDismissThirdDialog(true)
    }

    val closeThirdDialogEvent: () -> Unit = {
        viewModel.showOrDismissThirdDialog(false)
    }

    val habits = viewModel.habits.value
//    val habits by viewModel.habits.collectAsState()

    Body(
        viewModel,
        habits = habits,
        showDialog,
        openDialogEvent,
        closeDialogEvent,
        showSecondDialog,
        openSecondDialogEvent,
        closeSecondDialogEvent,
        showThirdDialog,
        openThirdDialogEvent,
        closeThirdDialogEvent,
    )
}

@Composable
fun Body(
    viewModel: PlannerViewModel,
    habits: List<Habit>,
    isDialogVisible: Boolean,
    openDialogEvent: () -> Unit,
    closeDialogEvent: () -> Unit,
    showSecondDialog: Boolean,
    openSecondDialogEvent: () -> Unit,
    closeSecondDialogEvent: () -> Unit,
    showThirdDialog: Boolean,
    openThirdDialogEvent: () -> Unit,
    closeThirdDialogEvent: () -> Unit,
) {
    val events = habits.filter { it.category == TypeCategory.EVENT }
    val habitsDedicated = habits.filter { it.category == TypeCategory.DEDICATED }
    val habitsSimple = habits.filter { it.category == TypeCategory.SIMPLE }
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
                ItemHabit(events[item].name, events[item].id, Icons.Default.Delete, viewModel)
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
                ItemHabit(
                    habitsDedicated[item].name,
                    habitsDedicated[item].id,
                    Icons.Default.Delete,
                    viewModel,
                )
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
                ItemHabit(
                    habitsSimple[item].name,
                    habitsSimple[item].id,
                    Icons.Default.Delete,
                    viewModel,
                )
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
                    closeDialogEvent()
                },
            ) {
                EventOrHabit(openSecondDialogEvent, openThirdDialogEvent)
            }
        }

        if (showSecondDialog) {
            Dialog(
                onDismissRequest = {
                    closeSecondDialogEvent()
                    // Lógica de cierre del segundo diálogo
                },
                content = {
                    AddHabit(closeSecondDialogEvent, viewModel)
                },
            )
        }

        if (showThirdDialog) {
            Dialog(
                onDismissRequest = {
                    closeThirdDialogEvent()
                    // Lógica de cierre del tercer diálogo
                },
                content = {
                    AddEvent(closeThirdDialogEvent)
                },
            )
        }
    }
}
