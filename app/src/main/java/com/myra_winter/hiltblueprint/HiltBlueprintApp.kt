package com.myra_winter.hiltblueprint

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * @HiltAndroidApp triggers Hilt's code generation, including a base class for the application
 * that serves as the application-level dependency container
 *
 * https://www.youtube.com/watch?v=6dRwaXH2cYA -> https://github.com/stevdza-san/OnBoardingCompose
 * */
@HiltAndroidApp
class HiltBlueprintApp : Application()