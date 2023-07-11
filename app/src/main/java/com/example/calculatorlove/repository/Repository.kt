package com.example.calculatorlove.repository

import androidx.lifecycle.MutableLiveData
import com.example.calculatorlove.data.remote.LoveApi
import com.example.calculatorlove.data.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val loveApi: LoveApi) {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        loveApi.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return mutableLiveData
    }

}