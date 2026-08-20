package com.example.koffi.Screens.Product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.koffi.Database.AppDatabase
import com.example.koffi.Database.Drink.DrinkEntity
import com.example.koffi.Repository.Cart.CartRepository
import com.example.koffi.Repository.Drink.DrinkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)

    private val drinkRepository = DrinkRepository(
        database.drinkDao()
    )

    private val cartRepository = CartRepository(
        database.cartDao()
    )

    private val _uiState = MutableStateFlow(ProductUiState())
    val uiState = _uiState.asStateFlow()

    fun loadDrink(drinkId: String) {

        viewModelScope.launch {

            val drinkEntity =
                drinkRepository.getDrinkById(drinkId)

            if (drinkEntity != null) {

                _uiState.value = ProductUiState(
                    drink = drinkEntity.toDrink(),
                    finalPrice = drinkEntity.price,
                    isLoading = false
                )

            } else {

                _uiState.value = _uiState.value.copy(
                    isLoading = false
                )
            }
        }
    }

    fun onSelectedSize(size: DrinkSizes) {

        val base = _uiState.value.drink?.price ?: return

        val price = when (size) {
            DrinkSizes.SMALL -> base
            DrinkSizes.MEDIUM -> base + 20.0
            DrinkSizes.LARGE -> base + 40.0
        }

        _uiState.value = _uiState.value.copy(
            selectedSize = size,
            finalPrice = price
        )
    }

    fun addToCart() {

        val state = _uiState.value
        val drink = state.drink ?: return

        viewModelScope.launch {

            cartRepository.addToCart(
                productId = drink.id,
                name = drink.name,
                size = state.selectedSize.name,
                price = state.finalPrice
            )
        }
    }
}

private fun DrinkEntity.toDrink(): com.example.koffi.Models.Drink {

    return com.example.koffi.Models.Drink(
        id = id,
        name = name,
        description = description,
        price = price,
        categoryID = when (category) {
            "HOT" -> com.example.koffi.Screens.Menu.MenuCategory.HOT
            "COLD" -> com.example.koffi.Screens.Menu.MenuCategory.COLD
            else -> com.example.koffi.Screens.Menu.MenuCategory.ALL
        },
        isRecommended = isRecommended,
        isPopular = isPopular
    )
}