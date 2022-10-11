package com.himawanmasyaid.scoreboardandroid.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.scoreboardandroid.model.SportModel
import com.himawanmasyaid.scoreboardandroid.model.getSportListData
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    val sportState = MutableLiveData<List<SportModel>>()

    fun getSports() {
        viewModelScope.launch {
            val response = getSportListData()
            sportState.postValue(response)
        }
    }

}