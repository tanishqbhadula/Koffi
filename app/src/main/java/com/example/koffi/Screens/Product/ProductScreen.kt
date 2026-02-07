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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koffi.Models.Drink
import com.example.koffi.R
import com.example.koffi.ui.theme.bgWhite

@Preview
@Composable
fun ProductScreen() {
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
                    onClick = {} //TODO(GO BACK TO PREV SCREEN)
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
                    text = "A classic Americano cocktail is a refreshing, low-ABV Italian aperitif made by combining 1–1.5 oz Campari and 1–1.5 oz sweet vermouth over ice in a rocks or highball glass, topped with a splash of soda water and garnished with an orange slice or twist. It is a lighter, bubbly, and less alcoholic variation of the Negroni. ",
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.Black
                )
            }
        }
    }
}