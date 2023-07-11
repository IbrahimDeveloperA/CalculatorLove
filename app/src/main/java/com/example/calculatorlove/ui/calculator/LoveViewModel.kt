package com.example.calculatorlove.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorlove.data.remote.LoveModel
import com.example.calculatorlove.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(
    private var repository: Repository
) : ViewModel() {

    fun getLoveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}