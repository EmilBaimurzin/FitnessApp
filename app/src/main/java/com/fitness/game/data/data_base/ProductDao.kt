package com.fitness.game.data.data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM PRODUCT")
    fun getProducts(): List<ProductDB>

    @Query("DELETE FROM PRODUCT WHERE id = :id")
    fun deleteProduct(id: Int)

    @Insert
    fun addProduct(product: ProductDB)
}