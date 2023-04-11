package com.myra_winter.hiltblueprint.ui.navigation

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
import androidx.navigation.compose.rememberNavController
import com.myra_winter.hiltblueprint.R
import com.myra_winter.hiltblueprint.ui.authenticated.books.BookScreen
import com.myra_winter.hiltblueprint.ui.authenticated.home.AppScaffold
import com.myra_winter.hiltblueprint.ui.authenticated.home.HomeScreen
import com.myra_winter.hiltblueprint.ui.unauthenticated.signUp.ForgotPasswordScreen
import com.myra_winter.hiltblueprint.ui.unauthenticated.signUp.LoginScreen
import com.myra_winter.hiltblueprint.ui.unauthenticated.signUp.SignUpScreen
import com.myra_winter.hiltblueprint.ui.unauthenticated.signUp.onboarding.OnboardingScreen

sealed class NavigationItem(
    val route: String, var page_icon: Int = R.drawable.ic_placeholder,
    var page_title: String? = null
) {
    // Navigation when Unauthenticated
    object Login : NavigationItem(route = "Login")
    object SignUp : NavigationItem(route = "SignUp")
    object Forgot : NavigationItem(route = "Forgot")
    object Onboarding : NavigationItem(route = "Onboarding")

    // navigation when Authenticated -> Bottom Navigation Items
    object Home : NavigationItem(route = "Home", R.drawable.ic_home, "Home")
    object Settings : NavigationItem(route = "Settings", R.drawable.ic_settings, "Settings")
    object BookOverView : NavigationItem(route = "BookOverView", R.drawable.ic_book, "Overview")

    // navigation when Authenticated -> Other elements
    object BookDetails :
        NavigationItem(route = "BookDetails", R.drawable.ic_book_details, "Details")
}

@Composable
fun RootNavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // unauthenticated Navigation
        composable(route = NavigationItem.Onboarding.route) {
            OnboardingScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(NavigationItem.SignUp.route)
                })
        }
        composable(route = NavigationItem.Login.route) {
            LoginScreen(
                onLoginClick = { navController.navigate(NavigationItem.Home.route) },
                onSignUpClick = { navController.navigate(NavigationItem.SignUp.route) },
                onForgotClick = { navController.navigate(NavigationItem.Forgot.route) }
            )
        }
        composable(route = NavigationItem.SignUp.route) {
            SignUpScreen(onClick = {
                navController.popBackStack()
                navController.navigate(NavigationItem.Home.route)
            })
        }
        composable(route = NavigationItem.Forgot.route) {
            ForgotPasswordScreen()
        }
        // move to authenticated Navigation
        composable(route = NavigationItem.Home.route) {
            AppScaffold()
        }
    }
}

@Composable
fun HomeNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(modifier = modifier) {
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route
        ) {
            composable(route = NavigationItem.Home.route) {
                HomeScreen()
//            ScreenContent(
//                name = NavigationItem.Home.route,
//                onClick = { }) // { navController.navigate(NavigationItem.Information.route) })
            }
            composable(route = NavigationItem.BookOverView.route) {
                BookScreen()
            }
            composable(route = NavigationItem.Settings.route) {
                ScreenContent(name = NavigationItem.Settings.route, onClick = { })
            }
//        composable(route = NavigationItem.Overview.route) {
//            ScreenContent(name = NavigationItem.Overview.route) {
//                navController.popBackStack(route = NavigationItem.Information.route, inclusive = false)
//            }
//        }
        }
    }
}

// TODO delete this placeholder fun
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