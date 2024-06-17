package com.example.socialdesign.ui.Utils

import com.example.socialdesign.R

open class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItem("home", R.drawable.outline_home_24, "Home")
    object Search : NavigationItem("search", R.drawable.outline_search_24, "Search")
    object Add: NavigationItem( "add",R.drawable.baseline_add_circle_outline_24,"Add")
    object Activities : NavigationItem("activities",R.drawable.baseline_favorite_border_24,"Activities")
    object Profile: NavigationItem("profile", R.drawable.baseline_person_outline_24,"Profile")
}
