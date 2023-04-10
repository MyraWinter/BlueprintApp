package com.myra_winter.hiltblueprint.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.navigation.compose.composable
import com.myra_winter.hiltblueprint.ui.books.BookScreen
import com.myra_winter.hiltblueprint.ui.home.HomeScreen
import com.myra_winter.hiltblueprint.ui.onboarding.OnboardingScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun RootNavigationGraph(navController: NavHostController, startDestination: String
) {
    NavHost(navController = navController, startDestination = NavigationItem.Onboarding.route) {
        composable(route = NavigationItem.Onboarding.route) { OnboardingScreen(navController = navController) }
        composable(route = NavigationItem.Home.route) { HomeScreen() }
    }
}
@Composable
fun HomeNavGraph (navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeScreen(navController) }
        composable(NavigationItem.Books.Overview.route) { BookScreen(navController = navController) }
        composable(NavigationItem.Settings.route) { BookScreen (navController = navController) }
    }
}