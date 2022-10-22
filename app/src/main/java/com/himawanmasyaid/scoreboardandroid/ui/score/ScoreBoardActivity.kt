package com.himawanmasyaid.scoreboardandroid.ui.score

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityScoreBoardBinding
import com.himawanmasyaid.scoreboardandroid.model.SportModel
import com.himawanmasyaid.scoreboardandroid.model.state.ViewState
import com.himawanmasyaid.scoreboardandroid.ui.dialog.ConfirmDialog
import com.himawanmasyaid.scoreboardandroid.ui.score.adapter.ScoreAdapter
import com.himawanmasyaid.scoreboardandroid.ui.score.dialog.WinnerMatchDialog


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

    private lateinit var sportData: SportModel
    private var totalWinPlayer1 = 0
    private var totalWinPlayer2 = 0
    private var scorePlayer1 = 0
    private var scorePlayer2 = 0
    private var matchRound: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sportId = intent.getIntExtra(SPORT_ID_ARGS, 0)
        initView()
        initListener()
        startObserve()
        viewModel.getScoreBoardBySportId(this, sportId)

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

        setWinnerView(totalWinPlayer1, totalWinPlayer2)

    }

    private fun initListener() {

        with(binding) {

            ivClose.setOnClickListener {
                showExitDialog()
            }

            ivUpdate.setOnClickListener {

            }

            ivSwipeScorePlayer1.setOnClickListener {
                // update slider
                with(binding.viewPagerPlayer1) {
                    setCurrentItem(currentItem + 1, true)
                }
            }

            ivSwipeScorePlayer2.setOnClickListener {
                // update slider
                with(binding.viewPagerPlayer2) {
                    setCurrentItem(currentItem + 1, true)
                }
            }

            viewPagerPlayer1.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(score: Int) {
                    scorePlayer1 = score
                    handleScoreChange(true, score)
                    updateTotalPlayerWon(true, score)
                }
            })

            viewPagerPlayer2.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(score: Int) {
                    scorePlayer2 = score
                    handleScoreChange(false, score)
                    updateTotalPlayerWon(false, score)
                }
            })

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

                    sportData = it.data.sport
                    adapterScoreFirstPlayer.insertAll(it.data.scoreList)
                    adapterScoreSecondPlayer.insertAll(it.data.scoreList)

                }
                is ViewState.Error -> {

                }
            }
        }

    }

    private fun showExitDialog() {
        val dialog = ConfirmDialog(
            title = getString(R.string.exit_game),
            message = getString(R.string.exit_game_desc)
        )
        dialog.show(supportFragmentManager, "dialog")
        dialog.setListener(
            acceptActionListener = {
                finish()
            }
        )
    }

    private fun showWinnerDialog(isPlayer1Won: Boolean) {

        val dialog = WinnerMatchDialog(
            winner = if (isPlayer1Won) binding.tvPlayer1.text.toString() else binding.tvPlayer2.text.toString(),
            round = matchRound
        )
        dialog.show(supportFragmentManager, "dialog")
        dialog.setListener(
            acceptActionListener = {
                matchRound += 1
                resetScore()
                dialog.dismiss()
            }
        )

    }

    private fun handleScoreChange(isPlayer1Won: Boolean, score: Int) {

        sportData.total_score.let {
            if (it == score) {
                // match winner
                showWinnerDialog(isPlayer1Won)
            } else if (it - 1 == scorePlayer1 && it - 1 == scorePlayer2) {
                // draw score match
                binding.viewPagerPlayer1.setCurrentItem(it - 2, true)
                binding.viewPagerPlayer2.setCurrentItem(it - 2, true)
            }
        }

    }

    private fun updateTotalPlayerWon(isPlayer1: Boolean, score: Int) {

        if (sportData.total_score == score) {
            if (isPlayer1) {
                totalWinPlayer1 += 1
            } else {
                totalWinPlayer2 += 1
            }
        }

        binding.tvSet.text = "$totalWinPlayer1 : $totalWinPlayer2"

    }

    private fun resetScore() {
        binding.viewPagerPlayer1.setCurrentItem(0, true)
        binding.viewPagerPlayer2.setCurrentItem(0, true)
    }

    private fun setWinnerView(player1: Int, player2: Int) {
        binding.tvSet.text = "$player1 : $player2"
    }

}