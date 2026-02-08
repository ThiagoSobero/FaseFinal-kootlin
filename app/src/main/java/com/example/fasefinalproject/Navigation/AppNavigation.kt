package com.example.fasefinalproject.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fasefinalproject.ui.detail.DetailScreen
import com.example.fasefinalproject.ui.home.HomeScreen
import com.example.fasefinalproject.ui.login.LoginScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("detail/{id}") {
            DetailScreen()
        }
    }
}

