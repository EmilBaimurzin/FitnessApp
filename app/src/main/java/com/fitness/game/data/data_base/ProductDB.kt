package com.fitness.game.data.data_base

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PRODUCT")
data class ProductDB (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val calories: Int
)