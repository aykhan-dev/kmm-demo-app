package com.example.kmm_demo.android.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kmm_demo.android.databinding.ActivityMainBinding
import com.example.kmm_demo.android.kmm.KMMActivity
import com.example.kmm_demo.pojo.PostPOJO
import com.example.kmm_demo.viewModel.MainViewModel
import com.example.kmm_demo.viewModel.State
import kotlinx.coroutines.launch

class MainActivity : KMMActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override val viewModel = MainViewModel()

    private val postsListAdapter by lazy { PostsListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPosts.adapter = postsListAdapter

        setupFlows()
    }

    override fun setupFlows() {
        super.setupFlows()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchPosts().collect(::configurePosts)
            }
        }
    }

    private fun configurePosts(state: State) {
        when (state) {
            is State.Loading -> binding.pbLoading.visibility = View.VISIBLE
            is State.Result<*> -> {
                binding.pbLoading.visibility = View.GONE

                val data = state.data as? List<PostPOJO> ?: return
                postsListAdapter.submitList(data)
            }
        }
    }

}