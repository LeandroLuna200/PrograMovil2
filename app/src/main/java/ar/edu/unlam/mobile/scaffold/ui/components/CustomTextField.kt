package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CustomTextField(titleText: String, text: String) :String{
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        var initialText by remember { mutableStateOf(text) }
        OutlinedTextField(
            value = initialText,
            onValueChange = { newText ->
                initialText = newText
            },
            label = {
                Text(text = titleText)
            },
            maxLines = 2,
        )
    }
    return text
}
