package com.example.koffi.Screens.Product

import com.example.koffi.Models.Drink

data class ProductUiState(
    val drink: Drink? = null,
    val selectedSize: DrinkSizes = DrinkSizes.MEDIUM,
    val isIced: Boolean = false,
    val finalPrice: Double = 0.0,
    val isLoading: Boolean = true
)