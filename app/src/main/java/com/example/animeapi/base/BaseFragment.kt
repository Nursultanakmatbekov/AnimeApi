package com.example.animeapi.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.animeapi.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        setupSubscribes()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupSubscribes() {
    }

    protected open fun <T> Flow<Resources<T>>.subscribe(
        state: ((state: Resources<T>) -> Unit)? = null,
        onError: (error: String) -> Unit,
        onSuccess: ((data: T) -> Unit)
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resources.Error -> onError(it.message.toString())
                    is Resources.Loading -> {}
                    is Resources.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}