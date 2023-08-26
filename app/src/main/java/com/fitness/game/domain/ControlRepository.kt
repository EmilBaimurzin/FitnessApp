package com.fitness.game.domain

import com.fitness.game.data.data_base.Database
import com.fitness.game.data.data_base.ProductDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ControlRepository {
    suspend fun getProducts(): List<Product> {
        return suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.Default).launch {
                val products = Database.instance.dao().getProducts()
                val newProducts = mutableListOf<Product>()
                products.forEach {
                    newProducts.add(Product(it.id, it.name, it.calories))
                }
                continuation.resume(newProducts)
            }
        }
    }

    suspend fun addProduct(product: Product) {
        withContext(Dispatchers.Default) {
            Database.instance.dao().addProduct(ProductDB(0, product.name, product.calories))
        }
    }

    suspend fun deleteProduct(id: Int) {
        withContext(Dispatchers.Default) {
            Database.instance.dao().deleteProduct(id)
        }
    }
}