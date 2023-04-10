package com.myra_winter.hiltblueprint.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.myra_winter.hiltblueprint.ui.navigation.BottomNavigationBar
import com.myra_winter.hiltblueprint.ui.navigation.HomeNavGraph

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}
