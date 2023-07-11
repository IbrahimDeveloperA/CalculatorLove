package com.example.calculatorlove.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key:String = "908489a5a0msh8581097b550941ep13c439jsnf591de631a1d",
        @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
    ):Call<LoveModel>

}