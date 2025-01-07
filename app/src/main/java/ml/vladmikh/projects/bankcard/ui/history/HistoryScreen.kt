package ml.vladmikh.projects.bankcard.ui.history

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HistoryScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        Text("History screen")
    }
}

@Preview
@Composable
fun HistoryScreenPreview() {
    HistoryScreen()
}