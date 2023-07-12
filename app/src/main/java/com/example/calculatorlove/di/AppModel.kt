package com.example.calculatorlove.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.calculatorlove.data.local.AppDatabase
import com.example.calculatorlove.data.local.LoveDao
import com.example.calculatorlove.data.remote.LoveApi
import com.example.calculatorlove.ui.onBord.viewmodel.OnBordViewModel.Companion.KEY_PREF
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModel {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }


    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(KEY_PREF, MODE_PRIVATE)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love_list")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun dao(@ApplicationContext context: Context): LoveDao {
        return provideDatabase(context).dao()
    }
}