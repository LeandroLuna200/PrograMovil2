package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextField
import ar.edu.unlam.mobile.scaffold.ui.components.TimerState

@Composable
fun TimerScreen(viewModel: TimerViewModel = hiltViewModel()) {
    // TODO filtrar lista por habits dedicated
    val habits: MutableList<Habit> = mutableListOf()
//    habits.add(Habit("levantarme temprano", TypeCategory.DEDICATED, 0))
//    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, 0))
//    habits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, 0))

    val uiState: TimerUIState by viewModel.uiState.collectAsState()
    val state by remember { mutableStateOf(TimerState.STOPPED) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        // TODO cambiar esto por un spinner
        CustomTextField(titleText = "Hábito", text = "Hábito")
        // TODO la meta diaria cambia segun el habito que se selecciona en el spinner
        CustomTextField(titleText = "Meta Diaria", text = "01:30hs")
//        Chronometer(state)
//        if (TimerState.RUNNING == state) {
//            when (val jokeState = uiState.jokeState) {
//                is JokeUIState.Loading -> {
//                    CircularProgressIndicator()
//                }
//
//                is JokeUIState.Success -> {
//                    Text(jokeState.joke.value)
//                    Log.i("CHUCK NORRIS", jokeState.joke.value)
//                }
//
//                is JokeUIState.Error -> {
//                    // Error
//                }
//            }
//        }

        when (val jokeState = uiState.jokeState) {
            is JokeUIState.Loading -> {
                CircularProgressIndicator()
            }

            is JokeUIState.Success -> {
                Text(jokeState.joke.value)
                Log.i("CHUCK NORRIS", jokeState.joke.value)
            }

            is JokeUIState.Error -> {
            }
        }
    }
}
