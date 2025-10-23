package com.example.otex_app_test.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.data.local.entities.Recommended
import com.example.otex_app_test.databinding.ViewholderRecommendedBinding

class RecommendedAdapter(
    private val recommendedList: List<Recommended>
) : RecyclerView.Adapter<RecommendedAdapter.ViewHolder>() {
    private lateinit var context: Context
    inner class ViewHolder(private val binding: ViewholderRecommendedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Recommended) {
            binding.pic.setImageResource(item.images)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderRecommendedBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = recommendedList[position]
        holder.bind(currentItem)
    }
    override fun getItemCount(): Int = recommendedList.size
}
