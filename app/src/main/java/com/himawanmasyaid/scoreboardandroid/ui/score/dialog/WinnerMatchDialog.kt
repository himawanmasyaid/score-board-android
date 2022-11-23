package com.himawanmasyaid.scoreboardandroid.ui.score.dialog

import android.os.Bundle
import android.view.View
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.databinding.DialogWinnerBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseDialogFragment

class WinnerMatchDialog(
    val winner: String,
    val round: Int
) : BaseDialogFragment<DialogWinnerBinding>(DialogWinnerBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false

        initView()

    }

    private fun initView() {

        with(binding) {

            tvMessage.text = getString(R.string.congratulation_message, winner, round.toString())
            btnContinue.setOnClickListener {
                acceptActionListener()
            }

        }

    }

}