package com.example.shoppinglist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<ShopItem>

    @Insert
    suspend fun insertProduct(product: ShopItem)

    @Delete
    suspend fun deleteProduct(product: ShopItem)

    @Query("DELETE FROM product_table")
    suspend fun deleteAllProducts()
}