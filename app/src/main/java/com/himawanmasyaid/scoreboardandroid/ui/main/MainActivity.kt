package com.himawanmasyaid.scoreboardandroid.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.viewBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ActivityMainBinding
import com.himawanmasyaid.scoreboardandroid.model.SportModel
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseActivity
import com.himawanmasyaid.scoreboardandroid.ui.score.ScoreBoardActivity

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        SportsAdapter(
            ::onDirectScoreBoard
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        startObserve()
        viewModel.getSports(this)

    }

    private fun initView() {

        with(binding.recyclerView) {
            adapter = this@MainActivity.adapter
            apply {
                isNestedScrollingEnabled = false
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

    }

    private fun startObserve() {

        viewModel.sportState.observe(this) {
            adapter.insertAll(it)
        }

    }

    private fun onDirectScoreBoard(sport: SportModel) {
        val intent = Intent(this, ScoreBoardActivity::class.java)
        intent.putExtra(ScoreBoardActivity.SPORT_ID_ARGS, sport.id)
        startActivity(intent)
    }

}