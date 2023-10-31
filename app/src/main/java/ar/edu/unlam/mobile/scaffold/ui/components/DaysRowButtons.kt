package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue2

@Preview
@Composable
fun DaysRowButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Day("D")
        Day("L")
        Day("M")
        Day("X")
        Day("J")
        Day("V")
        Day("S")
    }
}

@Composable
fun Day(text: String) {
    var isButtonClicked by remember { mutableStateOf(false) }

    val buttonColor = if (isButtonClicked) {
        CustomLightBlue
    } else {
        CustomLightBlue2
    }

    Row(
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
            .background(
                color = buttonColor,
                shape = CircleShape,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(
            onClick = { isButtonClicked = !isButtonClicked },
            modifier = Modifier
                .background(
                    color = buttonColor,
                    shape = CircleShape,
                )
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
            )
        }

    }
}
