package com.astro.paybills

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.data.SourceContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.astro.paybills.ui.detail.ProductHomeScreen
import com.astro.paybills.ui.home.DineInTakeOut
import com.astro.paybills.ui.theme.PaybillsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaybillsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier,context: Context) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dineInTakeout") {
        composable(
            route = "splitBill/{persons}/{amount}",
            arguments = listOf(
                navArgument("persons") { type = NavType.IntType },
                navArgument("amount") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val persons = backStackEntry.arguments?.getInt("persons") ?: 1
            val amount = backStackEntry.arguments?.getFloat("amount") ?: 1.0f

          //  SplitBill(navController = navController, persons = persons, amount = amount)
        }
        composable("productHomeScreen") { ProductHomeScreen(navController,context) }
        composable("dineInTakeout"){ DineInTakeOut(navController) }
    }

}

