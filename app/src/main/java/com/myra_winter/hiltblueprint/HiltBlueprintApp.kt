package com.myra_winter.hiltblueprint

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * @HiltAndroidApp triggers Hilt's code generation, including a base class for the application
 * that serves as the application-level dependency container, needs to be the "name" in the
 * AndroidManifest
 */
@HiltAndroidApp
class HiltBlueprintApp : Application()