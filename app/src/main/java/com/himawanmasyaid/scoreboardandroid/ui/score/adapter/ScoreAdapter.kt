package com.himawanmasyaid.scoreboardandroid.ui.score.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.himawanmasyaid.scoreboardandroid.databinding.ItemScoreBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ItemScoreBoardBinding
import com.himawanmasyaid.scoreboardandroid.databinding.ItemSportsBinding

class ScoreAdapter: RecyclerView.Adapter<ScoreAdapter.ViewHolder>() {

    var listData: MutableList<Int> = ArrayList()

    fun insertAll(data: List<Int>) {
        data.forEach {
            listData.add(it)
            notifyItemInserted(listData.size - 1)
        }
    }

    fun clear() {
        if (listData.isNotEmpty()) {
            listData.clear()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemScoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.bindTo(item)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(val binding: ItemScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTo(score: Int) {

            binding.tvScore.text = score.toString()

        }

    }

}