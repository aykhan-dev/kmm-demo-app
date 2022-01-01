package com.example.kmm_demo.android.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kmm_demo.android.databinding.ItemPostBinding
import com.example.kmm_demo.pojo.PostPOJO

class PostsListAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private val _data = mutableListOf<PostPOJO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.buildIn(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    override fun getItemCount(): Int = _data.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<PostPOJO>) {
        this._data.clear()
        this._data.addAll(data)
        notifyDataSetChanged()
    }

}

class PostViewHolder private constructor(
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun buildIn(parent: ViewGroup): PostViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemPostBinding.inflate(inflater, parent, false)
            return PostViewHolder(binding)
        }

    }

    fun bind(item: PostPOJO) = with(binding) {
        title.text = item.title
        body.text = item.body
    }

}