package com.himawanmasyaid.scoreboardandroid.ui.score.dialog

import android.os.Bundle
import android.view.View
import com.himawanmasyaid.scoreboardandroid.databinding.DialogGameOverBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseDialogFragment

class GameOverDialog : BaseDialogFragment<DialogGameOverBinding>(DialogGameOverBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false

    }
}