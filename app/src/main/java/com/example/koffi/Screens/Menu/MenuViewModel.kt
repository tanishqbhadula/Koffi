package com.example.koffi.Screens.Menu

import androidx.lifecycle.ViewModel
import com.example.koffi.Models.Drink
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

val drinks = listOf(
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

class MenuViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MenuUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadMenu()
    }

    private fun loadMenu() {
        val drinks = drinks
        _uiState.value = uiState.value.copy(
            isLoading = false,
            items = drinks
        )
    }

    fun onCategorySelected(category: MenuCategory) {
        val allDrinks = drinks

        val filteredDrinks = when(category) {
            MenuCategory.ALL -> allDrinks
            else -> allDrinks.filter { it.categoryID == category }
        }
    }
}
