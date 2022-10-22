package com.himawanmasyaid.scoreboardandroid.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.scoreboardandroid.model.SportModel
import com.himawanmasyaid.scoreboardandroid.model.getSportListData
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    val sportState = MutableLiveData<List<SportModel>>()

    fun getSports(context: Context) {
        viewModelScope.launch {
            val response = getSportListData(context)
            sportState.postValue(response)
        }
    }

}