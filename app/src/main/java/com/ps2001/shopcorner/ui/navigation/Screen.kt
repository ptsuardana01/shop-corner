package com.ps2001.shopcorner.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailItem : Screen("home/{itemId}") {
        fun createRoute(itemId : Long) = "home/$itemId"
    }
}