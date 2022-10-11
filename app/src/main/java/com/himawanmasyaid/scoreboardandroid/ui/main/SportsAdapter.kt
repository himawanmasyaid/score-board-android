package com.himawanmasyaid.scoreboardandroid.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.himawanmasyaid.scoreboardandroid.R
import com.himawanmasyaid.scoreboardandroid.common.convertSecondToMinutes
import com.himawanmasyaid.scoreboardandroid.databinding.ItemSportsBinding
import com.himawanmasyaid.scoreboardandroid.model.SportModel

class SportsAdapter : RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    var listData: MutableList<SportModel> = ArrayList()

    fun insertAll(data: List<SportModel>) {
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
            ItemSportsBinding.inflate(
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

    inner class ViewHolder(val binding: ItemSportsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTo(it: SportModel) {

            with(binding) {

                tvSportName.text = it.name

                tvSportDesc.text = if (it.is_have_time_duration) {
                    val minutes = it.total_time_duration.convertSecondToMinutes()
                    itemView.context.getString(R.string.total_game_duration, minutes.toString())
                } else {
                    itemView.context.getString(R.string.total_game_score, it.total_score.toString())
                }

                if (it.image != 0) {
                    ivIcon.setImageResource(it.image)
                }
            }

        }

    }

}