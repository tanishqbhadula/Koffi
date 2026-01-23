package com.example.koffi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.koffi.Screens.Home.HomePage
import com.example.koffi.Screens.Menu.MenuScreen
import com.example.koffi.Screens.Splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //SplashScreen()
            //HomePage()
            MenuScreen()
        }
    }
}
