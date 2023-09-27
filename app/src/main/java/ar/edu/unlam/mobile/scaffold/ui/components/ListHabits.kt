package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun ListItemsHabits(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            ItemHabito()
        }
    }

}