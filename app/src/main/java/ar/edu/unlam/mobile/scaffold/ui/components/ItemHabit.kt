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
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue

@Composable
fun ItemHabit(
    habit: Habit,
    iconButton: ImageVector,
    actionUpdate: () -> Unit,
) {
    var icon = iconButton
    var isIcon1Selected by remember { mutableStateOf(false) }

    isIcon1Selected = habit.state.toInt() == 0

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
                text = habit.name,
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
                    if (isIcon1Selected) {
                        isIcon1Selected = !isIcon1Selected
                        habit.state = 1 // tarea incompleta
                        actionUpdate()
                    } else {
                        isIcon1Selected = !isIcon1Selected
                        habit.state = 0 // tarea completada
                        actionUpdate()
                    }
                } else {
                    actionUpdate()
                }
            },
        ) {
            // TODO CAMBIAR COLOR AL ITEM SEGUN EL ESTADO
            if (icon !== Icons.Default.Delete) {
                icon = if (isIcon1Selected) {
                    Icons.Default.Check
                } else {
                    Icons.Default.Clear
                }
            }
            Icon(icon, contentDescription = null)
        }
    }
}
