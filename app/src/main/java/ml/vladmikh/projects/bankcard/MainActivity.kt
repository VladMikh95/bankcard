package ml.vladmikh.projects.bankcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ml.vladmikh.projects.bankcard.ui.theme.BankcardTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import dagger.hilt.android.AndroidEntryPoint
import ml.vladmikh.projects.bankcard.ui.card.CardScreen
import ml.vladmikh.projects.bankcard.ui.card.CardViewModel
import ml.vladmikh.projects.bankcard.ui.history.HistoryScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ml.vladmikh.projects.bankcard.ui.navigation.NavBarItems
import ml.vladmikh.projects.bankcard.ui.navigation.NavRoutes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import ml.vladmikh.projects.bankcard.ui.history.HistoryViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankcardTheme {
                BankCardApp(Modifier)
            }
        }
    }
}

@Composable
fun BankCardApp(
    modifier: Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                NavigationHost(modifier = modifier, navController = navController)
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                modifier = Modifier
            )
        }
    )
    
}

@Composable
fun NavigationHost(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Card.route,
    ) {
        composable(NavRoutes.Card.route) {
            val viewModel = hiltViewModel<CardViewModel>()
            CardScreen(modifier,viewModel)
        }

        composable(NavRoutes.History.route) {
            val viewModel = hiltViewModel<HistoryViewModel>()
            HistoryScreen(modifier,viewModel)
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController, modifier: Modifier = Modifier
) {

    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { screen ->

            NavigationBarItem(
                label = {
                    Text(text = screen.title)
                },
                icon = {
                    Icon(imageVector = screen.image, contentDescription = "")
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}




