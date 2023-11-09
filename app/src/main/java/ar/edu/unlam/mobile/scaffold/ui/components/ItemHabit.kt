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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.screens.PlannerViewModel
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue

@Composable
fun ItemHabit( //TODO pasar habito
    text: String,
    itemid: Long,
    iconButton: ImageVector,
    actionUpdate: () -> Unit
) {
    var icon = iconButton
    var isIcon1Selected by remember { mutableStateOf(true) }

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
                    color = CustomLightBlue,
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
                    color = CustomLightBlue,
                    shape = CircleShape,
                ),
            onClick = {
                if (icon !== Icons.Default.Delete) {
                    isIcon1Selected = !isIcon1Selected
                    actionUpdate()
                } else {
                    actionUpdate()
                }
            },
        ) {
            if (icon !== Icons.Default.Delete) {
                icon = if (isIcon1Selected) {
                    Icons.Default.Clear
                } else {
                    Icons.Default.Check
                }
            }
            Icon(icon, contentDescription = null)
        }
    }
}

// @Preview
// @Composable
// fun PreviewItemHabit() {
//    ItemHabit(text = "hola", iconButton = Icons.Default.Edit, viewModel = viewModel)
// }
