package ml.vladmikh.projects.bankcard.ui.card

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CardScreen(
    viewModel: CardViewModel = viewModel()
) {
    viewModel.getCardInfoRemoteDataSource()
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