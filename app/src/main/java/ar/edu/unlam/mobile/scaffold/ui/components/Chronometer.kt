package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue

@Composable
fun Chronometer() {
    Row(
        modifier = Modifier
            .width(320.dp)
            .height(64.dp)
            .padding(6.dp)
            .background(
                color = CustomLightBlue,
                shape = CircleShape,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            // TODO Que se pase por parametro un valor de tiempo
            text = "00:00:00",
            modifier = Modifier.weight(1f),
            style = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center,
            ),
        )
    }
}
