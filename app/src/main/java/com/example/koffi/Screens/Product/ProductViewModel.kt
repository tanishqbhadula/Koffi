package com.example.koffi.Screens.Product

import androidx.lifecycle.ViewModel
import com.example.koffi.Models.Drink
import com.example.koffi.Screens.Menu.MenuCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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

class ProductViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProductUiState())
    val uiState = _uiState.asStateFlow()

    fun loadDrink(drinkId: String) {
        var drink: Drink? = null
        for(_drink in _drinks) {
            if((_drink.id).equals(drinkId)) drink = _drink
        }
        if(drink != null) {
            _uiState.value = ProductUiState(
                drink = drink,
                finalPrice = drink.price,
                isLoading = false
            )
        }
        else {
            // TODO()
        }
    }

    fun onSelectedSize(size: DrinkSizes) {
        val base = _uiState.value.drink?.price ?: return
        val price = when(size) {
            DrinkSizes.SMALL -> base
            DrinkSizes.MEDIUM -> base + 20.0
            DrinkSizes.LARGE -> base + 40.0
        }
        _uiState.value = _uiState.value.copy(
            selectedSize = size,
            finalPrice = price
        )
    }
}