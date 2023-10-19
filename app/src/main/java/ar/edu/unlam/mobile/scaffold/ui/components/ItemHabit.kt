package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemHabit(text: String, action: () -> Unit, iconButton: ImageVector) {
    var clicked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .width(320.dp)
                .fillMaxHeight()
                .padding(6.dp)
                .background(
                    color = Color.Red,
                    shape = CircleShape,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                ),
            )
        }
        IconButton(
            modifier = Modifier
                .size(64.dp)
                .padding(6.dp)
                .background(
                    color = Color.Red,
                    shape = CircleShape,
                ),
            onClick = { /*clicked = true*/ action },
        ) {
            Icon(iconButton, contentDescription = null)
        }
        /*if (clicked)
            if (iconButton == Icons.Default.Clear)
                IconButton(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(6.dp)
                        .background(
                            color = Color.Green,
                            shape = CircleShape,
                        ),
                    onClick = { clicked = true },
                ) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }

            else if (iconButton == Icons.Default.Check)
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)*/

    }
}

@Preview
@Composable
fun PreviewItemHabit() {
    ItemHabit(text = "hola", action = { /*TODO*/ }, iconButton = Icons.Default.Clear)
}
