package com.himawanmasyaid.scoreboardandroid.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityScoreBoardBinding
import com.himawanmasyaid.scoreboardandroid.ui.score.adapter.ScoreFirstPlayerAdapter

class ScoreBoardActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityScoreBoardBinding::inflate)
    private val viewModel by viewModels<ScoreBoardViewModel>()

    private val adapterScoreFirstPlayer by lazy(LazyThreadSafetyMode.NONE) {
        ScoreFirstPlayerAdapter()
    }

    private val adapterScoreSecondPlayer by lazy(LazyThreadSafetyMode.NONE) {
        ScoreFirstPlayerAdapter()
    }

    companion object {
        const val SPORT_ID_ARGS : String = "SPORT_ID_ARGS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sportId = intent.getIntExtra(SPORT_ID_ARGS, 0)
        initView()
        initListener()
        viewModel.getScoreBoardBySportId(sportId)

    }

    private fun initView() {

        with(binding.recyclerPlayer1) {
            adapter = adapterScoreFirstPlayer
            apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

        with(binding.recyclerPlayer2) {
            adapter = adapterScoreSecondPlayer
            apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

    }

    private fun initListener() {

        binding.ivClose.setOnClickListener {
            finish()
        }

    }

    private fun startObserve() {

    }

}