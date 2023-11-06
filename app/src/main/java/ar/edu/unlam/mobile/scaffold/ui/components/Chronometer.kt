package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

enum class TimerState {
    RUNNING, PAUSED, STOPPED
}

@Composable
fun Chronometer(initialState: TimerState) {
    var state by remember { mutableStateOf(initialState) }
    //TODO PASAR A HORAS, MINUTOS
    var elapsedMillis by remember { mutableLongStateOf(0L) }

    LaunchedEffect(state) {
        while (isActive) {
            when (state) {
                TimerState.RUNNING -> {
                    delay(1)
                    elapsedMillis++
                }

                TimerState.PAUSED -> {
                    //elapsedMillis
                }

                TimerState.STOPPED -> {
                    elapsedMillis = 0L
                }
            }
        }
    }
    val formattedTime = formatTime(elapsedMillis)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = formattedTime)
        when (state) {
            TimerState.STOPPED -> {
                Button(onClick = { state = TimerState.RUNNING }) {
                    Text(text = "Iniciar")
                }
            }

            TimerState.RUNNING -> {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                ) {
                    Button(onClick = { state = TimerState.PAUSED }) {
                        Text(text = "Pausar")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { state = TimerState.STOPPED }) {
                        Text(text = "Detener")
                    }
                }
            }

            TimerState.PAUSED -> {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                ) {
                    Button(onClick = { state = TimerState.PAUSED }) {
                        Text(text = "Reanudar")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { state = TimerState.STOPPED }) {
                        Text(text = "Detener")
                    }
                }
            }
        }
    }

}

fun formatTime(timeInMillis: Long): String {
    val hours = timeInMillis / 3600000
    val minutes = timeInMillis / 60000
    val seconds = timeInMillis / 1000

    return String.format("%02d$hours:%02d$minutes:%02d$seconds")
}

@Preview(showBackground = true)
@Composable
fun PreviewTimer() {
    Chronometer(initialState = TimerState.RUNNING)
}
