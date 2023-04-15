package com.myra_winter.hiltblueprint

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.myra_winter.hiltblueprint.ui.navigation.RootNavigationGraph
import com.myra_winter.hiltblueprint.ui.splashscreen.HiltBlueprintViewModel
import com.myra_winter.hiltblueprint.ui.theme.HiltBlueprintTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *
 */
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class HiltBlueprintActivity : ComponentActivity() {

    @Inject
    lateinit var hiltBlueprintViewModel: HiltBlueprintViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen() //.setKeepOnScreenCondition { !hiltBlueprintViewModel.isLoading.value }

        setContent {
            HiltBlueprintTheme {
                val startDestination by hiltBlueprintViewModel.startDestination
                Log.d("ACTIVITY", startDestination)
                RootNavigationGraph(startDestination = startDestination)
            }
        }
    }
}
