package com.example.koffi.Screens.Menu

import com.example.koffi.Models.Drink

data class MenuUiState (
    val isLoading: Boolean = true,
    val selectedCategory: MenuCategory = MenuCategory.ALL,
    val categories: List<MenuCategory> = MenuCategory.values().toList(),
    val items: List<Drink> = emptyList()
)

//enum class MenuCategory {
//    ALL, HOT, COLD, FOOD, DRINK, SEASONAL
//}
