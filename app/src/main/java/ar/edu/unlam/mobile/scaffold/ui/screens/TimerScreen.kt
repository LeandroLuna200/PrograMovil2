package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.components.Chronometer
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextButton
import ar.edu.unlam.mobile.scaffold.ui.components.CustomTextField
import ar.edu.unlam.mobile.scaffold.ui.components.ToggleButton
@Preview
@Composable
fun TimerScreen() {
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
        Text("Chiste de Chuck Norris")
        Row() {
            CustomTextButton({}, "Iniciar")
        }
    }
}
