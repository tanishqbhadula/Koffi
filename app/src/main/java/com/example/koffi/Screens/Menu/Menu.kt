package com.example.koffi.Screens.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koffi.Models.Drink
import com.example.koffi.ui.theme.bgWhite
import com.example.koffi.ui.theme.koffiBrown

val _drinks = listOf(
    Drink(
        id = "americano_classic",
        name = "Classic Hot Americano",
        description = "Classic Hot Americano",
        price = 179.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "cold_brew_classic",
        name = "Classic Cold Brew",
        description = "Classic Cold Brew",
        price = 199.00,
        categoryID = MenuCategory.COLD,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "espresso_double_shot",
        name = "Double Shot Espresso",
        description = "Double Shot Espresso",
        price = 159.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "espresso_triple_shot",
        name = "Triple Shot Espresso",
        description = "Triple Shot Espresso",
        price = 169.00,
        categoryID = MenuCategory.HOT,
        isRecommended = false,
        isPopular= false
    ),
    Drink(
        id = "classsic_latte_hot",
        name = "Classic Hot Latte",
        description = "Classic Hot Latte",
        price = 219.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "classsic_mocha",
        name = "Classic Mocha",
        description = "Classic Mocha",
        price = 239.00,
        categoryID = MenuCategory.COLD,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "classsic_latte_hot",
        name = "Classic Hot Latte",
        description = "Classic Hot Latte",
        price = 219.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "classsic_latte_hot",
        name = "Classic Hot Latte",
        description = "Classic Hot Latte",
        price = 219.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    ),
    Drink(
        id = "classsic_latte_hot",
        name = "Classic Hot Latte",
        description = "Classic Hot Latte",
        price = 219.00,
        categoryID = MenuCategory.HOT,
        isRecommended = true,
        isPopular= false
    )
)
@Composable
fun MenuRoute(
        viewModel: MenuViewModel,
        onItemClick: (String) -> Unit
    ) {
    val uiState by viewModel.uiState.collectAsState()
//    Menu(
//        uiState = uiState,
//        onCategorySelected = viewModel::onCategorySelected,
//        onItemClick = onItemClick
//    )
}

//@Preview
//@Composable
//fun Menu(
//    uiState: MenuUiState,
//    onCategorySelected: (MenuCategory) -> Unit,
//    onItemClick: (String) -> Unit
//) {
//
//}

@Preview
@Composable
fun MenuScreen() {
    val scrollState = rememberScrollState()
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(bgWhite)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(bgWhite)
        ) {
            Column ( // PARENT COL WITH SCROLL
                modifier = Modifier
                    .fillMaxSize()
                    .background(bgWhite)
                    //.verticalScroll(scrollState)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(koffiBrown)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                                ambientColor = DefaultShadowColor,
                                spotColor = DefaultShadowColor
                            )

                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "back",
                                    tint = bgWhite,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            Text(
                                text = "our MENU",
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 12.dp),
                                fontSize = 22.sp,
                                color = bgWhite,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Default,
                                letterSpacing = 2.sp
                            )
                        }
                    }
                }
                // START MENU HERE
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    MenuCategoryRow(
                        categories = MenuCategory.entries,
                        selected = MenuCategory.ALL,
                        onCategorySelected = {}
                    )
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(_drinks) { drink->
                            MenuItemCard(
                                drink = drink,
                                onClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}