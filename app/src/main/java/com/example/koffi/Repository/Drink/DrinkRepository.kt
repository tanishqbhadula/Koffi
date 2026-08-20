package com.example.koffi.Repository.Drink

import com.example.koffi.Database.Drink.DrinkDao
import com.example.koffi.Database.Drink.DrinkEntity
import kotlinx.coroutines.flow.Flow

class DrinkRepository(
    private val drinkDao: DrinkDao
) {
    fun getAllDrinks(): Flow<List<DrinkEntity>> {
        return drinkDao.getAllDrinks()
    }

    fun getRecommendedDrinks(): Flow<List<DrinkEntity>> {
        return drinkDao.getRecommendedDrinks()
    }

    fun getDrinksByCategory(category: String): Flow<List<DrinkEntity>> {
        return drinkDao.getDrinksByCategory(category)
    }

    suspend fun getDrinkById(id: String): DrinkEntity? {
        return drinkDao.getDrinkById(id)
    }
}