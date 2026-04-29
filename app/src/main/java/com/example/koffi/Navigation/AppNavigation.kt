package com.example.koffi.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.koffi.Screens.Cart.CartScreen
import com.example.koffi.Screens.Home.HomePage
import com.example.koffi.Screens.Menu.MenuScreen
import com.example.koffi.Screens.Product.ProductScreen
import com.example.koffi.Screens.Splash.SplashScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "splash_screen") {
        composable(AppNavigationItem.SplashScreen.route) {
            SplashScreen(navHostController)
        }
        composable(AppNavigationItem.HomeScreen.route) {
            HomePage(navHostController)
        }
        composable(AppNavigationItem.MenuScreen.route) {
            MenuScreen(navHostController)
        }
        composable(AppNavigationItem.ProductScreen.route) {
            ProductScreen(navHostController)
        }
        composable(AppNavigationItem.CartScreen.route) {
            CartScreen(navHostController)
        }
    }
}