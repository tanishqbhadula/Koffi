package com.example.koffi.Screens.Splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.koffi.Navigation.AppNavigation
import com.example.koffi.Navigation.AppNavigationItem
import com.example.koffi.R
import com.example.koffi.ui.theme.bgWhite
import kotlinx.coroutines.delay

//@Preview
@Composable
fun SplashScreen(navHostController: NavHostController) {
    Scaffold (
        containerColor = bgWhite,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = bgWhite)
        ) {
            Image(
                painterResource(id = R.drawable.koffi_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
    }
    LaunchedEffect(Unit) {
        delay(2500)
        navHostController.navigate(AppNavigationItem.HomeScreen.route) {
            popUpTo(AppNavigationItem.SplashScreen.route) {
                inclusive = true
            }
        }
    }
}