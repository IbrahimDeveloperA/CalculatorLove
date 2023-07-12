package com.example.calculatorlove.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_list")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
):Serializable