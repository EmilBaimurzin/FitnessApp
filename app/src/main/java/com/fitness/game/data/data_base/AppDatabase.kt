package com.fitness.game.data.data_base

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): ProductDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }
}