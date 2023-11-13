package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview(showBackground = true)
@Composable
fun FilterByCategory(){
    var isDialogVisible by remember { mutableStateOf(false) }
    IconButton(
        modifier = Modifier
            .padding(6.dp),
        onClick = {isDialogVisible = true},
    ) {
        Icon(Icons.Default.ThumbUp, contentDescription = null)
    }
    if (isDialogVisible) {
        Dialog(
            onDismissRequest = {
                isDialogVisible = false
            },
            content = {
                Box(modifier = Modifier){
                    Row {
                        TextButton(onClick = { /*filtrar por eventos*/ }) {
                            Text(text = "Eventos")
                        }
                    }
                    Row {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Dedicados")
                        }
                    }
                    Row {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Simples")
                        }
                    }
                }
            })
    }
}
