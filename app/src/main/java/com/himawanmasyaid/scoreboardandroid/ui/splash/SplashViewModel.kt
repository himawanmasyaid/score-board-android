package com.himawanmasyaid.scoreboardandroid.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(): ViewModel() {

    val splashState = MutableLiveData<Boolean>()

    init {
        startSplash()
    }

    fun startSplash() {
        viewModelScope.launch {
            delay(2000)
            splashState.postValue(true)
        }
    }

}