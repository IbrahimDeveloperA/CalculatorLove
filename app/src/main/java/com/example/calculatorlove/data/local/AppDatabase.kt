package com.example.calculatorlove.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calculatorlove.data.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): LoveDao
}