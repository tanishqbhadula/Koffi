package com.example.koffi.widgets.FloatingNavBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.koffi.Navigation.AppNavigationItem
import com.example.koffi.ui.theme.bgWhite

@Composable
fun FloatingBottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp, end = 20.dp, bottom = 28.dp
            )
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(28.dp)
            ),
        shape = RoundedCornerShape(28.dp),
        color = bgWhite
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 6.dp),
             horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    // Home
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(
                onClick = {
                    navHostController.navigate(AppNavigationItem.MenuScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(
                onClick = {
                    // Search
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(
                onClick = {
                    navHostController.navigate(AppNavigationItem.CartScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(
                onClick = {
                    // Profile
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}