package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit

@Composable
fun ListItemsHabits(items: List<Habit>, iconButton: ImageVector) {
    LazyColumn {
        items(items.size) {
            item-> ItemHabit(items[item].name, {}, iconButton)
        }
    }
}
