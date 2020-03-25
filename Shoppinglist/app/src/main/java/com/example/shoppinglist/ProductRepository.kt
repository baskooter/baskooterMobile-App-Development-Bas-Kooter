package com.example.shoppinglist

import android.content.Context

class ProductRepository(context: Context) {

    private val productDao: ProductDao

    init {
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<ShopItem> = productDao.getAllProducts()

    suspend fun insertProduct(product: ShopItem) = productDao.insertProduct(product)

    suspend fun deleteProduct(product: ShopItem) = productDao.deleteProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()

}
