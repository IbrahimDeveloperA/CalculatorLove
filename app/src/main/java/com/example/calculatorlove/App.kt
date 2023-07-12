package com.example.calculatorlove

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calculatorlove.data.local.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application()