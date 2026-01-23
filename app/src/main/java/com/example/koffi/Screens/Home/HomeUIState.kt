package com.example.koffi.Screens.Home

import com.example.koffi.Models.Category
import com.example.koffi.Models.Drink

data class HomeUIState(
    val userName: String = "Guest User",
    val isDelivery: Boolean = true,
    val selectedCategoryID: String? = null,
    val categories: List<Category> = emptyList(),
    val drinks: List<Drink> = emptyList(),
    val popular: List<Drink> = emptyList(),
    val isLoading: Boolean = true
)
