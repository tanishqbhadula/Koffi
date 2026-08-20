package com.example.koffi.Screens.Cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.koffi.Navigation.AppNavigationItem

@Composable
fun EmptyCart(
    navHostController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Your cart is empty"
        )

        Text(
            text = "Looks like you haven't added anything yet."
        )

        Button(
            onClick = {
                navHostController.navigate(
                    AppNavigationItem.MenuScreen.route
                )
            }
        ) {
            Text("Browse Menu")
        }
    }
}