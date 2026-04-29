package com.example.koffi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.koffi.Navigation.AppNavigation
import com.example.koffi.Screens.Cart.CartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //CartScreen(navHostController)
            val navHostController = rememberNavController()
            AppNavigation(navHostController)
        }
    }
}
