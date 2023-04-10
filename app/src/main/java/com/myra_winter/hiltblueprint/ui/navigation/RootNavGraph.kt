package com.myra_winter.hiltblueprint.ui.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myra_winter.hiltblueprint.R
import com.myra_winter.hiltblueprint.data.repository.UserState
import com.myra_winter.hiltblueprint.ui.home.HomeScreen
import com.myra_winter.hiltblueprint.ui.onboarding.OnboardingScreen

sealed class NavigationItem(val route: String,    var page_icon: Int = R.drawable.ic_placeholder,
                            var page_title: String? = null) {
    object Login : NavigationItem(route = "LOGIN")
    object SignUp : NavigationItem(route = "SIGN_UP")
    object Forgot : NavigationItem(route = "FORGOT")
    object Information : NavigationItem(route = "INFORMATION")
    object Overview : NavigationItem(route = "OVERVIEW")
    object Onboarding : NavigationItem(route = "onboarding")
    object Home : NavigationItem(route = "HOME", page_title = "HOME", page_icon = R.drawable.ic_home)
    object Settings : NavigationItem(route = "SETTINGS", page_title = "SETTINGS", page_icon = R.drawable.ic_settings)
    class Books {
        object Overview : NavigationItem(route = "Overview", page_icon = R.drawable.ic_book, page_title = "Overview")
        object Details : NavigationItem(route = "book_details", page_icon = R.drawable.ic_book_details, page_title = "Details")
    }
}

@Composable
fun RootNavigationGraph(navController: NavHostController, startdest: UserState) {
    NavHost(
        navController = navController,
        startDestination = if(startdest == UserState.ONBOARDING) NavigationItem.Onboarding.route else NavigationItem.Home.route
    ) {

        Log.d("LOGGER", " " + startdest)
        composable(route = NavigationItem.Onboarding.route) { Log.d("LOGGER", "destination: " + it.destination )
            OnboardingScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(NavigationItem.Home.route)
                },
                onSignUpClick = { navController.navigate(NavigationItem.SignUp.route) }
            ) { navController.navigate(NavigationItem.Forgot.route) }
        }
        composable(route = NavigationItem.SignUp.route) { Log.d("LOGGER", "destination: " + it.destination )
            ScreenContent(name = NavigationItem.SignUp.route) {}
        }
        composable(route = NavigationItem.Forgot.route) { Log.d("LOGGER", "destination: " + it.destination )
            ScreenContent(name = NavigationItem.Forgot.route) {}
        }
        composable(route = NavigationItem.Home.route) { Log.d("LOGGER", "destination: " + it.destination )
            HomeScreen()
        }
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(route = NavigationItem.Home.route) { Log.d("LOGGER", "destination: " + it.destination)
            ScreenContent(name = NavigationItem.Home.route, onClick = { navController.navigate(NavigationItem.Information.route) })
        }
        composable(route = NavigationItem.Settings.route) { Log.d("LOGGER", "destination: " + it.destination)
            ScreenContent(name = NavigationItem.Settings.route, onClick = { })
        }
        composable(route = NavigationItem.Information.route) { Log.d("LOGGER", "destination: " + it.destination)
            ScreenContent(name = NavigationItem.Information.route) { navController.navigate(NavigationItem.Overview.route) }
        }
        composable(route = NavigationItem.Overview.route) { Log.d("LOGGER", "destination: " + it.destination)
            ScreenContent(name = NavigationItem.Overview.route) { navController.popBackStack(route = NavigationItem.Information.route, inclusive = false) }
        }
    }
}

// TODO delete this placeholder class
@Composable
fun ScreenContent(name: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = name,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}