package com.example.koffi.Database.Drink

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinks")
    fun getAllDrinks(): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM drinks WHERE category = :category")
    fun getDrinksByCategory(category: String): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM drinks WHERE isRecommended = 1")
    fun getRecommendedDrinks(): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM drinks WHERE id = :id LIMIT 1")
    suspend fun getDrinkById(id: String): DrinkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: DrinkEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: List<DrinkEntity>)

    @Query("SELECT COUNT(*) FROM drinks")
    suspend fun getDrinkCount(): Int
}