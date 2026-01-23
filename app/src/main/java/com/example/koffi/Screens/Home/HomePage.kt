package com.example.koffi.Screens.Home

import android.text.Layout.Alignment
import androidx.annotation.OpenForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import com.example.koffi.Models.Drink
import com.example.koffi.R
import com.example.koffi.Screens.Menu.MenuCategory
import com.example.koffi.ui.theme.KoffiTheme
import com.example.koffi.ui.theme.bgSpecialGray
import com.example.koffi.ui.theme.bgWhite
import com.example.koffi.ui.theme.koffiBrown
import com.example.koffi.ui.theme.navBarWhite

@Preview
@Composable
fun HomePage() {
    val scrollState = rememberScrollState()
    // PROFILE ICON NOT A PART OF SCAFFOLD, ADD IT AS A PART OF ROW MOST ROW WITH APP LOGO(OPTIONAL MAYBE IDK) AS WE DONT WANT TO BE FIXED
    var searchBarText by remember { mutableStateOf("") }
    var searchBarActive by remember { mutableStateOf(false) }
    val baristaPicks = listOf(
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
        )
    )
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                containerColor = koffiBrown,
                contentColor = bgWhite,
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "profile")
            }
        },
        containerColor = bgWhite,
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar (
                modifier = Modifier
                    .shadow(
                        elevation = 10.dp,
                        shape = RectangleShape,
                        ambientColor = DefaultShadowColor,
                        spotColor = DefaultShadowColor
                    )
                    .fillMaxWidth(),
                containerColor = navBarWhite,
                contentColor = Color.Black,
                tonalElevation = BottomAppBarDefaults.ContainerElevation
            ) {
                // TODO -> HIGHLIGHT WHICHEVER TAB IS CURRENTLY OPEN
                IconButton(onClick = {}) { // HOME - HOME ICON
                    Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) { // OFFERS - SMILE FACE
                    Icon(imageVector = Icons.Default.Face, contentDescription = "offers")
                }
                Spacer(Modifier.weight(1f))
                IconButton( // ORDER - CIRCLE PLUS ICON
                    onClick = { },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = koffiBrown, contentColor = bgWhite, disabledContentColor = koffiBrown, disabledContainerColor = bgWhite)
                ) {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = "order")
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) { // FAVORITES - STAR ICON
                    Icon(imageVector = Icons.Default.Star, contentDescription = "favs")
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) { // CART - SHOPPING CART ICON
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "favs")
                }
            }
        }
    ){
        innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(bgWhite)
                .fillMaxSize()
        ) {
            // OLD BG BROWN BOX, USED TO BE STATIC, NOW ATTACHED TO TOP PART, CAN DELETE SAFELY
//            Box(
//                modifier = Modifier
//                    //.verticalScroll(scrollState)
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .background(
//                        color = bgSpecialGray,
//                        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
//                    )
//            ) {
//                Image(
//                   painterResource(id = R.drawable.homepagebg),
//                   contentDescription = "background home page coffee",
//                   modifier = Modifier.fillMaxSize()
//                )
//            }
            Column (
                modifier = Modifier
                    //.padding(start = 15.dp, end = 15.dp)
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .verticalScroll(scrollState)
            ) {

                // -- <TEST> -- [NOW FINAL]

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box( // brown bg
                        modifier = Modifier
                            //.verticalScroll(scrollState)
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(
                                color = koffiBrown,
                                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                            )
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                                ambientColor = DefaultShadowColor,
                                spotColor = DefaultShadowColor
                            )
                    )
                    Column( // inner col insdie brown box
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                            //.fillMaxHeight(0.4f)
                            .background(color = Color.Transparent)
                            .padding(start = 2.dp, end = 2.dp, top = 4.dp, bottom = 12.dp)
                    ) {
                        Row( // ICON + PROFILE ICON ROW
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.1f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Image(
                                painterResource(id = R.drawable.koffi_logo),
                                modifier = Modifier.size(50.dp),
                                contentDescription = "logo"
                            )
                            //Spacer(Modifier.fillMaxWidth())
                            IconButton(
                                modifier = Modifier.fillMaxHeight(),
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "profile"
                                )
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        // greeting + quote
                        // TODO -> FIGURE OUT CENTRE ALIGN TEXT PROB
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.Center

                            ) { // ADD USERNAME FROM CUSTOMER PROFILE
                                //Box(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    // TODO -> GREETING ACC TO DEVICE TIME
                                    text = "Good Morning, username",
                                    fontWeight = FontWeight.Bold,
                                    color = bgWhite,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "Sip coffee, create memories",
                                    fontWeight = FontWeight.ExtraBold,
                                    color = bgWhite,
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily.Cursive
                                )
                                //}
                            }
                        }
                        Spacer(Modifier.height(10.dp))

                        // SEARCH BAR
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            koffiSearchBar(
                                text = searchBarText,
                                onTextChange = { searchBarText = it },
                                onSearch = {
                                    searchBarActive = false
                                    println("searching for: $searchBarText")
                                },
                                onCloseClick = {
                                    searchBarText = ""
                                    searchBarActive = false
                                },
                                active = searchBarActive,
                                modifier = Modifier.padding(top = 16.dp)
                            )
                        }
                        // -- END OF BROWN BOX AREA --
                    }
                } // BOX END

                // -- </TEST> -- [NOW FINAL]

                // WHATS MOOD TODAY + CARDS
                // TODO -> MAKE IT INTO A LIST NOT INDIVISUAL BOXES (MAYBE IDK)
                Box (
                    modifier = Modifier
                        .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .background(Color.Transparent)
                ) {
                    // TODO -> DIFF MOOD cards, EACH CARD HAS ICON, MOOD TEXT, SUBTITLE -> EG ENERGIZED/GYM(STRONG BREW), DATE/ROMANTIC(LATTES AND MOCHAS), RELAXED(SMOOTH & CREAMY) so on
                    // TODO -> TRY A 2X2 GRID FOR mood CARDS
                    Text(
                        text = "Whats the mood today?",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Default,
                        fontSize = 22.sp
                    )
                }
                Spacer(Modifier.height(4.dp))
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Card 1"
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Card 2"
                        )
                    }
                }
                Spacer(Modifier.height(12.dp)) 
                // FRESH CURATIONS AREA
                Box (
                    modifier = Modifier
                        .background(color = bgSpecialGray)
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 6.dp, top = 1.dp, bottom = 1.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .background(Color.Transparent)
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "Fresh Curations",
                            fontSize = 22.sp,
                            color = koffiBrown,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Default
                            //letterSpacing = 2.sp
                        )
                        Spacer(Modifier.height(2.dp))
                        // 3X2 GRID
                        Row ( // ROW 1 -> bold brews, bestsellers, drinks
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Column ( // 1. BOLD BREWS
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "bold brews"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Bold Brews",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                            Column ( // 2. BestSellers (aka money machines)
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "bestsellers"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Bestsellers",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                            Column ( // 3. DRINKS - opens menu with filter of drinks only
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "drinks"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Drinks",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                        }
                        Row ( // ROW 2 -> food, seasonal spl, brew at home
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Column ( // 4. food
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "food"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Food",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                            Column ( // 5. Seasonal spl
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "seasonal specials"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Seasonal Specials",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                            Column ( // 3. Brew at home kit
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.koffi_logo),
                                    contentDescription = "brew at home kit"
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Brew at Home",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Default
                                )
                            }
                        }
                    }
                }
                // NEWLY ADDED DRINKS/ITEMS -> Lazy row
                // RECOMMENDATIONS -> LAZY ROW
                // BUTTON TO VIEW FULL MENU
                // END WITH QUOTE/IMAGE/TAG LINE
                Box ( // RECOMMENDATIONS
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, bottom = 6.dp, start = 6.dp, end = 6.dp)
                ) {
                    //Spacer(Modifier.height(12.dp))
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Barista Picks for YOU",
                            fontSize = 20.sp,
                            color = koffiBrown,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Default
                        )
                        LazyRow (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 6.dp)
                        ) {
                            items(baristaPicks) { picks ->
                                if(picks.isRecommended) {
                                    Card(
                                        // TODO -> FIX SIZING
                                        modifier = Modifier
                                            .size(100.dp)
                                            .padding(vertical = 16.dp, horizontal = 6.dp)
                                        ,
                                        shape = RoundedCornerShape(12.dp),
                                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
                                    ) {
                                        displayPicks(picks = picks)
                                    }
                                }
                            }
                        }
                    }
                }
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                ) {
                    Button(
                        onClick = {},
                        //shape = ButtonDefaults.shape(RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = bgWhite)
                    ) {
                        Text(
                            text = "Explore our full Menu",
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Default,
                            color = bgWhite
                        )
                    }
                }
                Box (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(horizontal = 40.dp, vertical = 16.dp)
                        ,
                        thickness = 2.dp,
                        color = Color.LightGray.copy(alpha = 0.5f)
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 6.dp, bottom = 6.dp, end = 4.dp)
                ) {
                    Text(
                        text = "Sip Coffee",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Black,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "Create Memories",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Black,
                        fontSize = 44.sp
                    )
                }
            }
        }
    }
}

@Composable
fun koffiSearchBar(
    text: String,
    onTextChange: (String)->Unit,
    onSearch: ()->Unit,
    onCloseClick: ()->Unit,
    modifier: Modifier = Modifier,
    active: Boolean
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .fillMaxWidth(1f)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = Color.Black.copy(alpha = 0.6f),
                    ambientColor = Color.Black.copy(alpha = 0.5f)
                )
//                .border(
//                    border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
//                    shape = RoundedCornerShape(10.dp)
//                )
            ,
            placeholder = {
                Text(text = "What would you like...", color = Color.Gray)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            },
            trailingIcon = {
                if(active) {
                    Icon(
                        modifier = Modifier.clickable { onCloseClick() },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() })
        )
    }
}

// TODO -> HOVERING ON DRINKS DISPLAYS A BOX WITH {DRINK.DESCRIPTION}
@Composable
fun displayPicks(picks : Drink) {
    Box (
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 5.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                painterResource(id = R.drawable.koffi_logo),
                contentDescription = "bold brews"
            )
            Spacer(Modifier.height(4.dp))
            Text(text = picks.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}