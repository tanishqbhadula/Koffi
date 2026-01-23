package com.example.koffi.Models

import com.example.koffi.Screens.Menu.MenuCategory

data class Drink(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val categoryID: MenuCategory,
    val isRecommended: Boolean = false,
    val isPopular: Boolean = false
)
