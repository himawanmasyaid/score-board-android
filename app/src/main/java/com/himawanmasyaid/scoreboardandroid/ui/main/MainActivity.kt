package com.himawanmasyaid.scoreboardandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityMainBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        startObserve()
        viewModel.getSports()

    }

    private fun initView() {

    }

    private fun startObserve() {

        viewModel.sportState.observe(this) {
            setLog("total data : ${it.size}")
        }

    }

    private fun setLog(msg: String) {
        Log.e("main", msg)
    }

}