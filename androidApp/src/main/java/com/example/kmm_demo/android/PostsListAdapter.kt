package com.example.kmm_demo.android

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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

class PostViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {

        fun buildIn(parent: ViewGroup): PostViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return PostViewHolder(inflater.inflate(R.layout.item_post, parent, false))
        }

    }

    fun bind(item: PostPOJO) = with(itemView) {
        findViewById<TextView>(R.id.title).text = item.title
        findViewById<TextView>(R.id.body).text = item.body
    }

}