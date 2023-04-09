package com.myra_winter.hiltblueprint.ui.navigation

import com.myra_winter.hiltblueprint.R

sealed class NavigationItem(
    var bottom_route: String? = null,
    var route: String,
    var page_icon: Int? = null,
    var page_title: String? = null
) {

    object Onboarding : NavigationItem(route = "onboarding")

    object Home :
        NavigationItem(
            bottom_route = "home", route = "Home",
            page_icon = R.drawable.ic_home, page_title = "Home"
        )

    object Settings :
        NavigationItem(
            bottom_route = "settings", route = "Movies",
            page_icon = R.drawable.ic_settings, page_title = "Movies"
        )

    class Books {
        object Overview : NavigationItem(
            bottom_route = "book_overview", route = "Overview",
            page_icon = R.drawable.ic_book, page_title = "Overview"
        )

        object Details : NavigationItem(
            route = "book_details", page_icon = R.drawable.ic_book_details, page_title = "Details"
        )
    }
}
