package com.himawanmasyaid.scoreboardandroid.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityScoreBoardBinding
import com.himawanmasyaid.scoreboardandroid.model.state.ViewState
import com.himawanmasyaid.scoreboardandroid.ui.score.adapter.ScoreAdapter

class ScoreBoardActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityScoreBoardBinding::inflate)
    private val viewModel by viewModels<ScoreBoardViewModel>()

    private val adapterScoreFirstPlayer by lazy(LazyThreadSafetyMode.NONE) {
        ScoreAdapter()
    }

    private val adapterScoreSecondPlayer by lazy(LazyThreadSafetyMode.NONE) {
        ScoreAdapter()
    }

    companion object {
        const val SPORT_ID_ARGS: String = "SPORT_ID_ARGS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sportId = intent.getIntExtra(SPORT_ID_ARGS, 0)
        initView()
        initListener()
        startObserve()
        viewModel.getScoreBoardBySportId(sportId)

    }

    private fun initView() {

        with(binding.viewPagerPlayer1) {
            offscreenPageLimit = 1
            adapter = adapterScoreSecondPlayer
        }

        with(binding.viewPagerPlayer2) {
            offscreenPageLimit = 1
            adapter = adapterScoreSecondPlayer
        }

    }

    private fun initListener() {

        binding.ivClose.setOnClickListener {
            finish()
        }

        binding.ivSwipeScorePlayer1.setOnClickListener {
            // update slider
            with(binding.viewPagerPlayer1) {
                setCurrentItem(currentItem + 1, true)
            }
        }

        binding.ivSwipeScorePlayer2.setOnClickListener {
            // update slider
            with(binding.viewPagerPlayer2) {
                setCurrentItem(currentItem + 1, true)
            }
        }

    }

    private fun startObserve() {

        viewModel.scoreBoardState.observe(this) {
            when (it) {
                is ViewState.Loading -> {

                }
                is ViewState.Success -> {

                    adapterScoreFirstPlayer.clear()
                    adapterScoreSecondPlayer.clear()

                    adapterScoreFirstPlayer.insertAll(it.data.scoreList)
                    adapterScoreSecondPlayer.insertAll(it.data.scoreList)

                }
                is ViewState.Error -> {

                }
            }
        }


    }

}