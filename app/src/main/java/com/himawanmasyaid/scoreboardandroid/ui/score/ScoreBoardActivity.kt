package com.himawanmasyaid.scoreboardandroid.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityScoreBoardBinding

class ScoreBoardActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityScoreBoardBinding::inflate)

    companion object {
        const val SPORT_ID_ARGS : String = "SPORT_ID_ARGS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sportId = intent.getIntExtra(SPORT_ID_ARGS, 0)
        initView()

    }

    private fun initView() {

    }

}