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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R

@Preview
@Composable
fun DaysRowButtons() {
    /** TODO CAMBIAR LOS ICONOS */
    val fabItems = listOf(
        FABItem("Lunes", ImageVector.vectorResource(id = R.drawable.ic_letra_l)),
        FABItem("Martes", ImageVector.vectorResource(id = R.drawable.ic_letra_m)),
        FABItem("Miercoles", ImageVector.vectorResource(id = R.drawable.ic_letra_m)),
        FABItem("Jueves", ImageVector.vectorResource(id = R.drawable.ic_letra_j)),
        FABItem("Viernes", ImageVector.vectorResource(id = R.drawable.ic_letra_v)),
        FABItem("Sabado", ImageVector.vectorResource(id = R.drawable.ic_letra_s)),
        FABItem("Domingo", ImageVector.vectorResource(id = R.drawable.ic_letra_d)),
    )

    LazyRow {
        items(fabItems) { item ->
            FloatingActionButton(
                onClick = { /* Acción del botón FAB */ },
                modifier = Modifier.padding(8.dp),
                containerColor = Color.White,
                shape = androidx.compose.foundation.shape.CircleShape,
//                backgroundColor = item.color
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = colorResource(id = R.color.color1),
                )
            }
        }
    }
}

data class FABItem(val label: String, val icon: ImageVector)
