package com.himawanmasyaid.scoreboardandroid.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.himawanmasyaid.scoreboardandroid.common.getLocale
import com.himawanmasyaid.scoreboardandroid.common.setLocale
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivitySplashBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseActivity
import com.himawanmasyaid.scoreboardandroid.ui.main.MainActivity

class SplashActivity : BaseActivity () {

    private val binding by viewBinding(ActivitySplashBinding::inflate)
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startObserve()
        setLocale(this, getLocale())

    }

    private fun startObserve() {

        viewModel.splashState.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

}