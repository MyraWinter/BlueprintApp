package com.myra_winter.hiltblueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.myra_winter.hiltblueprint.ui.navigation.RootNavGraph
import com.myra_winter.hiltblueprint.ui.splashscreen.SplashViewModel
import com.myra_winter.hiltblueprint.ui.theme.HiltBlueprintTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class HiltBlueprintActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        setContent {
            HiltBlueprintTheme {
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                RootNavGraph(navController = navController, startDestination = screen)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiltBlueprintTheme {

    }
}