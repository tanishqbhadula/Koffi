package com.example.koffi.Cart

import android.graphics.drawable.Drawable
import com.example.koffi.R
import com.example.koffi.Screens.Product.DrinkSizes

data class CartItem (
    val id: String,
    val name: String,
    val size: DrinkSizes,
    val quantity: Int,
    val price: Double,
    val imgRes: Int = R.drawable.koffi_logo
)