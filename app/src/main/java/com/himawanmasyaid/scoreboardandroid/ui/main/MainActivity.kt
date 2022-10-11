package com.himawanmasyaid.scoreboardandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityMainBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {



    }

}