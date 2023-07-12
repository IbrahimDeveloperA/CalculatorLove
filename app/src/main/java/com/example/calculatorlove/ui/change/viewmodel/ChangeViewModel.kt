package com.example.calculatorlove.ui.change.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculatorlove.data.remote.LoveModel
import com.example.calculatorlove.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChangeViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    fun updateData(loveModel: LoveModel){
        repository.updateData(loveModel)
    }

}