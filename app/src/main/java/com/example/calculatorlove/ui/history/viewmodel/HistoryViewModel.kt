package com.example.calculatorlove.ui.history.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculatorlove.data.remote.LoveModel
import com.example.calculatorlove.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getData():List<LoveModel>{
        return repository.getData()
    }

    fun deleteData(loveModel: LoveModel){
        repository.deleteData(loveModel)
    }
}