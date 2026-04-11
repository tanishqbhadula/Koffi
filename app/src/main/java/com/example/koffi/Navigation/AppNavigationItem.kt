package com.example.koffi.Navigation

sealed class AppNavigationItem(val route: String) {
    object SplashScreen: AppNavigationItem(route = "splash_screen")
    object HomeScreen: AppNavigationItem(route = "home_screen")
    object MenuScreen: AppNavigationItem(route = "menu")
    object ProductScreen: AppNavigationItem(route = "product_screen")
    //object CartScreen: AppNavigationItem(route = "cart_screen")
}