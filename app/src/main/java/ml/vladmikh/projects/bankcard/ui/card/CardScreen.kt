package ml.vladmikh.projects.bankcard.ui.card

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ml.vladmikh.projects.bankcard.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardScreen(
    modifier: Modifier = Modifier,
    viewModel: CardViewModel = viewModel()
) {
    Scaffold(){
       Column(
           modifier  =modifier
               .padding(16.dp)
       ) {
           Text(
               text = stringResource(R.string.card_instruction),
               textAlign = TextAlign.Center,
               style = typography.titleMedium
           )

           OutlinedTextField(
               value = viewModel.bin,
               onValueChange = { bin -> viewModel.updateBin(bin)},
               label = { Text(text = "00000000") },
               singleLine = true,
               modifier = Modifier.fillMaxWidth()
           )

           Button(modifier = modifier
               .fillMaxWidth()
               .padding(top = 12.dp),
               onClick = {
                   viewModel.getCardInfo()

               }) {
               Text(stringResource(R.string.lookup))
           }
       }
    }

}

@Preview()
@Composable
fun CardScreenPreview() {
    CardScreen()
}