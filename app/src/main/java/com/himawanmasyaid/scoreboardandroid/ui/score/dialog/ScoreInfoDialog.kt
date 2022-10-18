package com.himawanmasyaid.scoreboardandroid.ui.score.dialog

import android.os.Bundle
import android.view.View
import com.himawanmasyaid.scoreboardandroid.databinding.DialogScoreInfoBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseDialogFragment

class ScoreInfoDialog(
    private val title: String,
    private val message: String
) : BaseDialogFragment<DialogScoreInfoBinding>(DialogScoreInfoBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false


    }

    private fun initView() {

    }

    private fun initListener() {

    }

}