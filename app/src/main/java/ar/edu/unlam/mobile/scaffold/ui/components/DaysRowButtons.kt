package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DaysRowButtons() {
    /** TODO CAMBIAR LOS ICONOS */
    val fabItems = listOf(
        FABItem("Agregar", Icons.Default.Add, Color.Blue),
        FABItem("Editar", Icons.Default.Edit, Color.Green),
        FABItem("Eliminar", Icons.Default.Delete, Color.Red),
        FABItem("Editar", Icons.Default.Search, Color.Green),
        FABItem("Eliminar", Icons.Default.Delete, Color.Red),
        FABItem("Editar", Icons.Default.Edit, Color.Green),
        FABItem("Eliminar", Icons.Default.Delete, Color.Red),
    )

    LazyRow {
        items(fabItems) { item ->
            FloatingActionButton(
                onClick = { /* Acción del botón FAB */ },
                modifier = Modifier.padding(8.dp),
//                backgroundColor = item.color
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                )
            }
        }
    }
}

data class FABItem(val label: String, val icon: ImageVector, val color: Color)
