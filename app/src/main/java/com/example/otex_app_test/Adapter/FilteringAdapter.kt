package com.example.otex_app_test.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.otex_app_test.R
import com.example.otex_app_test.data.local.entities.Filtering
import com.example.otex_app_test.databinding.ViewholderFilteringBinding
class FilteringAdapter(
    val filtering: MutableList<Filtering>
) : RecyclerView.Adapter<FilteringAdapter.Viewholder>() {
    private lateinit var context: Context
    private var selectedPosition = RecyclerView.NO_POSITION
    inner class Viewholder (val binding: ViewholderFilteringBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(filtering: Filtering,isSelected: Boolean)= with(binding) {

            itemTxt1.text = filtering.name
            itemTxt1.isSelected = isSelected
            if (isSelected) {
                itemTxt1.setTextColor(
                    ContextCompat.getColor(
                        context, R.color.blue_color
                    )
                )
            } else {
                itemTxt1.setTextColor(
                    ContextCompat.getColor(
                        context, R.color.gray_color
                    )
                )
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderFilteringBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem = filtering[position]
        val isSelected = selectedPosition == position
        holder.bind(currentItem, isSelected)

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }
    }
    override fun getItemCount(): Int = filtering.size

    fun resetSelection() {
        selectedPosition = RecyclerView.NO_POSITION
        notifyDataSetChanged()
    }
}
