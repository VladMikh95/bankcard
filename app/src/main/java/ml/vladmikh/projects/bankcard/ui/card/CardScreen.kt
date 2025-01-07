package ml.vladmikh.projects.bankcard.ui.card

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        Text("Card screen")
    }

}

@Preview()
@Composable
fun CardScreenPreview() {
    CardScreen()
}