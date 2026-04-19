package com.example.koffi.Screens.Cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.koffi.ui.theme.bgCartGray
import com.example.koffi.ui.theme.bgSpecialGray
import com.example.koffi.ui.theme.bgWhite
import com.example.koffi.ui.theme.koffiBrown
import com.example.koffi.ui.theme.navBarWhite

@Preview
@Composable
fun CartScreen() {
    val scrollState = rememberScrollState()
    var qtyCount by remember { mutableIntStateOf(1) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(bgCartGray),
        topBar = {
            cartScreenTopAppBar(
                title = "Cart",
                onBackClick = {}
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RectangleShape,
                        ambientColor = DefaultShadowColor,
                        spotColor = DefaultShadowColor
                    )
                    .fillMaxWidth(),
                containerColor = bgWhite,
                contentColor = Color.Black,
                tonalElevation = BottomAppBarDefaults.ContainerElevation
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.padding(4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "1 Item",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black
                        )
                        Text(
                            text = "Rs. 248.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black
                        )
                    }
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = koffiBrown,
                            contentColor = bgWhite
                        )
                    ) {
                        Text(
                            text = "Place Order"
                        )
                    }
                }
            }
        }
    ) {
        innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(bgCartGray)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(bgCartGray)
                    .padding(horizontal = 12.dp, vertical = 14.dp)
                    .verticalScroll(scrollState)
            ) {
                // CART ITEMS
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(12.dp),
                            ambientColor = Color.Black.copy(alpha=0.4f),
                            spotColor = Color.Black.copy(alpha=0.4f)
                        )
                        .background(bgWhite, shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp)
                    ) {
                        // DRINK DETAILS
                        Column (
                            //horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(2.dp)
                                .weight(0.33f)
                        ) {
                            Text( // NAME
                                text = "Classic Americano",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text( // SIZE
                                text = "(SMALL)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        }
                        // QTY SELECTOR
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                                .weight(0.25f)
                        ) {
                            quantitySelector(
                                qty = qtyCount,
                                onQtyChange = {
                                    newCount -> qtyCount = newCount
                                }
                            )
                        }
                        // PRICE
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                        ) {
                            Text(
                                text = "199.00", // TODO(ADD PRICE OF DRINK PASSED FROM TAKEN STATE)
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                // APPLY COUPON BOX
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.3.dp,
                            color = koffiBrown,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(12.dp),
                            ambientColor = Color.Black.copy(alpha=0.4f),
                            spotColor = Color.Black.copy(alpha=0.4f)
                        )
                        .background(bgWhite, shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Coupons",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black
                        )
                        Text( // TODO(MAKE CLICKABLE)
                            text = "Apply",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal,
                            color = koffiBrown
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    thickness = 2.dp,
                    color = Color.Black.copy(alpha=0.1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                // BILL DETAILS BOX
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.border(1.5.dp, color = koffiBrown.copy(alpha=0.85f), shape = RoundedCornerShape(4.dp), )
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(12.dp),
                            ambientColor = Color.Black.copy(alpha=0.4f),
                            spotColor = Color.Black.copy(alpha=0.4f)
                        )
                        .background(bgWhite, shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                    ) {
                        Row( // bill details
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Bill Details:",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row( // item total
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Subtotal:",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                            Text(
                                text = "Rs. 199.00",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                        }
                        Row( // discount
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Discount:",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                            Text(
                                text = "- Rs. 0.00",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                        }
                        Row( // taxes
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Taxes:",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                            Text(
                                text = "Rs. 39.00",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                        }
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 2.dp, vertical = 4.dp),
                            thickness = 1.dp,
                            color = Color.Black.copy(alpha=0.5f)
                        )
                        Row( // total amt
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total:",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                            Text(
                                text = "Rs. 248.00",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Warning, contentDescription = "Cancellation Information")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Cancellation charges apply",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal
                    )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cartScreenTopAppBar(
    title: String,
    onBackClick: (()->Unit)? = null
) {
    TopAppBar( // TODO(TOPBAR IS EXPERIMENTAL)
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                fontStyle = FontStyle.Normal
            )
        },
        navigationIcon = {
            if(onBackClick != null) {
                IconButton( onClick = onBackClick ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = bgWhite
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = koffiBrown,
            titleContentColor = bgWhite
        )
    )
}

@Composable
fun quantitySelector(
    qty: Int,
    onQtyChange: (Int)->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .background(bgWhite, shape = RoundedCornerShape(24.dp))
            .border(1.dp, koffiBrown, RoundedCornerShape(24.dp))
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        // minus button
        IconButton(
            onClick = { if(qty > 1) onQtyChange(qty-1) },
            modifier = Modifier
                .size(22.dp)
                .weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Close, //TODO(UPDATE ICON TO MINUS [-])
                contentDescription = "decrease quantity",
                tint = if(qty>1) koffiBrown else Color.Gray
            )
        }
        // qty
        Text(
            text = qty.toString(),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        // plus button
        IconButton(
            onClick = { if(qty < 3) onQtyChange(qty+1) },
            modifier = Modifier
                .size(22.dp)
                .weight(1f)
//            colors = IconButtonDefaults.iconButtonColors(
//                containerColor = koffiBrown,
//                contentColor = bgWhite
//            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "increase quantity",
                tint = if(qty>1) koffiBrown else Color.Gray
            )
        }
    }
}