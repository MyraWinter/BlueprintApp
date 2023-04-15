package com.myra_winter.hiltblueprint.ui.navigation

import com.myra_winter.hiltblueprint.R

sealed class NavigationItem(
    val route: String,
    var page_icon: Int = R.drawable.ic_placeholder,
    var page_title: String? = null,
) {
    // Navigation when Unauthenticated
    object Login : NavigationItem(route = "Login")
    object SignUp : NavigationItem(route = "SignUp")
    object Forgot : NavigationItem(route = "Forgot")
    object Onboarding : NavigationItem(route = "Onboarding")

    // navigation when Authenticated -> Bottom Navigation Items
    object Home : NavigationItem(route = "Home", R.drawable.ic_home, "Home")
    object Api : NavigationItem(route = "Api", R.drawable.ic_book, "Api Call")
    object Settings : NavigationItem(route = "Settings", R.drawable.ic_settings, "Settings")
    object BookOverView : NavigationItem(route = "BookOverView", R.drawable.ic_book, "Overview")

    // navigation when Authenticated -> Detail Screens and more
    object BookDetails :
        NavigationItem(route = "BookDetails", R.drawable.ic_book_details, "Details")
}