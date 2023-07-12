package com.example.calculatorlove.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.calculatorlove.data.remote.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM love_list ORDER BY id DESC")
    fun getList(): List<LoveModel>

    @Insert
    fun addData(loveModel: LoveModel)

    @Delete
    fun deleteData(loveModel: LoveModel)

    @Update
    fun updateData(loveModel: LoveModel)
}