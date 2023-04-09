package com.myra_winter.hiltblueprint.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.navigation.compose.composable
import com.myra_winter.hiltblueprint.ui.home.HomeScreen
import com.myra_winter.hiltblueprint.ui.onboarding.OnboardingScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = NavigationItem.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = NavigationItem.Home.route) {
            // TODO here will be the unauthenticated flow ~ or I will change the Boolean to something else
            HomeScreen()
        }
        authenticatedNavigation(modifier = Modifier, navController = navController)
    }
}