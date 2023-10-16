package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ListItemsHabits(items: List<String>, iconButton: ImageVector) {
    // TODO pasar lista de Habitos (crear model)
    LazyColumn {
        items(items) {
            ItemHabit("Habit", {}, iconButton)
        }
    }
}
