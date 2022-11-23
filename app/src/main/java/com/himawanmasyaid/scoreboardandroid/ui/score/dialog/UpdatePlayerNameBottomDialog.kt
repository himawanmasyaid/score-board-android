package com.himawanmasyaid.scoreboardandroid.ui.score.dialog

import android.os.Bundle
import android.view.View
import com.himawanmasyaid.scoreboardandroid.common.afterTextChanged
import com.himawanmasyaid.scoreboardandroid.databinding.DialogBottomUpdatePlayerNameBinding
import com.himawanmasyaid.scoreboardandroid.model.PlayerNameModel
import com.himawanmasyaid.scoreboardandroid.ui.base.BaseBottomDialogFragment

class UpdatePlayerNameBottomDialog(
    private val player1NameString: String,
    private val player2NameString: String
) : BaseBottomDialogFragment<DialogBottomUpdatePlayerNameBinding>(
    DialogBottomUpdatePlayerNameBinding::inflate
) {

    private var isButton1Enabled = false
    private var isButton2Enabled = false

    private val MIN_NAME_LENGTH = 2

    lateinit var onClickItem: OnUpdatePlayerNameDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.isCancelable = false

        setView()
        initListener()

    }

    private fun setView() {
        with(binding) {

            etPlayer1.setText(player1NameString)
            etPlayer2.setText(player2NameString)
        }
    }

    private fun initListener() {

        with(binding) {

            ivClose.setOnClickListener {
                dismiss()
            }

            btnSave.setOnClickListener {

                val player1Name = etPlayer1.text.toString()
                val player2Name = etPlayer1.text.toString()

                onClickItem.onItemSelected(
                    PlayerNameModel(
                        player1Name,
                        player2Name
                    )
                )

            }

            etPlayer1.afterTextChanged {

                if (it.length >= MIN_NAME_LENGTH) {
                    isButton1Enabled = true
                    if (isButton1Enabled && isButton2Enabled) {
                        setEnableButton()
                    }
                } else {
                    isButton1Enabled = false
                    setDisableButton()
                }

            }

            etPlayer2.afterTextChanged {
                if (it.length >= MIN_NAME_LENGTH) {
                    isButton2Enabled = true
                    if (isButton1Enabled && isButton2Enabled) {
                        setEnableButton()
                    }
                } else {
                    isButton2Enabled = false
                    setDisableButton()
                }
            }

        }

    }

    private fun setEnableButton() {
        binding.btnSave.isEnabled = true
    }

    private fun setDisableButton() {
        binding.btnSave.isEnabled = false
    }


    interface OnUpdatePlayerNameDialog {
        fun onItemSelected(data: PlayerNameModel)
    }

    fun setOnclick(onClickItem: OnUpdatePlayerNameDialog) {
        this.onClickItem = onClickItem
    }


}