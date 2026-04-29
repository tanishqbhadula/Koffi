package com.example.koffi.Screens.Product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.koffi.Navigation.AppNavigation
import com.example.koffi.Navigation.AppNavigationItem
import com.example.koffi.R
import com.example.koffi.Screens.Menu.MenuRoute
import com.example.koffi.ui.theme.bgWhite
import com.example.koffi.ui.theme.koffiBrown

//@Preview
@Composable
fun ProductScreen(navHostController: NavHostController) {
//fun ProductScreen() {
    val scrollstate = rememberScrollState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(bgWhite)
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
                .background(bgWhite)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollstate)
            ) {
                IconButton(
                    onClick = {
                        //navHostController.navigate(AppNavigationItem.MenuScreen.route) {
//                            popUpTo(AppNavigationItem.ProductScreen.route) {
//                                inclusive = true
//                            }
                            navHostController.popBackStack()
                        //}
                    } //TODO(POP CURR SCREEN AND GO BACK TO EXISTING STATE OF MENU)

                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close screen",
                        tint = Color.Black,
                        modifier = Modifier.fillMaxSize(1f)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        //.fillMaxWidth()
                        .background(bgWhite, RoundedCornerShape(8.dp))
                        .shadow(
                            elevation = 12.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Image(
                        painterResource(id = R.drawable.koffi_logo),
                        contentDescription = "drink logo"
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Classic Americano",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    fontFamily = FontFamily.Default
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rs 299.0",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(18.dp))
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Description",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Classic Americano coffee, is an espresso shot with hot water at a 1:3 to 1:4 ratio, resulting in a drink that retains the complex flavors of espresso, but in a lighter way. Its strength varies with the number of shots of espresso and the amount of water added.",
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(18.dp))
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(18.dp))
                Button(
                    onClick = {
                        navHostController.navigate(AppNavigationItem.CartScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonColors(
                        contentColor = bgWhite,
                        containerColor = koffiBrown,
                        disabledContentColor = bgWhite,
                        disabledContainerColor = koffiBrown
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Add to Cart",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
            }
        }
    }
}