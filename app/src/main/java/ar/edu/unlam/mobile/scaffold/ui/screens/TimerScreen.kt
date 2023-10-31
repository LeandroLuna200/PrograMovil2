package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.ui.components.Chronometer
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextButton
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextField
import ar.edu.unlam.mobile.scaffold.ui.components.ToggleButton

@Composable
fun TimerScreen(modifier: Modifier = Modifier, viewModel: TimerViewModel = hiltViewModel()) {
    val uiState: TimerUIState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        // TODO cambiar esto por un spinner
        CustomTextField(titleText = "Hábito", text = "Hábito")
        CustomTextField(titleText = "Meta Diaria", text = "01:30hs")
        ToggleButton(text = "Modo Zen")
        Chronometer()
        when (val jokeState = uiState.jokeState) {
            is JokeUIState.Loading -> {
                CircularProgressIndicator()
            }

            is JokeUIState.Success -> {
                Text(jokeState.joke.value)
                Log.i("CHUCK NORRIS", jokeState.joke.value)
            }

            is JokeUIState.Error -> {
                // Error
            }
        }

        Row() {
            CustomTextButton({}, "Iniciar")
        }
    }
}
