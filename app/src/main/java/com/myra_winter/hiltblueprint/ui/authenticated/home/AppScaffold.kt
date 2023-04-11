package com.myra_winter.hiltblueprint.ui.authenticated.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.myra_winter.hiltblueprint.ui.navigation.BottomNavigationBar
import com.myra_winter.hiltblueprint.ui.navigation.HomeNavGraph

@Composable
fun AppScaffold() {
    val navControllerApp = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navControllerApp) },
        content = { innerPadding ->
            HomeNavGraph(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                navController = navControllerApp
            )
        }
    )
}