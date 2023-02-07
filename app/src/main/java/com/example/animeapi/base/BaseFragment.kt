package com.example.animeapi.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequests()
        setupListeners()
        setupSubscribes()
    }

    protected open fun initialize() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupSubscribes() {
    }
}