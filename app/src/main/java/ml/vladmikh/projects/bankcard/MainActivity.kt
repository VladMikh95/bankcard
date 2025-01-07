package ml.vladmikh.projects.bankcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ml.vladmikh.projects.bankcard.ui.theme.BankcardTheme
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import ml.vladmikh.projects.bankcard.ui.card.CardScreen
import ml.vladmikh.projects.bankcard.ui.card.CardViewModel
import ml.vladmikh.projects.bankcard.ui.history.HistoryScreen
import androidx.hilt.navigation.compose.hiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankcardTheme {
                BankCardApp()
            }
        }
    }
}

@Composable
fun BankCardApp() {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavHost(navController, startDestination = NavRoutes.Card.route) {
            composable(NavRoutes.Card.route) {
                val viewModel = hiltViewModel<CardViewModel>()
                CardScreen(viewModel) }
            composable(NavRoutes.History.route) { HistoryScreen()  }

        }
        NavBar(navController = navController)
    }
    
}

@Composable
fun NavBar(navController: NavController){
    Row(
        Modifier.fillMaxWidth().padding(bottom = 8.dp)){
        Text("Card",
            Modifier
                .weight(0.5f)
                .clickable { navController.navigate(NavRoutes.Card.route) }, fontSize = 22.sp, color= Color(0xFF6650a4)
        )
        Text("History",
            Modifier
                .weight(0.5f)
                .clickable { navController.navigate(NavRoutes.History.route) }, fontSize = 22.sp, color= Color(0xFF6650a4))
    }
}


sealed class NavRoutes(val route: String) {
    object Card : NavRoutes("card")
    object History : NavRoutes("history")

}



