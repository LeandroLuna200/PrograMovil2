package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
@Composable
fun ToggleButton(text: String) {
    Row(
        modifier = Modifier
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier,
        )
        Spacer(
            modifier = Modifier
                .weight(1f),
        )

        var isChecked by remember { mutableStateOf(false) }

        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
        )
    }
}