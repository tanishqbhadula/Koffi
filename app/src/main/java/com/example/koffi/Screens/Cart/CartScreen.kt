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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .verticalScroll(scrollState)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(bgWhite, shape = RoundedCornerShape(4.dp))
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
                Spacer(modifier = Modifier.height(6.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, color = koffiBrown, shape = RoundedCornerShape(4.dp), )
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(bgWhite, shape = RoundedCornerShape(4.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Apply Coupons"
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