package com.himawanmasyaid.scoreboardandroid.ui.dialog

import android.os.Bundle
import android.view.View
import com.himawanmasyaid.scoreboardandroid.databinding.DialogConfirmBinding
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseDialogFragment

class ConfirmDialog(
    private val title: String,
    private val message: String
) : BaseDialogFragment<DialogConfirmBinding>(DialogConfirmBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false

        initView()
        initListener()

    }

    private fun initView() {

        with(binding) {
            tvTitle.text = title
            tvMessage.text = message
        }

    }

    private fun initListener() {

        with(binding) {

            btnAccept.setOnClickListener {
                acceptActionListener()
                dismiss()
            }

            btnDismiss.setOnClickListener {
                closeActionListener()
                dismiss()
            }

        }

    }

}