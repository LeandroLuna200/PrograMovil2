package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.ui.components.CustomIconButton
import ar.edu.unlam.mobile.scaffold.ui.components.ItemHabit
import ar.edu.unlam.mobile.scaffold.ui.components.DaysRowButtons

@Preview
@Composable
fun PlannerScreen() {
    val habits: MutableList<Habit> = mutableListOf()
    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))

    Body(habits = habits)
}

@Composable
fun Body(habits: MutableList<Habit>) {
    // TODO pasar lista de habitos por parametro
    // val habitsList = listOf("Habito", "Habito", "Habito", "Habito")
    // TODO campo de busqueda y filtros
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 65.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier,
        ) {
            var text by remember{ mutableStateOf("") }
            TextField(modifier= Modifier
                .fillMaxWidth()
                .padding(12.dp),

                value = text,
                onValueChange = { newText ->
                text = newText
            },
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    }
                }
            )
        }
        //TODO cambiar el icon y que este al lado del buscador
        Icon(
            modifier = Modifier,
            imageVector = Icons.Default.Settings,
            contentDescription = null)
        DaysRowButtons()
        Text(
            text = "<Planner>",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(habits.size) {
                item-> ItemHabit(habits[item].name, {}, Icons.Default.Edit)
            }
        }
        // TODO que el boton abra el pop-up de creacion de hábitos
        CustomIconButton(controller = rememberNavController(), route = "habit editor" , icon = Icons.Filled.Add)
    }
}

