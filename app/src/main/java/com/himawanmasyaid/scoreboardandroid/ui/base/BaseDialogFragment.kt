package com.himawanmasyaid.scoreboardandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<VBinding: ViewBinding>
    (val inflate: CustomInflate<VBinding>) : androidx.fragment.app.DialogFragment() {

    protected lateinit var binding: VBinding

    var acceptActionListener: () -> Unit = {}
    var cancelActionListener: () -> Unit = {}
    var closeActionListener: () -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    fun setListener(
        acceptActionListener: () -> Unit = { dismiss() },
        cancelActionListener: () -> Unit = { dismiss() },
        closeActionListener: () -> Unit = { dismiss() },
    ) {
        this.acceptActionListener = acceptActionListener
        this.cancelActionListener = cancelActionListener
        this.closeActionListener = closeActionListener
    }

}