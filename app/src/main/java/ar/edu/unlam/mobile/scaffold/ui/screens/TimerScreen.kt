package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.ui.components.customTextField
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomRed

@Composable
fun TimerScreen(viewModel: TimerViewModel = hiltViewModel()) {
    val uiState: TimerUIState by viewModel.uiState.collectAsState()

    var isStarted by remember { mutableStateOf(false) }
    var color by remember { mutableStateOf(CustomRed) }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        // TODO cambiar esto por un spinner
        customTextField(titleText = "Hábito", text = "Hábito")
        // TODO la meta diaria cambia segun el habito que se selecciona en el spinner
        customTextField(titleText = "Meta Diaria", text = "01:30hs")
        //        Chronometer(state)
        Row {
            if (!isStarted) {
                TextButton(
                    onClick = {
//                        viewModel.insertStart(startActivity)
                        isStarted = true
                    },
                    modifier = Modifier
                        .background(color = CustomLightBlue),
                    shape = CircleShape,
                ) {
                    Text(
                        text = "Iniciar",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            } else {
                TextButton(
                    onClick = {
//                        viewModel.insertEnd(ActivityEnd(0, date = now, startActivity.id))
                        isStarted = false
                    },
                    modifier = Modifier
                        .background(color = color),
                    shape = CircleShape,
                ) {
                    Text(
                        text = "Detener",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
        }
    }

    when (
        val jokeState = uiState.jokeState
    ) {
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
