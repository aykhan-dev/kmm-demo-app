package com.example.kmm_demo.android.kmm

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kmm_demo.base.BaseViewModel
import com.example.kmm_demo.base.Error
import kotlinx.coroutines.launch

abstract class KMMActivity : AppCompatActivity() {

    abstract val viewModel: BaseViewModel

    protected open fun setupFlows() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.error.collect(::handleError)
            }
        }
    }

    open fun handleError(error: Error?) {
        when (error) {
            is Error.None -> {

            }
            else -> {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onClear()
    }

}