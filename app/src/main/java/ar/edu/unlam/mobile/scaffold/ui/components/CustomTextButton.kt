package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun CustomTextButton(action: () -> Unit, text: String) {
    Button(
        modifier = Modifier
            .padding(6.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
        onClick = { action },
    ) {
        Text(text = text)
    }
}
